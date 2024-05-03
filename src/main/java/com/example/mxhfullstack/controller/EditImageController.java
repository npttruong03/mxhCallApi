package com.example.mxhfullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditImageController {
	@GetMapping("/edit/image")
	public String home() {
		return "Facebook/handleimg";
	}

}
