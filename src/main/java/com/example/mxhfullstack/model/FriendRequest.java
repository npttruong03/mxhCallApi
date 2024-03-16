package com.example.mxhfullstack.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class FriendRequest extends BaseEntity{
	private User user;
}
