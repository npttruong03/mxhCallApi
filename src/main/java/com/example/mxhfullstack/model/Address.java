package com.example.mxhfullstack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Address extends BaseEntity{
	    private Long id;
	    private String name;
	    private User userHomeTown;
	    private User userCurrentCity;
}
