package com.learning.gupo.design_pattern.factory.abstract_factory;

import com.learning.gupo.design_pattern.factory.po.AudiCar;
import com.learning.gupo.design_pattern.factory.po.Car;

public class AudiFactory extends AbstractFactory{


	@Override
	public Car getCar() {
		return new AudiCar();
	}
	
}
