package com.example.mxhfullstack.model;


import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Like extends BaseEntity{
	private User user;

    private Post post;

    private boolean status;
}
