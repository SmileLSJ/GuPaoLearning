package com.learning.gupo.design_pattern.prototype.simple;

public class ConcretePrototype extends Prototype{

	private int age ;
	
	private Bean bean;
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Bean getBean() {
		return bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}
	
}
