package com.example.mxhfullstack.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conversation extends BaseEntity{
    private String senderId;
    
    private String recipientId;

    private String chatId;
}
