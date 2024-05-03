package com.example.mxhfullstack.service;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.model.PageInfo;
import com.example.mxhfullstack.request.PostSaveRequest;
import com.example.mxhfullstack.response.PostResponse;
import com.example.mxhfullstack.response.PostResponseWrapper;
import com.example.mxhfullstack.response.UserInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService {
	private final static String apiURL = Utils.BASE_URL + "post";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public PostService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
//	public List<PostResponse> getAllpostByMe(PageInfo pageInfo) throws JsonMappingException, JsonProcessingException {
//		String apiurl = apiURL + "/all/me";
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
//		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
//		String json = responseEntity.getBody();
//		System.out.println("post: " + json);
//		ObjectMapper objectMapper = new ObjectMapper();
//		  objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//		  objectMapper.findAndRegisterModules();
//		  List<PostResponse> getAll = objectMapper.readValue(json, new TypeReference<List<PostResponse>>() {});
//		return getAll;
//	}
	
	public List<PostResponse> getAllpostByMe(PageInfo pageInfo) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/all/me";
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    PostResponseWrapper responseWrapper = objectMapper.readValue(json, PostResponseWrapper.class);
	    List<PostResponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	
	public List<PostResponse> getAllpostByUser(PageInfo pageInfo, Long userId) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/all/" + userId;
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    PostResponseWrapper responseWrapper = objectMapper.readValue(json, PostResponseWrapper.class);
	    List<PostResponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	

	public List<PostResponse> getAll(PageInfo pageInfo) throws JsonMappingException, JsonProcessingException{
		String apiurl = apiURL + "/get/All";
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    PostResponseWrapper responseWrapper = objectMapper.readValue(json, PostResponseWrapper.class);
	    List<PostResponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	
	public String createPost(PostSaveRequest postSaveRequest) throws Exception {
	    String apiurl = apiURL;
	    RequestEntity<?> requestEntity = new RequestEntity<>(postSaveRequest, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    return responseEntity.getBody();
	}

	

}
