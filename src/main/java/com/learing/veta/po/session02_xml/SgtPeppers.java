package com.learing.veta.po.session02_xml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SgtPeppers implements CompactDisc{

	private String title = "Sgt, the tile is first song";
	private String artist = "The one";
	
	@Value("${lesson.name}")
	private String lesson;
	
	
	public SgtPeppers() {
	}



	@Override
	public void play() {
		System.out.println("Play "+title+",artist: "+artist +"lesson name:"+lesson);
	}
}
