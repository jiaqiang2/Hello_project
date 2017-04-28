package com.hello.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.hello.pojo.admin.CommonPo;


public class Util {

	@SuppressWarnings("unchecked")
	public static <T> T mapToObject(Map<String, ?> map, Class<?> clazz) throws InstantiationException, IllegalAccessException {

		Object instance;
		instance = clazz.newInstance();
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			CommonPo.set(instance, key, map.get(key));
		}

		return (T) instance;
	}

	 public static <T> T listOfMapsToListOfObjects(List<Map<String, ?>> listOfMaps, Class<?> clazz) throws InstantiationException, IllegalAccessException{
		 System.out.println(clazz);
		 List<T> list = null;
		 if (listOfMaps != null && !listOfMaps.isEmpty()) {
			 list  = new ArrayList<>();
			 Iterator<Map<String, ?>> iterator = listOfMaps.iterator();
			 while (iterator.hasNext()) {
				Map<String,?> mapOfValues = iterator.next();
				Object instance = mapToObject(mapOfValues, clazz);
				list.add( (T) instance);
			}
			 
		 }
		 
	 return (T) list;
	 }
}
