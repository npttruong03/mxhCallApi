package com.example.mxhfullstack.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationResponseWrapper {
	@JsonProperty("content")
	private List<NotificationResponse> content;

    public List<NotificationResponse> getContent() {
        return content;
    }

    public void setContent(List<NotificationResponse> content) {
        this.content = content;
    }
}
