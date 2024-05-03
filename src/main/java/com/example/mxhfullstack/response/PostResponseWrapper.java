package com.example.mxhfullstack.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponseWrapper {

	@JsonProperty("content")
	private List<PostResponse> content;

    public List<PostResponse> getContent() {
        return content;
    }

    public void setContent(List<PostResponse> content) {
        this.content = content;
    }
}
