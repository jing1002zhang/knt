package com.knt.frontpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloworldController {

	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		
		return "Hello world! kevin love neo!!";
		
	}
}