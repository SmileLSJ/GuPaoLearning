package com.learning.gupo.design_pattern.delegate;

import java.util.Map;

public class TestDelegate {

	public static void main(String[] args) {
		
		IExecutor executor = new ExecutorA();
		
		Dispatcher dispatcher = new Dispatcher(executor);
		dispatcher.doing();
	}
	
}
