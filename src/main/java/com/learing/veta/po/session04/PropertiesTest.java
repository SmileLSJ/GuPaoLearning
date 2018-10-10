package com.learing.veta.po.session04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesTest {

	
	@Test
	public void test(){
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("classpath:applicationContext_properties.xml");
		Student bean = context.getBean("student1",Student.class);
		System.out.println(bean.toString());
	}
}
