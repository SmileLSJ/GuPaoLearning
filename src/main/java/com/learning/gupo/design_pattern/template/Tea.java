package com.learning.gupo.design_pattern.template;

public class Tea extends Bevegrage{

	@Override
	public void addCoundiments() {
		System.out.println("在茶中添加其他辅料");
		
	}
	
	public void pourInCup() {
		System.out.println("将茶加入到杯中");
	}
	
}
