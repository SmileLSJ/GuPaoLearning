package com.learning.gupo.custom.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//ý��
public class Meipo implements InvocationHandler {
	
	private Person target; //����������������Ϊһ����Ա��������������
	
	//��ȡ�������˵ĸ�������
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		Class clazz = target.getClass();
		System.out.println("����������class��:"+clazz);
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("����ý�ţ�" + "�ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		
		//���õ�ʱ��
		method.invoke(this.target, args);
		System.out.println("------------");
		System.out.println("�����ʵĻ�����׼������");
		
		return null;
	}

}
