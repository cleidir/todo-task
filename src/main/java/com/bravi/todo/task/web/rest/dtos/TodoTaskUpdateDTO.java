package com.bravi.todo.task.web.rest.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bravi.todo.task.domain.model.Comment;
import com.bravi.todo.task.domain.model.TodoTask;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoTaskUpdateDTO {

	private Long id;
	private String description;
	private Date createdDate;
	private Date startDate;
	private Date finishDate;
	private boolean isDone;
	private List<CommentInsertDTO> comments;

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

	public List<CommentInsertDTO> getComments() {
		return comments == null ? new ArrayList<CommentInsertDTO>() : comments;
	}

	public void setComments(List<CommentInsertDTO> comments) {
		this.comments = comments;
	}
	
	public TodoTask toEntity() {
		TodoTask task = new TodoTask();
		task.setDescription(this.getDescription()); 
		task.setDone(this.isDone()); 
		task.setFinishDate(this.getFinishDate()); 
		task.setStartDate(this.getStartDate());
		addComments(task);
		return task;
	}

	private void addComments(TodoTask task) {
		for(CommentInsertDTO commentInsertDTO : this.getComments()) {
			Comment comment = new Comment();
			comment.setCreatedDate(commentInsertDTO.getCreatedDate());
			comment.setDescription(commentInsertDTO.getDescription());
			comment.setIdTodoTask(commentInsertDTO.getIdTodoTask());
			task.getComments().add(comment);
		}
	}
}