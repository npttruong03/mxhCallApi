package com.example.mxhfullstack.response;


import com.example.mxhfullstack.dto.BaseDTO;
import com.example.mxhfullstack.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class FriendResponse extends BaseDTO {
	@JsonProperty("user_info")
	private UserInfoResponse user_info;
}
