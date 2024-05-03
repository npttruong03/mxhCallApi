package com.example.mxhfullstack.response;

import java.util.List;

import com.example.mxhfullstack.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostResponse extends BaseDTO {
	@JsonProperty("author")
	private UserAuthorResponse authorResponse;
    private String content;
    private Integer privacy;

    @JsonProperty("images")
    private List<ImageResponse> images;

    @JsonProperty("like_count")
    private Long likeCount;

    
    @JsonProperty("cmt_count")
    private Long commentCount;

    @JsonProperty("share_count")
    private Long shareCount;

    private Boolean liked;
}
