package com.learing.veta.myaop.service;

import com.learing.veta.myaop.annotation.SimpleInject;

public class ServiceA {

	@SimpleInject
	private ServiceB b;
	
	public void callB(){
		System.out.println("Service A call B......");
		b.action();
	}
}
