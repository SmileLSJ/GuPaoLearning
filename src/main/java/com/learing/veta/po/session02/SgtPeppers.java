package com.learing.veta.po.session02;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class SgtPeppers implements CompactDisc{

	private String title = "Sgt, the tile is first song";
	private String artist = "The one";
	
	
	
	public SgtPeppers() {
	}



	@Override
	public void play() {
		System.out.println("Play "+title+",artist: "+artist);
		
	}
}
