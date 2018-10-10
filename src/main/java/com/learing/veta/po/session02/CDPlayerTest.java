package com.learing.veta.po.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
//
//	@Autowired
//	public CDPlayer player;
	
	@Test
	public void test(){
		//player.play();
		
		
		//通过注解获取bean对象
		ApplicationContext context =
				new AnnotationConfigApplicationContext(CDPlayerConfig.class);
		CDPlayer bean = context.getBean(CDPlayer.class);
		bean.play();
	}
	
	
}
