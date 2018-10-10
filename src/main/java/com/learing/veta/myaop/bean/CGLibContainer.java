package com.learing.veta.myaop.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.learing.veta.myaop.annotation.Aspect;
import com.learing.veta.myaop.annotation.SimpleInject;
import com.learing.veta.myaop.aspect.ExceptionAspect;
import com.learing.veta.myaop.aspect.ServiceLogAspect;
import com.learing.veta.myaop.service.ServiceA;
import com.learing.veta.myaop.service.ServiceB;

public class CGLibContainer {

	static Map<Class<?>, Map<InterceptPoint,List<Method>>> interceptMethodsMap
		= new HashMap<Class<?>, Map<InterceptPoint,List<Method>>>();
	
	//切面中的通知
	static Class<?>[] aspects = 
		{ExceptionAspect.class,ServiceLogAspect.class};
	
	static{
		init();
	}

	private static void init() {
		for (Class<?> clazz : aspects) {
			Aspect aspect = clazz.getAnnotation(Aspect.class);
			try {
				if(aspect!=null){
					Method before = getMethod(clazz, "before", new Class<?>[]{
						Object.class,Method.class,Object[].class
					});
					Method after = getMethod(clazz, "after", new Class<?>[]{
							Object.class,Method.class,Object[].class
					});
					Method exception = getMethod(clazz, "exception", new Class<?>[]{
							Object.class,Method.class,Object[].class
					});
							
					Class<?>[] interceptedAttr = aspect.values();
					for (Class<?> intercepted : interceptedAttr) {
						addInterceptMethod(intercepted,InterceptPoint.BEFORE,before);
						addInterceptMethod(intercepted,InterceptPoint.AFTER,after);
						addInterceptMethod(intercepted,InterceptPoint.EXCEPTION,exception);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	
	private static Method getMethod(Class<?> clazz,String methodName,Class<?>[] args){
		Method method = null;
		try {
			method = clazz.getMethod(methodName, args);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
		}
		return method;
	}
	
	private static void addInterceptMethod(Class<?> intercepted,
			InterceptPoint point, Method method) {
		if(method==null) return;
		
		Map<InterceptPoint, List<Method>> map = interceptMethodsMap.get(intercepted);
		if(map==null){
			map= new HashMap<InterceptPoint, List<Method>>();
			interceptMethodsMap.put(intercepted, map);
		}
		
		List<Method> list = map.get(point);
		if(list==null){
			list = new ArrayList<Method>();
			map.put(point, list);
		}
		list.add(method);
	}
	
	public static <T> T createInstance(Class<T> cls){
		if(!interceptMethodsMap.containsKey(cls)){
			try {
				return cls.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(new AspectInterceptor());
		return (T) enhancer.create();
	}
	
	
	static class AspectInterceptor implements MethodInterceptor{
		@Override
		public Object intercept(Object proxy, Method method, Object[] args,
				MethodProxy proxyMethod) throws Throwable {
			Class<?> superclass = proxy.getClass().getSuperclass();
     		List<Method> before = getInterceptMethod(superclass,InterceptPoint.BEFORE);
			List<Method> after = getInterceptMethod(superclass,InterceptPoint.AFTER);
			List<Method> exception = getInterceptMethod(superclass,InterceptPoint.EXCEPTION);
			Object result = null;
			
			try {
				for (Method beforeMethod : before) {
					
//					String name = beforeMethod.getDeclaringClass().getName();
//					Object obj = Class.forName(name).newInstance();
//					beforeMethod.invoke(obj,new Object[]{obj,method,args});
					beforeMethod.invoke(null,new Object[]{proxy,method,args});
				}
				result = proxyMethod.invokeSuper(proxy, args);
				for (Method beforeMethod : after) {
//					String name = beforeMethod.getDeclaringClass().getName();
//					Object obj = Class.forName(name).newInstance();
//					beforeMethod.invoke(obj,new Object[]{proxy,method,args});
					beforeMethod.invoke(null,new Object[]{proxy,method,args});
				}
			} catch (Exception e) {
				e.printStackTrace();			
				for (Method beforeMethod : exception) {
//					String name = beforeMethod.getDeclaringClass().getName();
//					Object obj = Class.forName(name).newInstance();
//					beforeMethod.invoke(obj,new Object[]{proxy,method,args});
					beforeMethod.invoke(null,new Object[]{proxy,method,args});
				}
			}
			return result;
		}

		private List<Method> getInterceptMethod(Class<?> superclass,
				InterceptPoint point) {
			Map<InterceptPoint, List<Method>> map = interceptMethodsMap.get(superclass);
			if(map==null){
				return Collections.emptyList();
			}
			
			List<Method> list = map.get(point);
			if(list==null){
				return Collections.emptyList();
			}
			return list;
		}
	}
	
	
	public static <T> T getInstance(Class<T> clss){
		try {
			T obj = createInstance(clss);
			Field[] fields = clss.getDeclaredFields();
			for (Field field : fields) {
				if(field.isAnnotationPresent(SimpleInject.class)){
					if(!field.isAccessible()){
						field.setAccessible(true);
					}
					
					Class<?> type = field.getType();
					field.set(obj, getInstance(type));
				}
			}
			return obj;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
