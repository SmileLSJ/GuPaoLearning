package com.learning.gupo.design_pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class Prototype implements Cloneable{

	private Bean bean = new Bean();
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Prototype cope = (Prototype)super.clone();
		cope.bean = (Bean)bean.clone();
		return super.clone();
	}
}
