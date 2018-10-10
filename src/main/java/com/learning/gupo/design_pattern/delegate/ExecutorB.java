package com.learning.gupo.design_pattern.delegate;

//员工B
public class ExecutorB implements IExecutor{

	@Override
	public void doing() {
		System.out.println("员工B开始执行任务");
	}
}
