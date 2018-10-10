package com.learing.veta.po.session02_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDPlayerTest {

	
	@Test
	public void test(){
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext_aop.xml");
		
		SgtPeppers bean = context.getBean(SgtPeppers.class);
		bean.play();
	}
	
}
