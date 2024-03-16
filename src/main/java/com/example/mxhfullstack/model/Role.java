package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


import lombok.Data;

@Entity
@Data
public class Role {
	 	private Long id;
	 
	    private String name;

	    private List<User> users = new ArrayList<>();
}
