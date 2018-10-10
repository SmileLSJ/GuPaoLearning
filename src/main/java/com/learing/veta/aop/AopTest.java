package com.learing.veta.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

	@Test
	public void testAop(){
		ApplicationContext application = new 
				ClassPathXmlApplicationContext("classpath:/aop_application.xml");
		
		//===========实现接口
		//实现了接口的方法，同时使用aop增强(只有一个类实现了增强，使用jdk代理实现)
		//使用了aop增强，底层实现的是通过动态代理实现，所以是UserServer的实现代理类，
		//而不是实例本身，所以获取以及接受都得使用接口，而不是实例
		
		//$Proxy7--》UserServer
		UserServer bean = application.getBean(UserServer.class);
		bean.say();
		
		
		//============没有实现接口
		//当不存在aop时，不管是使用接口还是实现类都可以获得到实现类的实例（只有一个实现类）
		//当不存在aop时，如果存在两个实现类，而直接使用接口来获取实现类是无法获取到，由于有两个实现类，所以报错

		//UserServiceImpl2$$EnhancerBySpringCGLIB
		UserServiceImpl2 imp = application.getBean(UserServiceImpl2.class);
		imp.say();
	}
}
