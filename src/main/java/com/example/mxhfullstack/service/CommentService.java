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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.model.PageInfo;
import com.example.mxhfullstack.request.CommentSaveRequest;
import com.example.mxhfullstack.response.CommentResponse;
import com.example.mxhfullstack.response.CommentResponseWrapper;
import com.example.mxhfullstack.response.PostResponse;
import com.example.mxhfullstack.response.PostResponseWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CommentService {
	private final static String apiURL = Utils.BASE_URL + "comment";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public CommentService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	public List<CommentResponse> getAllcmtByPostId(PageInfo pageInfo, Long id) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/all/" + id;
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    System.out.println("cmt: " + json);
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    CommentResponseWrapper responseWrapper = objectMapper.readValue(json, CommentResponseWrapper.class);
	    List<CommentResponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	
	public String addComment(CommentSaveRequest commentSaveRequest, Long postId) throws Exception {
		String apiurl = apiURL + "/" + postId;
		RequestEntity<?> requestEntity = new RequestEntity<>(commentSaveRequest, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    return responseEntity.getBody();
	}
	
	public String deleteComment(Long cmtId) throws Exception {
		String apiurl = apiURL + "/delete/" + cmtId;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    return responseEntity.getBody();
	}
	
	public String updateComment(CommentSaveRequest commentSaveRequest) throws Exception {
		String apiurl = apiURL + "/update";
		RequestEntity<?> requestEntity = new RequestEntity<>(commentSaveRequest, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    return responseEntity.getBody();
	}
}
