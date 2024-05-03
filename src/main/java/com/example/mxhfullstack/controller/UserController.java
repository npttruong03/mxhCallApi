package com.example.mxhfullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mxhfullstack.response.FriendResponse;
import com.example.mxhfullstack.response.UserInfoResponse;
import com.example.mxhfullstack.service.FriendService;
import com.example.mxhfullstack.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendService friendService;
	
	private String usernamecopy;
	
//	@GetMapping()
//	public String userUpdate(ModelMap modelMap,UserInfoResponse userInfoResponse) throws Exception {
//		modelMap.addAttribute("user", userInfoResponse);
//		return "Facebook/timeline";
//	}
	
	@PostMapping("/update")
	public String updateUserInfo(UserInfoResponse userInfoResponse) {
		userService.userUpdate(userInfoResponse);
		return "redirect:/user";
	}
	

	
	@GetMapping("/getUser/{username}")
	public String getUser(@PathVariable("username") String username, @Validated UserInfoResponse userInfoResponse, Model model) throws Exception {
		this.usernamecopy = username;
		userInfoResponse = this.userService.getById(username);
		model.addAttribute("nguoila", userInfoResponse);
		System.out.println(model);
		return "redirect:/user/getUser/nguoila";
	}
	
    @GetMapping("/getUser/nguoila")
    public String showUsernamecopy(String username, ModelMap model, Long id) throws JsonMappingException, JsonProcessingException {
        // Sử dụng username được lưu trữ trong lastUsername
        // Ví dụ: In ra username để kiểm tra
    	username = this.usernamecopy;
    	UserInfoResponse userInfoResponse = this.userService.userSearch(username);
    	id = userInfoResponse.getId();
    	model.addAttribute("userId", userInfoResponse.getId());
    	model.addAttribute("nguoilaoi", this.userService.userSearch(username));
    	model.addAttribute("checkfriend", this.friendService.getAllFriendAPI());
    	model.addAttribute("friendByUserId", this.friendService.getAllFriendByUserId(id));
    	model.addAttribute("username", username);

        // Thêm các xử lý khác tại 
        return "Facebook/timelineUser"; // Thay some_other_view bằng tên view thích hợp
    }
	
}
