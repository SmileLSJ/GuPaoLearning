package com.learing.veta.xpath;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class XPathUtils {
	
	final String name = "xml/xpath.xml";
	
	// "//"表示所有  所有的book节点
//	final String doStr = "//book";
	
	// "/" 表示从根节点选取
	final String doStr = "//*";
	
	// 含有ID=book1属性的book节点
//	final String doStr = "//book[@id='book1']";
	
	
	
	
	
	
	@Test
	public  void test(){
		getXmlValue(name,doStr);
	}
	
	public void getXmlValue(String name,String doStr){
		try {
			String xpathStr = doStr;
			
			InputStream resourceAsStream = 
					this.getClass().getClassLoader().
					getResourceAsStream(name);
			
			Document read = new SAXReader().read(resourceAsStream);
			
			List<Element> nodes = read.selectNodes(doStr);
			
			for (Element ele : nodes) {
				List<Attribute> attributes = ele.attributes();
				for (Attribute attribute : attributes) {
					
					System.out.print(ele.getName()+" "+attribute.getName()+"="+attribute.getValue()+",");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
