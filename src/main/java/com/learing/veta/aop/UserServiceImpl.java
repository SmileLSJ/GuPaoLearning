package com.learing.veta.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserServiceImpl implements UserServer{

	public void say() {
		System.out.println(this.getClass().getName()+" say....");
	}
}
