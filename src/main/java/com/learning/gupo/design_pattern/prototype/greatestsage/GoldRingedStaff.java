package com.learning.gupo.design_pattern.prototype.greatestsage;

import java.io.Serializable;

//金箍棒
public class GoldRingedStaff implements Serializable{

	private int width = 10;
	private int height= 100;
	
	public void grow() {
		this.width*=2;
		this.height*=2;
	}
	
	public void decrease() {
		this.width/=2;
		this.height/=2;
	}
	
	
}
