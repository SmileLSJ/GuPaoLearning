package com.learing.veta.po.session02_xmlandconfig.protomodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CDPlayer {

	private CompactDisc cd;
	
	public CDPlayer(CompactDisc cd){
		this.cd=cd;
	}
	
	public void play(){
		cd.play();
	}
}
