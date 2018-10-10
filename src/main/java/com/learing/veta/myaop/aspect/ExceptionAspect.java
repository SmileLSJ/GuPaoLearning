package com.learing.veta.myaop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.learing.veta.myaop.annotation.Aspect;
import com.learing.veta.myaop.service.ServiceB;

@Aspect(values={ServiceB.class})
public class ExceptionAspect {

	public static void exception(Object object,Method method,Object[] args){
		System.out.println("exception--> "+method.getDeclaringClass().getSimpleName()
				+"::"+method.getName()+",args:"+Arrays.toString(args));
	}
}
