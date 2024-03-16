package com.example.mxhfullstack.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data

public class ChatGroupMessage extends BaseEntity{
	 	private String content;

	    private MemberGroupMessage member;

	    private GroupMessage groupMessage;

	    private List<Image> image;
}
