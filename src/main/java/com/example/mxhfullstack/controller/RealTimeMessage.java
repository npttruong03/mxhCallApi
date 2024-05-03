package com.example.mxhfullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.example.mxhfullstack.model.Message;
import com.example.mxhfullstack.request.MessageSaveRequest;

public class RealTimeMessage {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/chat/{chatId}")
	public Message sendToUser(@Payload Message message, @DestinationVariable String chatId) {
		
		simpMessagingTemplate.convertAndSendToUser(chatId,"/private",message);
		
		return message;
	}
}
