package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class GroupMessage extends BaseEntity{
	private List<Image> avatar;
    private User author;

//    @ManyToMany
//    @JoinTable(name = "member_group_message_list", joinColumns = @JoinColumn(name = "group_id",nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "member_id",nullable = false))
//    private List<MemberGroupMessage> memberGroupMessageList = new ArrayList<>();
//
    private List<MemberGroupMessage> memberGroupMessageList = new ArrayList<>();

    private List<ChatGroupMessage> chatGroupMessageList = new ArrayList<>();
}
