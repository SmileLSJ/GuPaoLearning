package com.learning.gupo.proxy.custom;

import java.lang.reflect.Method;


//目标对象的动态代理
public class FMeipo implements FInvocationHandler{

	private Person target;
	
	public Object getMeiPo(Person target){
		this.target = target;
		
		//获取代理对象
		return FProxy.newInstance(new FClassLoader()
				,target.getClass().getInterfaces(),this);
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("自定义代理开始。。。。。。。。");
		method.invoke(target, args);
		System.out.println("自定义代理结束。。。。。。。。");
		return null;
	}
}
