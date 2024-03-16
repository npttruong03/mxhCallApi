package com.example.mxhfullstack.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class User extends BaseEntity{
    private String username;

    private String password;

    private String email;

    private boolean active;

    private boolean gender;

    private String lastName;

    private String firstName;

    private LocalDate dob;

    private String bio;

    private Address homeTown;


    private Address currentCity;


    private List<Image> avatarImage = new ArrayList<>();


    private List<Image> coverImage = new ArrayList<>();


    private List<Friend> friends = new ArrayList<>();

    private List<FriendRequest> friendRequests = new ArrayList<>();

    private List<Role> roles = new ArrayList<>();

    private List<Post> posts = new ArrayList<>();

    private List<Follower> followers = new ArrayList<>();

    private List<Following> followings = new ArrayList<>();

    private List<Like> likes = new ArrayList<>();

    private List<Share> shares= new ArrayList<>();

    private List<Bookmark> bookmarks = new ArrayList<>();

    private List<GroupMessage> groupMessageList = new ArrayList<>();

    private List<Notification> notifications = new ArrayList<>();
    private List<Report> reports = new ArrayList<>();
    private List<Browser> browsers = new ArrayList<>();
}
