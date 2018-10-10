package com.learning.gupo.custom.proxy.jdk;

import com.learning.gupo.custom.custom.GPMeipo;

public class TestFindLove {
	public static void main(String[] args) {
		
		try {
			
			Person obj = (Person)new GPMeipo().getInstance(new XiaoXingxing());
			System.out.println(obj.getClass());
			obj.findLove();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
