package com.example.mxhfullstack.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.model.FriendRequest;
import com.example.mxhfullstack.model.Post;
import com.example.mxhfullstack.model.User;
import com.example.mxhfullstack.response.FriendRequestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FriendResquestService {
	private final static String apiURL = Utils.BASE_URL + "friendrequest";
	
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public FriendResquestService(AppConfig appConfig) {
		this.appConfig = appConfig;
		
	}
	
	public String addFriendResquest(Long id) {
		String url = apiURL + "/add/" + id;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders() ,HttpMethod.GET, URI.create(url));
		ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
		return response.getBody();
	}
	
	public String RemoveFriendRequest(Long id) {
		String url = apiURL + "/remove/" + id;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders() ,HttpMethod.GET, URI.create(url));
		ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
		return response.getBody();
	}
	
	public List<FriendRequestResponse> getAllFriendRequest() throws JsonMappingException, JsonProcessingException {
		String url = apiURL + "/getall";
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders() ,HttpMethod.GET, URI.create(url));
		ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
		String json = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  objectMapper.findAndRegisterModules();
		List<FriendRequestResponse> listFriendRequest = objectMapper.readValue(json, new TypeReference<List<FriendRequestResponse>>() {
		});
		return listFriendRequest;
	}
	
//	public boolean isFriend(Long idSource, Long idTarget) {
//		User userSource = us
//	}
	
}
