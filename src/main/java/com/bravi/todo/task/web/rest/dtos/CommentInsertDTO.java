package com.bravi.todo.task.web.rest.dtos;

import java.util.Calendar;

import com.bravi.todo.task.domain.model.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentInsertDTO {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Comment toEntity() {
		Comment comment = new Comment();
		comment.setCreatedDate(Calendar.getInstance().getTime()); 
		comment.setDescription(this.getDescription()); 
		comment.setCreatedDate(Calendar.getInstance().getTime());
		return comment;
	}
}