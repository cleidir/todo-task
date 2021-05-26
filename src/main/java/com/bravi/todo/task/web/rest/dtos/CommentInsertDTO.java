package com.bravi.todo.task.web.rest.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentInsertDTO {

	private Long id;
	private Long idTodoTask;
	private String description;
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTodoTask() {
		return idTodoTask;
	}

	public void setIdTodoTask(Long idTodoTask) {
		this.idTodoTask = idTodoTask;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}