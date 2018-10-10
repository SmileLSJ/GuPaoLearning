package com.learning.gupo.design_pattern.delegate;

//项目经理，不执行具体内容，委托给员工执行
public class Dispatcher implements IExecutor{

	IExecutor executor;
	
	public Dispatcher(IExecutor executor){
		this.executor=executor;
	}
	
	//委派给员工执行
	public void doing() {
		this.executor.doing();
	}
}
