package com.example.mxhfullstack.response;

import com.example.mxhfullstack.enumtype.NotificationPostType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationPostResponse {
    @JsonProperty("notification_post_type")
    private NotificationPostType notificationPostType;

    @JsonProperty("post_id")
    private Long postId;

    private String avatar;
}
