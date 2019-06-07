package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.annotation.Action;

@Service
public class MyServiceImpl implements MyService {
	
	@Action(name = "testService")
	public String testService(String name)
	{
		return "MyServieImpl call "+name;
	}

}
