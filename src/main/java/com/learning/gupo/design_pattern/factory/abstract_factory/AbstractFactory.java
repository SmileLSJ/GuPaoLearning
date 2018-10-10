package com.learning.gupo.design_pattern.factory.abstract_factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.Set;

import com.learning.gupo.design_pattern.factory.po.Car;

public abstract class AbstractFactory {

	public abstract Car getCar();
	
	
	//这段代码就是动态配置的功能
	public Car getCar(String name){
		
		//通过配置文件实现
		Properties p = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/design/car.properties");
		try {
			p.load(in);
			Set<Object> keySet = p.keySet();
			if(keySet.contains(name)){
				
				String classname = (String)p.get(name);
				Class clazz = Class.forName(classname);
				
				//通过class文件创建
//				AbstractFactory factory = (AbstractFactory)clazz.newInstance();
				
				//通过构造方法
				Constructor constructor = clazz.getConstructor();
				AbstractFactory factory  = (AbstractFactory)constructor.newInstance();
				return factory.getCar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		//通过逻辑实现
		/*if("BMW".equalsIgnoreCase(name)){
			return new BmwFactory().getCar();
		}else if("Audi".equalsIgnoreCase(name)){
			return new AudiFactory().getCar();
		}else {
			System.out.println("没有该产品");
			return null;
		}*/
	}
}
