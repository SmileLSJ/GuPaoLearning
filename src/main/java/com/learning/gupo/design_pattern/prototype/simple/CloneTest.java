package com.learning.gupo.design_pattern.prototype.simple;

/**
 * 原型模式：字节码拷贝
 * 
 *	 浅拷贝
 *  	1. 克隆基本数据类型以及String类型，创建出新的对象
 *  	2. 对于其他对象，则为共享对象
 *     深拷贝
 *      1. 	基本数据和其他类型都实现拷贝，生成新的对象	
 * @author ZY003
 *
 */
public class CloneTest {

	public static void main(String[] args) {
		
		ConcretePrototype cp = new ConcretePrototype();
		Bean bean = new Bean();
		cp.setAge(18);
		cp.setBean(bean);
		
		
		//ConcretePrototype@7852e922
		System.out.println(cp);
		System.out.println(cp.getBean());
		
		
		try {
			ConcretePrototype cope = (ConcretePrototype)cp.clone();
			
			//ConcretePrototype@4e25154f
			System.out.println(cope);
			System.out.println(cope.getAge());
			System.out.println(cope.getBean());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//存在现成的一个对象，已经赋值
	//新建也对象，并且要给新建的对象赋值，而且赋值内容要跟之前的一模一样
}
