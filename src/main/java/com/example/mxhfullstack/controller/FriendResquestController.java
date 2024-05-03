package com.example.mxhfullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mxhfullstack.service.FriendResquestService;
import com.example.mxhfullstack.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/friendrequest")
public class FriendResquestController {
	@Autowired
	private UserService userService;

	@Autowired
	private FriendResquestService friendResquestService;
	
	@GetMapping("/add/{id}")
	public String FriendResquest(@PathVariable("id") Long id) {
		String friendRequest = friendResquestService.addFriendResquest(id);
		return "redirect:/user/getUser/nguoila";
	}
	
	@GetMapping("/remove/{id}")
	public String RemoveFriendRequest(@PathVariable("id") Long id) {
		String removeFriendRequest = friendResquestService.RemoveFriendRequest(id);
		return "redirect:/friend/getAll";
	}
	
//	@GetMapping("/all/me")
//	public String getAllFriend(ModelMap modelMap) throws JsonMappingException, JsonProcessingException {
//		modelMap.addAttribute("friend", this.friendResquestService.getAllFriendRequest());
//		return "Facebook/timeline";
//	}
}
