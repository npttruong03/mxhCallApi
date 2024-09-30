package com.example.mxhfullstack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor{
	
	private AppConfig appConfig;
	
	@Autowired
	public AuthInterceptor(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = getCookie();
		if(isValidCookie(token)) {
			return true;
		} else {
			response.sendRedirect("/login");
			return false;
		}
	}
	
	private String getCookie() {
		String token = appConfig.cookieStore().getCookie();
		if(token != null) {
			return token;
		}
		return null;
	}
	
	private boolean isValidCookie(String token) {
		return token != null && token.length() > 10;
	}

}
