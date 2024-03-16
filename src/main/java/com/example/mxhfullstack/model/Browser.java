package com.example.mxhfullstack.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data

public class Browser extends BaseEntity{
    private User user;
    private String ip;
    private String browser;
}
