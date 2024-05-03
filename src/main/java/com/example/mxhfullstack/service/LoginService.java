package com.example.mxhfullstack.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoginService {
	private AppConfig appConfig;
	@Autowired
	public LoginService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	private final static String apiURL = Utils.BASE_URL + "auth";
	
	public String loginAndGetToken(String username, String password) throws Exception {

//  	 String loginUrl = "http://localhost:2221/api/auth/signin"; // Thay đổi thành URL của API đăng nhập
      String loginUrl = apiURL + "/login";

  	User loginRequest = new User();


//  	 String hashedPassword = passwordEncoder.encode(password);
       loginRequest.setUsername(username);
       loginRequest.setPassword(password);
       
       // Tạo các thông tin đăng nhập gửi đến server
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);

       // Tạo HttpEntity chứa headers
       HttpEntity<User> entity = new HttpEntity<>(loginRequest,headers);
       // Tạo RestTemplate
       RestTemplate restTemplate = new RestTemplate();

       // Gọi API đăng nhập
       ResponseEntity<String> response = restTemplate.exchange(loginUrl, HttpMethod.POST, entity, String.class);
       if (response.getStatusCode().is2xxSuccessful()) {

           String json = response.getBody(); 
           ObjectMapper objectMapper = new ObjectMapper();
           LoggedInfo loggedInfo = objectMapper.readValue(json, LoginService.LoggedInfo.class);
           appConfig.cookieStore().setCookie(loggedInfo.getToken());
           appConfig.cookieStore().setRoles(loggedInfo.getRole());
           appConfig.cookieStore().setUsername(loggedInfo.getUsername());
           System.out.println("token: " + appConfig.cookieStore().getCookie());
           System.out.println("lagi: " + appConfig.cookieStore().getHeaders());
           return "OK";
       } else {
           throw new RuntimeException("Failed to login. Status code: " + response.getStatusCodeValue());
       }
   }
	
	   public String logout() {
	   	String api = apiURL + "/signout";
	   	
	   	RestTemplate restTemplate = new RestTemplate();
//	   	RequestEntity<?> requestEntity = new RequestEntity(appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(api));
	   	RequestEntity<?> requestEntity = new RequestEntity<>(String.class, HttpMethod.POST, URI.create(api)); 
	   	ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	   	if (responseEntity.getBody().equals("Logout OK"))
	   	{
	       	appConfig.cookieStore().setCookie("");
	       	return "OK";
	   	}
	   	return "Logout fail";
	   }
	   
	   static class LoggedInfo {
			  String token;
			  List<String> role;
			  String username;
			
			public String getToken() {
				return token;
			}
			public void setToken(String token) {
				this.token = token;
			}
			public List<String> getRole() {
				return role;
			}
			public void setRole(List<String> roles) {
				this.role = roles;
			}
			
			public String getUsername() {
				return username;
			}
			
			public void setUsername(String username) {
				this.username = username;
			}
	 }
	   
	   
}