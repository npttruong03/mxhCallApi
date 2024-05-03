package com.example.mxhfullstack.response;

import com.example.mxhfullstack.dto.BaseDTO;
import com.example.mxhfullstack.enumtype.NotificationSeenType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationResponse extends BaseDTO {
    private String content;

    private NotificationSeenType status;

    @JsonProperty("notification_post")
    private NotificationPostResponse notificationPostResponse;

    @JsonProperty("notification_follow")
    private NotificationFollowResponse notificationFollowResponse;
}
