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
import com.example.mxhfullstack.request.MessageSaveRequest;
import com.example.mxhfullstack.response.MessageReponse;
import com.example.mxhfullstack.response.MessageResposeWrapper;
import com.example.mxhfullstack.response.PostResponse;
import com.example.mxhfullstack.response.PostResponseWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageService {
	private final static String apiURL = Utils.BASE_URL + "message";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public MessageService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	public List<MessageReponse> getAllMessageByMeAndUserId(PageInfo pageInfo, Long userTarget) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/getMessage/" + userTarget;
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    System.out.println("post: " + json);
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    MessageResposeWrapper responseWrapper = objectMapper.readValue(json, MessageResposeWrapper.class);
	    List<MessageReponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	
	public String creatMessage(String userTarget, MessageSaveRequest messageSaveRequest) {
		String apiurl = apiURL + "/chat/" + userTarget;
	    RequestEntity<?> requestEntity = new RequestEntity<>(messageSaveRequest, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    return responseEntity.getBody();
	}
	
	public String deleteMessage(Long messageId) {
		String apiurl = apiURL + "/delete/" + messageId;
	    RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    return responseEntity.getBody();
	}
	
	public List<MessageReponse> getAlluserMessageByme(PageInfo pageInfo) throws JsonMappingException, JsonProcessingException {
	    String apiurl = apiURL + "/allUser/message/me";
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RequestEntity<?> requestEntity = new RequestEntity<>(pageInfo, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
	    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
	    String json = responseEntity.getBody();
	    System.out.println("post: " + json);
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.findAndRegisterModules();
	    MessageResposeWrapper responseWrapper = objectMapper.readValue(json, MessageResposeWrapper.class);
	    List<MessageReponse> getAll = responseWrapper.getContent();
	    return getAll;
	}
	
}
