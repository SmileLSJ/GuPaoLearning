package com.learning.gupo.proxy.custom;

import java.lang.reflect.Method;


//执行器处理器
public interface FInvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args)
	        throws Throwable;
}
