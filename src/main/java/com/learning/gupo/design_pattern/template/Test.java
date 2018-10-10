package com.learning.gupo.design_pattern.template;

public class Test {
	
	public static void main(String[] args) {
		
		
		/*
			 把水烧开
			将咖啡放入杯中
			用水冲泡
			咖啡中加入牛奶
		*/
		Coffee coffee = new Coffee();
		coffee.create();
		
		
		
		/*
		 	把水烧开
			将茶加入到杯中
			用水冲泡
			在茶中添加其他辅料
		 */
		Tea tea = new Tea();
		tea.create();
	}

}
