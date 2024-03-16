package com.example.mxhfullstack.model;

import javax.persistence.Entity;


import lombok.Data;

@Entity
@Data
public class Follower extends BaseEntity{
    private User user;
}
