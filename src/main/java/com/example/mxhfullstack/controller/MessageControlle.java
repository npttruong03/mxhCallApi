package com.example.mxhfullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mxhfullstack.service.MessageService;
import com.example.mxhfullstack.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/message")
public class MessageControlle {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public String getMessage(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("user", userService.getme());
		return "Facebook/chats-friend";
	}
	
}
