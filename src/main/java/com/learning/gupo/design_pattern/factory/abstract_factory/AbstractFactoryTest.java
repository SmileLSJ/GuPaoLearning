package com.learning.gupo.design_pattern.factory.abstract_factory;

/**
 * 抽象工厂：
 * 	   隐藏逻辑处理过程，只关注结果
 */
public class AbstractFactoryTest {

	
	public static void main(String[] args) {
		AbstractFactory factory = new DefaultFactory();
		
		//默认的工厂
		System.out.println(factory.getCar());
		
		//特定的工厂
		System.out.println(factory.getCar("bmw"));
		System.out.println(factory.getCar("audi"));
	}
}
