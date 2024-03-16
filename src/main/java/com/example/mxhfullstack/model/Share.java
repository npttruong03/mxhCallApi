package com.example.mxhfullstack.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Share extends BaseEntity{
	private String content;

    private User user;

    private Post post;

    private List<NotificationFollow> notificationFollowList;

    private List<Report> reportList;
}
