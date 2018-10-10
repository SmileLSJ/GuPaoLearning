package com.learning.gupo.design_pattern.factory.abstract_factory;

import com.learning.gupo.design_pattern.factory.po.BwmCar;
import com.learning.gupo.design_pattern.factory.po.Car;

public class BmwFactory extends AbstractFactory{

	
	@Override
	public Car getCar() {
		return new BwmCar();
	}
}
