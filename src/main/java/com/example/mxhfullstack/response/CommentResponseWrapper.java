package com.example.mxhfullstack.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentResponseWrapper {
	@JsonProperty("content")
	private List<CommentResponse> content;

    public List<CommentResponse> getContent() {
        return content;
    }

    public void setContent(List<CommentResponse> content) {
        this.content = content;
    }
}
