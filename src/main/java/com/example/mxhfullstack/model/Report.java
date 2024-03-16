package com.example.mxhfullstack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.mxhfullstack.enumtype.ReportStatusType;
import com.example.mxhfullstack.enumtype.ReportType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report extends BaseEntity{
	private User userSource;

//  @ManyToOne
//  @JoinColumn(name = "user_target_id")
//  private User userTarget;

  private ReportType reportType;

  private String content;

  private ReportStatusType status;

  private Comment comment;

  private Post post;

  private Share share;
}
