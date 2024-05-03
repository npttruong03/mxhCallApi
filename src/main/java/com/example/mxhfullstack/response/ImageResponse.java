package com.example.mxhfullstack.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ImageResponse {
	@JsonProperty("id")
    private Long id;

    @JsonProperty("link_image")
    private String linkImage;
}
