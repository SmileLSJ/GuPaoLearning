package com.learning.gupo.design_pattern.template;

public class Coffee extends Bevegrage{

	@Override
	public void addCoundiments() {
		System.out.println("咖啡中加入牛奶");
	}
	
	public void pourInCup() {
		System.out.println("将咖啡放入杯中");
	}
}
