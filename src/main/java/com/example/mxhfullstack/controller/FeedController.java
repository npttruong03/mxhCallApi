package com.example.mxhfullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mxhfullstack.model.User;
import com.example.mxhfullstack.service.FeedService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/index")
public class FeedController {
	
	@Autowired
	private FeedService feedService;
	

	@GetMapping
	public String index(ModelMap modelMap){
//		modelMap.addAttribute("post", this.feedService.getAllPostAPI());
		return "Facebook/feed";
	}
	
}
