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
import com.example.mxhfullstack.model.Post;
import com.example.mxhfullstack.response.FriendResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FriendService {

	private final static String apiURL = Utils.BASE_URL + "friends";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public FriendService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	public List<FriendResponse> getAllFriendAPI() throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/getall/me";
	    RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.GET, URI.create(apiurl));
	    ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
	    String json = response.getBody();
	    System.out.println("Response from server: " + json); // In ra dữ liệu từ máy chủ
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    objectMapper.findAndRegisterModules();
	    List<FriendResponse> listPost = objectMapper.readValue(json, new TypeReference<List<FriendResponse>>() {});
	    return listPost; 
	}
	
	public String addFriend(Long idTarget) throws Exception {
		String apiurl = apiURL + "/add/" + idTarget;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.GET, URI.create(apiurl));
	    ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
	    return response.getBody();
	}
	
	public String removeFriend(Long idTarget) throws Exception {
		String apiurl = apiURL + "/remove/" + idTarget;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.GET, URI.create(apiurl));
	    ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
	    return response.getBody();
	}
	
	public List<FriendResponse> getAllFriendByUserId(Long id) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/getall/" + id;
	    RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.GET, URI.create(apiurl));
	    ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
	    String json = response.getBody();
	    System.out.println("friend theo userid: " + json); // In ra dữ liệu từ máy chủ
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    objectMapper.findAndRegisterModules();
	    List<FriendResponse> listPost = objectMapper.readValue(json, new TypeReference<List<FriendResponse>>() {});
	    return listPost; 
	}
}
