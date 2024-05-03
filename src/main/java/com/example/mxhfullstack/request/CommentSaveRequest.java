package com.example.mxhfullstack.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CommentSaveRequest {
    private String content;

    @JsonProperty("image_id")
    private Long imageId;
}
