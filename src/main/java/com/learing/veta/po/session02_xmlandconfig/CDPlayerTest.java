package com.learing.veta.po.session02_xmlandconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learing.veta.po.session02_xmlandconfig.config.SystemConfig;
import com.learing.veta.po.session02_xmlandconfig.protomodule.CDPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfig.class)
public class CDPlayerTest {

	@Autowired
	public CDPlayer player;
	
	@Test
	public void test(){
		player.play();
	}
}
