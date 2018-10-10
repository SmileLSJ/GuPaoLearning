package com.learning.gupo.design_pattern.factory.abstract_factory;

import com.learning.gupo.design_pattern.factory.po.Car;

public class DefaultFactory extends AbstractFactory{

	//默认的工厂
	private AudiFactory defaultFactory =  new AudiFactory();
	
	
	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return defaultFactory.getCar();
	}
}
