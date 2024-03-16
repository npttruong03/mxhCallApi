package com.example.mxhfullstack.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.mxhfullstack.enumtype.NotificationSeenType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private Long id;

    private Date createdDate;

    private String content;

    private User user;

    private NotificationSeenType status;

    private NotificationPost notificationPost;

    private NotificationFollow notificationFollow;
}
