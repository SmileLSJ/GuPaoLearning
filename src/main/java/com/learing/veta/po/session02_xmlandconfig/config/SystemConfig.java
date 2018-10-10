package com.learing.veta.po.session02_xmlandconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@Configuration
@Import({CDPlayerConfig.class,CDConfig.class})
@ImportResource("classpath:applicationContext.xml")
public class SystemConfig {

}
