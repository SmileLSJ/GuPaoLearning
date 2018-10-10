package com.learing.veta.po.session02_xmlandconfig.config;

/**
 * javaconfig:进行显示的进行注入
 */

import javax.swing.text.Segment;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.learing.veta.po.session02_xmlandconfig.protomodule.CDPlayer;
import com.learing.veta.po.session02_xmlandconfig.protomodule.CompactDisc;

@Configuration
public class CDPlayerConfig {

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc){
		return new CDPlayer(compactDisc);
	}
}
