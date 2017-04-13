package com.hello.pojo.admin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.text.StrBuilder;

import com.hello.annotation.Column;



public abstract class CommonPo {

	/**
	 * @return 通过pojo必有的Table注解来确定表的名称
	 */
	public String getTableName() {
		Column table = this.getClass().getAnnotation(Column.class);
		return table.value();
	}

	/**
	 * @param columns
	 *            - 数据库表的列名。 因为表的每一列名跟pojo的属性名是一致的所以可以通过属性名来构建sql语句
	 * @param values
	 *            － 通过ONGL来获取属性的值
	 */
//	public void getColumnsAndValues(StringBuilder columns, StrBuilder values) {
//		// 获取当前累的所有属性
//		Field[] fields = this.getClass().getDeclaredFields();
//
//		for (Field field : fields) {
//			// 因为表的主键是自动生产的所以这里不用表的主键来生产sql语句
//			if (field.getAnnotation(PrimaryKey.class) == null) {
//				String name = field.getName();
//				columns.append(name + ", "); //
//				values.append("#{" + name + "}, ");
//			}
//		}
//
//		columns.deleteCharAt(columns.lastIndexOf(","));
//		values.deleteCharAt(values.lastIndexOf(","));
//	}

	/**
	 * @return - 返回带PrimaryKey 注解的属性名。 用来写sql语句的where条件
	 *         如果所有的属性都没用PrimaryKey注解来表示的话就返回null
	 */
//	public String getPrimaryKey() {
//		// 获取当前累的所有属性
//		Field[] fields = this.getClass().getDeclaredFields();
//		for (Field field : fields) {
//			if (field.getAnnotation(PrimaryKey.class) != null) {
//				return field.getName();
//			}
//		}
//
//		return null;
//	}

	/**
	 * @return - 返回sql语句里边的要修改的内容
	 */
//	public String getSets() {
//		StringBuilder builder = new StringBuilder();
//
//		// 获取当前累的所有属性
//		Field[] fields = this.getClass().getDeclaredFields();
//		for (Field field : fields) {
//			if (field.getAnnotation(PrimaryKey.class) == null) {
//				String name = field.getName();
//				builder.append(name + " = #{" + name + "}, ");
//			}
//		}
//		builder.deleteCharAt(builder.lastIndexOf(","));
//
//		return builder.toString();
//	}

	public Object get(String key) {
		Object object = null;
		try {
			Field field = this.getClass().getDeclaredField(key);
			field.setAccessible(true);
			object = field.get(this);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}

	public static void set(Object obj, String name, Object value) {
		String fieldName = null;
		try {
			Field field = obj.getClass().getDeclaredField(name);
			fieldName = field.getName();
			System.out.println("ok... ");
		} catch (NoSuchFieldException e) {
			System.err.println("NoSuchFieldException... ");
			
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				Column column = field.getAnnotation(Column.class);
				if (column != null && column.value().equals(name)) {
					fieldName = field.getName();
				}
			}
		}

		if (fieldName != null) {
			setField(obj, fieldName, value);
		}
	}

	public static void setField(Object obj, String fieldName, Object value) {

		String setterName = getSetterName(fieldName);
		System.out.println(setterName);
		

		try {

			Method setter = obj.getClass().getDeclaredMethod(setterName, value.getClass());
			setter.invoke(obj, value);
			
		} catch (NoSuchMethodException e) {
			System.err.println("The method " + setterName + " does not exist!");
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.err.println("The method " + setterName + " does not exist! ");
		// e.printStackTrace();

	}

	public static String getSetterName(String fieldName) {
		return "set" + fieldName.replaceFirst("" + fieldName.charAt(0), fieldName.substring(0, 1).toUpperCase());
	}
}
