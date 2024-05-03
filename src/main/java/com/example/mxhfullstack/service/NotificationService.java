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
import com.example.mxhfullstack.model.PageInfo;
import com.example.mxhfullstack.response.CommentResponse;
import com.example.mxhfullstack.response.CommentResponseWrapper;
import com.example.mxhfullstack.response.NotificationResponse;
import com.example.mxhfullstack.response.NotificationResponseWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotificationService {
	private final static String apiURL = Utils.BASE_URL + "notification";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public NotificationService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	public List<NotificationResponse> getAllNotificattion(PageInfo pageInfo) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL;
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    NotificationResponseWrapper responseWrapper = objectMapper.readValue(json, NotificationResponseWrapper.class);
	    List<NotificationResponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	
}
