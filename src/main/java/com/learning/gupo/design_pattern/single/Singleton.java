package com.learning.gupo.design_pattern.single;


/**
 * 单例（懒汉式）
 */
public class Singleton {

	//静态内部类，可以防止反射来调用实例
	//静态内部类，只保留一份，解决了安全性问题
	private static class LazyHolder{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	private Singleton(){
	}
	
	public static final Singleton getSingleton(){
		return LazyHolder.INSTANCE;
	}
}
