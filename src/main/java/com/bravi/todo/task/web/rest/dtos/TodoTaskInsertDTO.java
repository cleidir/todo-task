package com.bravi.todo.task.web.rest.dtos;

import java.util.Calendar;
import java.util.Date;

import com.bravi.todo.task.domain.model.TodoTask;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoTaskInsertDTO {

	private String description;
	private Date createdDate;
	private Date startDate;
	private Date finishDate;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public TodoTask toEntity() {
		TodoTask task = new TodoTask();
		task.setCreatedDate(Calendar.getInstance().getTime()); 
		task.setDescription(this.getDescription()); 
		task.setFinishDate(this.getFinishDate()); 
		task.setStartDate(this.getStartDate());
		return task;
	}
}