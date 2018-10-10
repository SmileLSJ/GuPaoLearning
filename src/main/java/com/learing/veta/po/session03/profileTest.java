package com.learing.veta.po.session03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfig.class)
@ActiveProfiles("uat")
public class profileTest {

	
	@Test
	public void testProfile(){
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext
				("applicationContext_many_profile.xml");
		Student bean = context.getBean("student", Student.class);
		System.out.println(bean.toString());
	}
}
