package com.learing.veta.myaop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.learing.veta.myaop.annotation.Aspect;
import com.learing.veta.myaop.service.ServiceA;
import com.learing.veta.myaop.service.ServiceB;

@Aspect(values = {ServiceA.class,ServiceB.class})
public class ServiceLogAspect {

	public static void before(Object object,Method method,Object[] args){
		System.out.println("entering--> "+method.getDeclaringClass().getSimpleName()
				+"::"+method.getName()+",args:"+Arrays.toString(args));
	}
	
	
	public static void after(Object object,Method method,Object[] args){
		System.out.println("leaving--> "+method.getDeclaringClass().getSimpleName()
				+"::"+method.getName()+",args:"+Arrays.toString(args));
	}
	
}
