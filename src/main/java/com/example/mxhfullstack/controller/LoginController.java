package com.example.mxhfullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.model.User;
import com.example.mxhfullstack.service.LoginService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	private AppConfig appConfig;
	@Autowired
	public LoginController(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	@GetMapping
	public String login(Model model) {
		model.addAttribute("account", new User());
		return "Facebook/login_register";
	}
	
	@PostMapping("/signin")
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			RedirectAttributes redirectAttributes, HttpServletResponse response, HttpSession session) {
        try {
            String token = loginService.loginAndGetToken(username, password);
// Save the token to the response cookie or session as needed
//            HttpHeaders responseHeaders = new HttpHeaders();
//            responseHeaders.set(HttpHeaders., token);
//            Cookie cookie = new Cookie("nhaphocvku", token);
//    	    cookie.setHttpOnly(true);
//    	    cookie.setMaxAge(86400);
//    	    cookie.setPath("/admin/**");
//    	    System.out.println(cookie);
//    	    response.addCookie(cookie);
// Add other necessary headers or cookie handling as required

//            return "redirect:/admin/tuitionFeeList"; // Redirect to the dashboard or any other page upon successful login
//
            session.setAttribute("roles", appConfig.cookieStore().getRoles());
            session.setAttribute("username", appConfig.cookieStore().getUsername());
            return "redirect:/index"; // Redirect to the dashboard or any other page upon successful login

        } catch (Exception e) {
        	e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Invalid credentials. Please try again.");
            return "redirect:/login"; // Redirect back to the login page with an error message
        }
    }
	
	@PostMapping("/logout")
	public String logout() {
		String rs = loginService.logout();
		if (rs == "OK")
		{
			return "redirect:/admin/login";
		}
		else {
			return "";
		}
	}
}
