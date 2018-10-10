package com.learing.veta.myaop;

import com.learing.veta.myaop.bean.CGLibContainer;
import com.learing.veta.myaop.service.ServiceA;
import com.learing.veta.myaop.service.ServiceB;

public class Test {

	@org.junit.Test
	public void test(){
		ServiceA serviceA = CGLibContainer.getInstance(ServiceA.class);
		serviceA.callB();
		
		Object[] objs = new String[]{"1","2"};
	}
}
