package com.hello.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义注解
 * @author Arien
 *
 */
@Retention(RetentionPolicy.RUNTIME)
/*
  ＠Target里面的ElementType是用来指定Annotation类型可以用在哪一些元素上的.
  说明一下：TYPE(类型), FIELD(属性), METHOD(方法), PARAMETER(参数), 
  CONSTRUCTOR(构造函数),LOCAL_VARIABLE(局部变量), ANNOTATION_TYPE,PACKAGE(包),
  其中的TYPE(类型)是指可以用在Class,Interface,Enum和Annotation类型上. 
 另外,从1的源代码可以看出,@Target自己也用了自己来声明自己,只能用在ANNOTATION_TYPE之上. 
 */
@Target(ElementType.FIELD)   //注解应用于属性
public @interface Column {
	public String value();
}
