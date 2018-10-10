package com.learing.veta.po.session04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Lesson {

//	@Value("${lesson.name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Lesson [name=" + name + "]";
	}
	
	
}
