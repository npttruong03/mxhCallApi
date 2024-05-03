package com.example.mxhfullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mxhfullstack.response.UserInfoResponse;
import com.example.mxhfullstack.service.FriendResquestService;
import com.example.mxhfullstack.service.FriendService;
import com.example.mxhfullstack.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendResquestService friendResquestService;
//	@GetMapping
//	public String timeline(Model model)  {
//		return "Facebook/timeline";
//	}
	
	@GetMapping("/getAll")
	public String getAllFriend(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("friend", this.friendService.getAllFriendAPI());
		model.addAttribute("user", this.userService.getme());
		model.addAttribute("friendrequest", this.friendResquestService.getAllFriendRequest());
		System.out.println("test: " + model);
		return "Facebook/timeline";
	}
	
	@GetMapping("/add/{id}")
	public String addFriend(@PathVariable("id") Long idTarget, Model model) throws Exception {
		model.addAttribute("addfr", this.friendService.addFriend(idTarget));
		return "redirect:/friend/getAll";
	}
	
	@GetMapping("/remove/{id}")
	public String removeFriend(@PathVariable("id") Long idTarget,Model model) throws Exception {
		model.addAttribute("removefr", this.friendService.removeFriend(idTarget));
		return "redirect:/friend/getAll";
	}

	
	
	
	
		
}

