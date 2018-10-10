package com.learing.veta.po.session02;

/**
 * javaconfig:进行显示的进行注入
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.learing.veta.po.session02")
public class CDPlayerConfig {

	//对接外部类时的操作
	/*
	@Bean
	public CompactDisc sgtPeppers(){
		CompactDisc com = new SgtPeppers();
		//sgtPeppers=com.learing.veta.po.session02.SgtPeppers@236527f
		System.out.println("sgtPeppers="+com);
		return com;
	}
	
	//spring自动将上面注入到容器中的sgtpeppers，注入到输入参数中，而不需要使用sgtPeppers()方法来获取bean
	@Bean
	public CDPlayer cdPlayer(CompactDisc com){
		//cdplayer=com.learing.veta.po.session02.SgtPeppers@236527f
		System.out.println("cdplayer="+com);
		return new CDPlayer(com);
	}*/
}
