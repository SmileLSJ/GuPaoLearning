package com.learing.veta.po.session04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Student {

//	@Value("${user.username}")
	private String name;
	
//	@Value("${age}")
	private String age;
	
	
	
	public Student(String name, String age, Lesson ls) {
		this.name = name;
		this.age = age;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	

}
