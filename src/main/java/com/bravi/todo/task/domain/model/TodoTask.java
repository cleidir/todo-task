package com.bravi.todo.task.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoTask {

	private Long id;
	private String description;
	private Date createdDate;
	private Date startDate;
	private Date finishDate;
	private boolean isDone;
	private List<Comment> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public List<Comment> getComments() {
		return comments == null ? new ArrayList<Comment>(): comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}