package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MemberGroupMessage extends BaseEntity{
	private User user;

//  @ManyToMany(mappedBy = "memberGroupMessageList")
//  private List<GroupMessage> groupMessageList;

  private GroupMessage groupMessage;

  private boolean admin;

  private List<ChatGroupMessage> chatGroupMessageList = new ArrayList<>();
}
