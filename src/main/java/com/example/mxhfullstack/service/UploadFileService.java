package com.example.mxhfullstack.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.mxhfullstack.Utils.Utils;
import com.example.mxhfullstack.config.AppConfig;
import com.example.mxhfullstack.model.Image;


@Service
public class UploadFileService {
	private final static String apiURL = Utils.BASE_URL + "upload";
	
	private HttpHeaders headers = new HttpHeaders();
	RestTemplate restTemplate = new RestTemplate();
	
	private AppConfig appConfig;
	
	@Autowired
	public UploadFileService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
//	public List<Image> creat(MultipartFile[] files) {
//		String apiString = apiURL;
//		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//		for(MultipartFile file : files) {
//			body.add("files", file.getResource());
//		}
//		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
////		RequestEntity<?> requestEntity = new RequestEntity<>(image, appConfig.cookieStore().getHeaders(), HttpMethod.POST, URI.create(apiString));
//		ResponseEntity<List<Image>> response = restTemplate.exchange(HttpMethod.POST, URI.create(apiString), requestEntity, new ParameterizedTypeReference<List<Image>>() {});
//		return response.getBody();	
//	}
	
	public List<Image> uploadFiles(MultipartFile[] files) {
		String apiString = apiURL;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        for (MultipartFile file : files) {
            body.add("files", file.getResource());
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<List<Image>> responseEntity = restTemplate.exchange(
                URI.create(apiString),
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<Image>>() {}
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Error occurred during file upload: " + responseEntity.getStatusCode());
        }
    }

}
