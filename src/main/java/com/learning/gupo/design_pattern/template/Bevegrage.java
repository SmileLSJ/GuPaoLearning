package com.learning.gupo.design_pattern.template;

//冲饮料
public abstract class Bevegrage {

	public final void create() {
		
		//1 把水冲开
		boilWater();
		
		//2 把杯子准备好，原材料放到杯子中
		pourInCup();
		
		//3. 用水冲开
		brew();
		
		//4. 添加辅料
		addCoundiments();
	}

	public abstract void addCoundiments();

	public void brew() {
		System.out.println("用水冲泡");
	}

	public abstract void pourInCup();

	public void boilWater() {
		System.out.println("把水烧开");
	}
}
