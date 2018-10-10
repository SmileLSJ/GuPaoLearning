package com.learing.veta.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class test {

	@Test
	public void testReflect(){
		try {
			Class<?> clazz = Class.forName(Student.class.getName());
			Student std = (Student) clazz.newInstance();
			System.out.println(std.toString());
			
			//静态成员的set和get方法可以不写具体类
			Field field = clazz.getField("name");
			field.set(null, "小明");
			System.out.println(std.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
