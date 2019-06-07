package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyServiceImpl;



@RestController
public class TestController {
	@Autowired
    private MyServiceImpl myservice;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model, HttpSession session
			) throws UnsupportedEncodingException
	{
		String name=request.getParameter("name");
		
		return myservice.testService(name);
	}
	
}
