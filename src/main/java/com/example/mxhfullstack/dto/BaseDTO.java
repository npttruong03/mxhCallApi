package com.example.mxhfullstack.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BaseDTO {
	@JsonProperty("id")
    private Long id;

    @JsonProperty("created_date")
    private Date createdDate;
}
