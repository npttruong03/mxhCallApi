package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity{
	private User author;

    private String content;

    private Integer privacy; /* 1-cong khai 2-ban be 3- chi minh toi*/

// cascadetype.all la xoa post thi all cmt cx bi xoa nhe
    private List<Comment> comments=new ArrayList<>();

    private List<Image> images = new ArrayList<>();

    private List<Like> likes = new ArrayList<>();

    private List<Share> shares = new ArrayList<>();

    private List<Bookmark> bookmarks = new ArrayList<>();

    private List<NotificationPost> notificationPostList;

    private List<NotificationFollow> notificationFollowList;

    private List<Report> reportList;
}
