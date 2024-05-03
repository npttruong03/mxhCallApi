package com.example.mxhfullstack.response;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class UserAuthorResponse {
	@JsonProperty("id")
    private Long id;

	@JsonProperty("username")
    private String username;

	@JsonProperty("last_name")
    private String lastName;

	@JsonProperty("first_name")
    private String firstName;

	@JsonProperty("avatar_image")
    private ImageResponse avatar;
}
