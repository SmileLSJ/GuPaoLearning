package com.learing.veta.po.session04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext_properties.xml")
public class profileTest {

	
	@Autowired
	@Qualifier(value="student1")
	private Student student;
	
	@Autowired
	@Qualifier(value="student1")
	private Student student1;
	
	@Value("你好")
	private String username;
	
	@Value("${aa}")
	private String aa;
	
	@Value("#{student1.name}")
	private String bb;
	
	@Test
	public void testProfile(){
		/*student.setName("小明");
		student.setAge("11");*/
		System.out.println(student);
		System.out.println(student1);
		System.out.println(username);
		System.out.println(aa);
		System.out.println(bb);
	}
}
