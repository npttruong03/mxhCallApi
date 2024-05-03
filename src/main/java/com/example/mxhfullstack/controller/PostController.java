package com.example.mxhfullstack.controller;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mxhfullstack.model.PageInfo;
import com.example.mxhfullstack.response.PostResponse;
import com.example.mxhfullstack.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/post")
public class PostController {
	private static final int INITIAL_PAGE_SIZE = 5;
	@Autowired
	private PostService postService;
	
//	@PostMapping("/all/me")
//	public String getAllByMe(PageInfo pageInfo, Model model) throws JsonMappingException, JsonProcessingException {
//		PostResponse posts = postService.getAllpostByMe(pageInfo);
//		model.addAttribute("postsMe", posts);
//		model.addAttribute("initialPageSize", INITIAL_PAGE_SIZE);
//		return "Facebook/timeline";
//	}

}
