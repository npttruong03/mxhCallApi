package com.example.mxhfullstack.response;

import com.example.mxhfullstack.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class CommentResponse extends BaseDTO{
	
    private String content;

    @JsonProperty("author")
    private UserAuthorResponse userAuthorResponse;

    @JsonProperty("image")
    private ImageResponse imageResponse;
}
