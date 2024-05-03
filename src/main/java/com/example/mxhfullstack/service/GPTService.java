package com.example.mxhfullstack.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mxhfullstack.request.ChatGPTRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GPTService {

	private RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objectMapper = new ObjectMapper();
    private final String API_URL = "https://api.coze.com/open_api/v2/chat";
    private final String ACCESS_TOKEN = "pat_GYclDat5fCPUwLdntMgnczISfwCQclk1sWJhsc3xB5x14BSHCrO7ZmUi2qPfgRMS";
    private final String BOT_ID = "7360900876094930952";
    private final String USER_ID = "123333333";


    public String callApi(String query) {
        // Create the request body as an object
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("conversation_id", "123");
        requestBody.put("bot_id", BOT_ID);
        requestBody.put("user", USER_ID);
        requestBody.put("query", query);
        requestBody.put("stream", false);

        // Serialize the request body to JSON
        String requestBodyJson;
        try {
            requestBodyJson = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error: Unable to serialize request body";
        }

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);

        // Build the request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBodyJson, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, String.class);

        // Check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "Error: " + response.getStatusCode();
        }
    }
}