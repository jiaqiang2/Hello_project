package com.hello.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.hello.annotation.Column;
import com.hello.pojo.admin.Admin;

/**
 * 三种方式将 Map 与 JavaBean 之间转换
 * @author Arien
 * @date 2016-12-22 下午03:19:37 
 */
public class Bean_Map_Util {

	private static Log logger = LogFactory.getLog(Bean_Map_Util.class);
	
	/**
	 * @param clazz 目标对象 JavaBean 类型
	 * @param map 以 JavaBean 的属性作为 key 的 map
	 * @return  转化完成的  JavaBean 对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * 若是 JavaBean 属性与数据库中的列名称不同，可根据自定义注解进行解析
	 */
	public static Object reflect_convertMap1(Class<?> clazz, Map<String, Object> map)
			throws InstantiationException, IllegalAccessException {
		if (map == null)  
            return null;
		
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String propertyName = field.getName();
			String columnName = getColumnName(field, propertyName);
			Object value = map.get(columnName);
			int mod = field.getModifiers();    
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                continue;    
            }  
			field.setAccessible(true);
			field.set(obj, value);
		}
		return obj;
	}
	
	/**
	 * @param clazz 目标对象 JavaBean 类型
	 * @param map 以 JavaBean 的属性作为 key 的 map
	 * @return  转化完成的  JavaBean 对象
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * 若是 JavaBean 属性与数据库中的列名称不同，可根据自定义注解进行解析
	 */
	public static Object reflect_convertMap2(Class<?> clazz, Map<String, Object> map)
			throws IllegalArgumentException, InvocationTargetException, IllegalAccessException, SecurityException {
		if (map == null)  
            return null; 
		
		Object obj = null;
		String propertyName = "";
		try {
			obj = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				propertyName = field.getName();
				Class<?> type = field.getType();
				String columnName = getColumnName(field, propertyName);
				Object value = map.get(columnName);
				int mod = field.getModifiers();    
	            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
	                continue;    
	            }  
				Method method = clazz.getMethod(getMethodName(propertyName), type);
				method.invoke(obj, value);
			}
		} catch (InstantiationException e) {
			String errorMsg = "This Class represents an abstract class, interface, array class, basic type, or void;"
					+ "or the class does not have a null construction method";
			runtimeException(e, errorMsg);
		} catch (NoSuchMethodException e) {
			String errorMsg = "The method " + getMethodName(propertyName) + " does not exist!";
			runtimeException(e, errorMsg);
		}
		return obj;
	}
	
	/**
	 * @param obj JavaBean 源对象
	 * @return 以 JavaBean 的属性作为 key 的 目标对象
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> reflect_convertObject(Object obj)
			throws IllegalArgumentException, IllegalAccessException{
		if(obj == null)    
            return null;    
        
		Map<String, Object> map = new HashMap<String, Object>(); 
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			String propertyName = field.getName();
			field.setAccessible(true);
			Object value = field.get(obj);
            map.put(propertyName, value);
		}
		return map;
	}
	
	/**
	 * @param clazz 目标对象 JavaBean 类型
	 * @param map 以 JavaBean 的属性作为 key 的 map
	 * @return  转化完成的  JavaBean 对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object introspector_convertMap(Class<?> clazz, Map<String, Object> map)
			throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
		if (map == null)  
            return null; 
		
		Object obj = clazz.newInstance();
		BeanInfo BeanInfo = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] PropertyDescriptors = BeanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : PropertyDescriptors) {
			String propertyName = propertyDescriptor.getName();
			if (propertyName.compareToIgnoreCase("class") == 0) {   
                continue;  
            } 
			if (map.containsKey(propertyName)) {
				Method setter = propertyDescriptor.getWriteMethod();    
	            if (setter != null) {  
	                setter.invoke(obj, map.get(propertyName));   
	            }  
			}
		}
		return obj;
	}
	
	/**
	 * @param obj JavaBean 源对象
	 * @return 以 JavaBean 的属性作为 key 的 目标对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> introspector_convertObject(Object obj)
			throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
		if (obj == null)  
            return null; 
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		BeanInfo BeanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] PropertyDescriptors = BeanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : PropertyDescriptors) {
			String propertyName = propertyDescriptor.getName();
			Object value = propertyDescriptor.getReadMethod() != null ? propertyDescriptor.getReadMethod().invoke(obj) : null;
			map.put(propertyName, value);
		}
		return map;
	}
	
	/**
	 * @param clazz 目标对象 JavaBean 类型
	 * @param map map 以 JavaBean 的属性作为 key 的 map
	 * @return  转化完成的  JavaBean 对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object beanutils_convertMap(Class<?> clazz, Map<String, Object> map)
			throws InstantiationException, IllegalAccessException, InvocationTargetException{
		if (map == null)
			return null;
		
		Object obj = clazz.newInstance();  
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);  
		return obj;
	}
	
	/**
	 * 
	 * @param obj JavaBean 源对象
	 * @return 以 JavaBean 的属性作为 key 的 目标对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map<Object, Object> beanutils_convertObject(Object obj)
			throws InstantiationException, IllegalAccessException, InvocationTargetException{
		if (obj == null)
			return null;
		
		return new org.apache.commons.beanutils.BeanMap(obj);
	}
	
	/**
	 * @param listOfMaps 由Map组成的List集合
	 * @param clazz 由此类组成的List集合(目标对象)
	 * @return List集合
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 */
	@SuppressWarnings({ "unchecked", "null", "rawtypes" })
	public static  List convertListOfMaps(List<Map<String, Object>> listOfMaps, Class<?> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
		if(listOfMaps == null && listOfMaps.isEmpty())
			return null;
		
		List list = new ArrayList<>();
		Iterator<Map<String, Object>> iterator = listOfMaps.iterator();
		while(iterator.hasNext()){
			Map<String, Object> map = iterator.next();
			Object obj =  reflect_convertMap2(clazz, map);
			System.out.println("0000       " + obj);
			list.add(obj);
		}
		return list;
	}
	
	
	/**
	 * @param propertyName JavaBean 中的属性名称 
	 * @return setter方法名称
	 */
	public static String getMethodName(String propertyName) {
		return "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
	}
	
	/**
	 * @param e 抛出的异常
	 * @param errorMsg 控制台输出的错误信息
	 */
	public static void runtimeException(Exception e, String errorMsg) {
		logger.error(errorMsg, e);
		throw new RuntimeException(errorMsg);
	}
	
	/**
	 * @param field JavaBean 中的属性
	 * @param propertyName JavaBean 中的属性名称
	 * @return JavaBean 中的属性对应的数据库中的列名
	 */
	public static String getColumnName(Field field, String propertyName) {
		return field.isAnnotationPresent(Column.class) ? field.getAnnotation(Column.class).value() : propertyName;
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException, SecurityException, InstantiationException, IntrospectionException {
    	Map<String, Object> map1 = new HashMap<String, Object>();
    	map1.put("", 1);
    	map1.put("user", "1");
    	map1.put("password", "11");
    	Map<String, Object> map2 = new HashMap<String, Object>();
    	map2.put("", 2);
    	map2.put("user", "2");
    	map2.put("password", "22");
    	Map<String, Object> map3 = new HashMap<String, Object>();
    	map3.put("", 3);
    	map3.put("user", "3");
    	map3.put("password", "33");
    	List<Map<String,Object>> list = new ArrayList<>();
    	List list2 = new ArrayList<>();
    	list.add(map1);
    	list.add(map2);
    	list.add(map3);
    	try { 
			Admin a= (Admin) beanutils_convertMap(Admin.class, map1);
			list2 = convertListOfMaps(list, Admin.class);
			System.out.println(list2);
			for (Object object : list2) {
				System.out.println(object);
			}
			System.out.println(a);
		} catch (IllegalAccessException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
