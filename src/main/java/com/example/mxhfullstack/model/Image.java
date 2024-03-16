package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;


import lombok.Data;

@Entity
@Data
public class Image extends BaseEntity{
	private String linkImage;

    private List<User> userAvatar = new ArrayList<>();

    private List<User> userCover = new ArrayList<>();

    private List<Post> post = new ArrayList<>();

    private List<Comment> comment;

    private List<Message> message;

    private List<GroupMessage> groupMessage;

    private List<ChatGroupMessage> chatGroupMessage;
}
