package com.learing.veta.po.session02_xmlandconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learing.veta.po.session02_xmlandconfig.protomodule.CompactDisc;
import com.learing.veta.po.session02_xmlandconfig.protomodule.SgtPeppers;

@Configuration
public class CDConfig {

	@Bean
	public CompactDisc compactDisc(){
		return new SgtPeppers();
	}
}
