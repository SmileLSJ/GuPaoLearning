package com.learing.veta.po.session02_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CDPlayer {

	public CompactDisc cd;
	
	public CDPlayer(){
	}
	
	
	
	public CompactDisc getCd() {
		return cd;
	}



	public void setCd(CompactDisc cd) {
		this.cd = cd;
	}



	public void play(){
		cd.play();
	}
}
