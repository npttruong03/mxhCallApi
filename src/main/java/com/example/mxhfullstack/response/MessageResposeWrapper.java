package com.example.mxhfullstack.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResposeWrapper {
	@JsonProperty("content")
	private List<MessageReponse> content;

    public List<MessageReponse> getContent() {
        return content;
    }

    public void setContent(List<MessageReponse> content) {
        this.content = content;
    }
}
