package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class Comment extends BaseEntity{
    private String content;

    private User user;

    private Post post;

    private List<Image> images = new ArrayList<>();

    private List<Report> reportList;
}
