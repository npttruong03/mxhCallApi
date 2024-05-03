package com.example.mxhfullstack.response;

import java.time.LocalDate;

import com.example.mxhfullstack.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class UserInfoResponse extends BaseDTO {
	@JsonProperty("username")
	 private String username;

	    //private String password;

	    //private String email;

//	    private boolean active;
		@JsonProperty("gender")
	    private boolean gender;
		
		@JsonProperty("last_name")
	    private String lastName;

		@JsonProperty("first_name")
	    private String firstName;

		@JsonProperty("dob")
	    private LocalDate dob;

		@JsonProperty("bio")
	    private String bio;

	    private ImageResponse avatar_image;

	    private ImageResponse cover_image;

	    @JsonProperty("hometown")
	    private AddressResponse homeTown;
	    
	    @JsonProperty("current_city")
	    private AddressResponse currentCity;
}
