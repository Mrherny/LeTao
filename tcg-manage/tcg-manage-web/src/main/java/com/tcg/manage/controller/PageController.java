package com.tcg.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("page")
public class PageController {
	
	@RequestMapping(value="{pageNum}",method=RequestMethod.GET)
	public String toPage(@PathVariable("pageNum") String pageNum){
		return pageNum;
	}
	
}
