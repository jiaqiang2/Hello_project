package com.hello.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

import org.apache.commons.collections.MapUtils;


public class MapUtil  extends MapUtils {
	private static Map<String, String> fields = new HashMap<String, String>();
	 
    /**
     * 将Map转换为Object
     * 
     * @param clazz
     *          目标对象的类
     * @param map
     *          待转换Map
     * @return  转换出来的对象
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Object toObject(Class<?> clazz, Map<String, Object> map) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Object object = clazz.newInstance();
        toObject(clazz, object, map);
        return object;
    }
 
    /**
     * Map转对象
     * 
     * @param clazz
     *          目标对象的类
     * @param object
     *          目标对象
     * @param map
     *          待转换Map
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    private static void toObject(Class<?> clazz, Object object, Map<String, Object> map) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
//              try {
                Class<?> fieldType = fields[i].getType();  //Integer
                String fieldName = fields[i].getName();    //id
//                Object fieldValue = map.get(parseHumpToFlat(fieldName).toUpperCase());
                Object fieldValue = map.get(fieldName);
                if (fieldValue != null) {
                    if(fieldValue instanceof BigDecimal){
                        String strFieldValue = ((BigDecimal)fieldValue).toString();
                        fieldValue = strFieldValue;
                    }
                    String setFieldName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method method = clazz.getMethod(setFieldName, fieldType);
                    if (String.class.equals(fieldValue)) {
                        method.invoke(object, fieldValue);
                    } else if (Integer.class.equals(fieldType) || int.class.equals(fieldType)) {
                         method.invoke(object, Integer.parseInt((String)fieldValue));
                    } else if (Long.class.equals(fieldType)) {
                        method.invoke(object, Long.valueOf((String)fieldValue));
                    } else if (Boolean.class.equals(fieldType)) {
                        if ("true".equalsIgnoreCase((String)fieldValue)) {
                            method.invoke(object, Boolean.TRUE);
                        } else {
                            method.invoke(object, Boolean.FALSE);
                        }
                    } else if (Map.class.equals(fieldType)) {
                        if (!String.class.equals(fieldValue.getClass())) {
                            method.invoke(object, fieldValue);
                        }
                    } else {
                        method.invoke(object, fieldValue);
                    }
                }
//              } catch (IllegalAccessException e) {
//                  logger.error(e.getMessage(), e);
//              } catch (InvocationTargetException e) {
//                  logger.error(e.getMessage(), e);
//              } catch (SecurityException e) {
//                  logger.error(e.getMessage(), e);
//              } catch (NoSuchMethodException e) {
//                  logger.error(e.getMessage(), e);
//              }
            }
        }
        if (clazz.getSuperclass() != null) {
            toObject(clazz.getSuperclass(), object, map);
        }
    }
 
    /**
     * 转换为Collection<Map>
     * 
     * @param collection
     *          待转换对象集合
     * @return  转换后的Collection<Map>
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    @SuppressWarnings("rawtypes")
    public static Collection<Map> toMapList(Collection collection) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<Map> retList = new ArrayList<Map>();
        if (collection != null && !collection.isEmpty()) {
            for (Object object : collection) {
                Map<String, String> map = new HashMap<String, String>();
                toMap(object.getClass(), object, map);
                retList.add(map);
            }
        }
        return retList;
    }
 
    /**
     * 转换为Collection,同时为字段做驼峰转换<Map>
     * 
     * @param collection
     *          待转换对象集合
     * @return  转换后的Collection<Map>
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    @SuppressWarnings("rawtypes")
    public static Collection<Map> toMapListForFlat(Collection collection) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<Map> retList = new ArrayList<Map>();
        if (collection != null && !collection.isEmpty()) {
            for (Object object : collection) {
                Map<String, String> map = new HashMap<String, String>();
                toMapForFlat(object.getClass(), object, map);
                retList.add(map);
            }
        }
        return retList;
    }
     
    /**
     * 对象转Map,但不提供字段名转换
     * 
     * @param clazz
     *          目标对象所在类
     * @param object
     *          目标对象
     * @param map
     *          待转换Map
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    public static Map<String, String> toMap(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String, String> map = new HashMap<String, String>();
        toMap(object.getClass(), object, map);
        return map;
    }
     
    /**
     * 转换成Map并提供字段命名驼峰转平行
     * 
     * @param clazz
     *          目标对象所在类
     * @param object
     *          目标对象
     * @param map
     *          待转换Map
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    public static Map<String, String> toMapForFlat(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String, String> map = new HashMap<String, String>();
        toMapForFlat(object.getClass(), object, map);
        return map;
    }
 
    /**
     * 对象转Map,但不提供字段名转换
     * 
     * @param clazz
     *          目标对象所在类
     * @param object
     *          目标对象
     * @param map
     *          待转换Map
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    private static void toMap(Class<?> clazz, Object object, Map<String, String> map) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                String fieldName = fields[i].getName();
                String fieldValue = org.apache.commons.beanutils.BeanUtils.getProperty(object, fieldName);
                if (fieldValue != null) {
                    map.put(fieldName, fieldValue);
                }
            }
        }
        if (clazz.getSuperclass() != null) {
            toMap(clazz.getSuperclass(), object, map);
        }
    }
 
    /**
     * 转换成Map并提供字段命名驼峰转平行
     * 
     * @param clazz
     *          目标对象所在类
     * @param object
     *          目标对象
     * @param map
     *          待转换Map
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    private static void toMapForFlat(Class<?> clazz, Object object, Map<String, String> map) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
//              try {
                String fieldName = fields[i].getName();
                String fieldValue = org.apache.commons.beanutils.BeanUtils.getProperty(object, fieldName);
//              Object fieldValue = BeanUtils.getFieldValue(object, fieldName);
                if (fieldValue != null) {
                    fieldName = parseHumpToFlat(fieldName);
                    map.put(fieldName, fieldValue);
                }
//              } catch (IllegalAccessException e) {
//                  logger.error(e.getMessage(), e);
//              } catch (InvocationTargetException e) {
//                  logger.error(e.getMessage(), e);
//              } catch (NoSuchMethodException e) {
//                  logger.error(e.getMessage(), e);
//              }
            }
        }
        if (clazz.getSuperclass() != null) {
            toMap(clazz.getSuperclass(), object, map);
        }
    }
     
    /**
     * 把驼峰命名的字符串转换成带下划线的字符串(例:branchNo -> branch_no)
     * 
     * @param name 
     *          待转换的字符串
     * @return 转换后的字符串
     */
    private static String parseHumpToFlat(String name) {
        String value = fields.get(name);
//        if (value == null) {
//            value = FieldFormatUtil.parseHumpToFlat(name);
//            fields.put(name, value);
//        }
        return value;
    }
 
}

