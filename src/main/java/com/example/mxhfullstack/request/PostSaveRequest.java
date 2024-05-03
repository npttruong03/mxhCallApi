package com.example.mxhfullstack.request;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostSaveRequest {

    private String content;

    private Integer privacy;

    @JsonProperty("images")
    private List<Long> imageIds = new ArrayList<>();
}
