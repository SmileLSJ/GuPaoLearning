package com.learning.gupo.custom.custom;

import java.lang.reflect.Method;

import com.learning.gupo.custom.proxy.jdk.Person;
import com.learning.gupo.custom.proxy.jdk.XiaoXingxing;

public class GPMeipo implements GPInvocationHandler{
	
	private Person target;
	
	//��ȡ�������˵ĸ�������
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		Class clazz = target.getClass();
		System.out.println("����������class��:"+clazz);
		return GPPorxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("����ý�ţ��ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		method.invoke(this.target, args);
		System.out.println("------------");
		System.out.println("�����ʵĻ�����׼������");
		return null;
	}

}
