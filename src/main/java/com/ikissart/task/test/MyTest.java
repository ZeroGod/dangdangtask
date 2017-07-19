package com.ikissart.task.test;

import org.springframework.stereotype.Component;

import com.ikissart.task.test.AbstractTask;

@Component
public class MyTest extends AbstractTask{

	@Override
	public String getTaskName() {
		
		return "";
	}

	@Override
	public void doExecute() {
		
		System.out.println("测试");
	}

}
