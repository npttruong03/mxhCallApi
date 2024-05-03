package com.example.mxhfullstack.response;

import com.example.mxhfullstack.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class MessageReponse extends BaseDTO{
	@JsonProperty("user_Source")
	private UserInfoResponse userSource;
	
	@JsonProperty("user_Target")
	private UserInfoResponse userTarget;
	
	private String content;
	
	private String chatId;
}
