package com.learning.gupo.proxy.custom;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class test {

	
	public static void main(String[] args) {
		
		Person meiPo = (Person)new FMeipo().getMeiPo(new XiaoMing());
		meiPo.sayHello();
	}
}
