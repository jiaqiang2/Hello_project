package com.hello.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;




import com.hello.annotation.Column;
import com.hello.pojo.admin.Admin;



/**
 * bean转成map工具
 */
public class BeanToMapUtil {

    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws java.beans.IntrospectionException
     *             如果分析类属性失败
     * @throws IllegalAccessException
     *             如果实例化 JavaBean 失败
     * @throws InstantiationException
     *             如果实例化 JavaBean 失败
     * @throws java.lang.reflect.InvocationTargetException
     *             如果调用属性的 setter 方法失败
     */
	public static Object convertMap(Class type,
            Map map) throws IntrospectionException, IllegalAccessException,
                     InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象
		
		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		System.out.println(propertyDescriptors.length);
		for( PropertyDescriptor descriptor : propertyDescriptors){
		String propertyName = descriptor.getName();
		if (map.containsKey(propertyName)) {
		// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
		Object value = map.get(propertyName);
		Object[] args = new Object[1];
		args[0] = value;
		descriptor.getWriteMethod().invoke(obj, args);
		}
		}
		return obj;
	}
    public static Object toObject(Class clazz,
            Map map) throws IntrospectionException, IllegalAccessException,
                     InstantiationException, InvocationTargetException {
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(fields.length);
		Object object = clazz.newInstance(); // 创建 JavaBean 对象
		
		for (Field field : fields) {
			String name = null;
			//System.out.println(field.getName());
			Column column = field.getAnnotation(Column.class);
			System.out.println(field.getName() + "  " + column);
			
			if(field.isAnnotationPresent(Column.class)){
				System.out.println("");
				name = field.getAnnotation(Column.class).value();
			}else{
				name = field.getName();
			}
			
			Class<?> type = field.getType();
			Object value = map.get(name);
			//法1
			field.setAccessible(true);
			field.set(object, value);
			//法2
//			try {
//				Method method = object.getClass().getMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1), type);
//				method.invoke(object, value);
//			} catch (NoSuchMethodException | SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}
		}
		
		
		return object;
	}
    public static void main(String[] args) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("", 1);
    	map.put("username", "aa");
    	map.put("password", "bb");
    	try { 
			Admin a= (Admin) toObject(Admin.class, map);
			System.out.println(a);
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException
				| IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws java.beans.IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws java.lang.reflect.InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings("all")
    public static Map convertBean(Object bean) throws IntrospectionException,
                                               IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for ( PropertyDescriptor descriptor:propertyDescriptors) {
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
}
