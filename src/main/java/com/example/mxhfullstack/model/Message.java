package com.example.mxhfullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseEntity{
	 	private String content;

	    private User userSource;

	    private User userTarget;

	    private List<Image> image = new ArrayList<>();
	    
	    private String chatId;
}
