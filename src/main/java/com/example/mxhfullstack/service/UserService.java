package com.example.mxhfullstack.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.response.FriendResponse;
import com.example.mxhfullstack.response.UserInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	private final static String apiURL = Utils.BASE_URL + "user";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public UserService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	public UserInfoResponse getme() throws JsonMappingException, JsonProcessingException {
		String apiurl = apiURL + "/me";
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders() ,HttpMethod.GET, URI.create(apiurl));
		ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
		String json = response.getBody();
		System.out.println("user: " + json);
		ObjectMapper objectMapper = new ObjectMapper();
		  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  objectMapper.findAndRegisterModules();
		UserInfoResponse me = objectMapper.readValue(json, new TypeReference<UserInfoResponse>() {
		});
		return me;
	}
	
	public String userUpdate(UserInfoResponse userInfoResponse) {
		String apiurl = apiURL + "update";
		headers.setContentType(MediaType.APPLICATION_JSON);
		RequestEntity<?> requestEntity = new RequestEntity<>(userInfoResponse, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		return responseEntity.getBody();
	}
	
	public UserInfoResponse userSearch(String username) throws JsonMappingException, JsonProcessingException{
		String apiurl = apiURL + "/username/" + username;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.GET, URI.create(apiurl));
		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		String json = responseEntity.getBody();
		System.out.println("search: " + json);
		ObjectMapper objectMapper = new ObjectMapper();
		  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  objectMapper.findAndRegisterModules();
		UserInfoResponse searchUser = objectMapper.readValue(json, new TypeReference<UserInfoResponse>() {
		});
		return searchUser;
	}
	
	public UserInfoResponse getById(String username) throws Exception{
		UserInfoResponse userInfoResponse = userSearch(username);
		if(userInfoResponse.getUsername() == username) {
			return userInfoResponse;
		}
		return null;
	}
	
}
