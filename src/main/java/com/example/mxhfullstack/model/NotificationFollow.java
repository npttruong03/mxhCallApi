package com.example.mxhfullstack.model;

import javax.persistence.CascadeType;
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
public class NotificationFollow {
	private Long id;

    private Post post;

    private Share share;

    private Notification notification;
}
