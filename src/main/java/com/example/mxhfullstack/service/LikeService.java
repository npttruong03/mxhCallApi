package com.example.mxhfullstack.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.response.UserInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LikeService {
	private final static String apiURL = Utils.BASE_URL + "like/";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public LikeService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	public String like(Long postId) throws Exception{
		String apiurl = apiURL + postId;
		RequestEntity<?> requestEntity = new RequestEntity<>(appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiurl));
		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		return responseEntity.getBody();
	}
}
