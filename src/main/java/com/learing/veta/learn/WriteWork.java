package com.learing.veta.learn;

public class WriteWork {
	public WriteWork() throws InterruptedException {
	    System.out.println("WriteWork构造函数初始化，并向模拟文件写入内容：property:better");
	    Thread.sleep(3000);
	    MockFile.setFilecontent("property:better");
	}
}
