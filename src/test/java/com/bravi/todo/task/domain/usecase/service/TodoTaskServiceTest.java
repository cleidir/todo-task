package com.bravi.todo.task.domain.usecase.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bravi.todo.task.domain.model.Comment;
import com.bravi.todo.task.domain.model.TodoTask;

@SpringBootTest
public class TodoTaskServiceTest {

	@Autowired
	private TodoTaskService taskService;
	
	private TodoTask taskDefault; 
	
	@BeforeEach
	private void beforeTest() {
		createTaskDefault(); 
	}

	@Test
	public void shoudReturnTodoWhenPassedAnId() {
		assertThat(taskService.findOne(1L)).isEqualTo(taskDefault); 
	}

	private void createTaskDefault() {
		taskDefault = new TodoTask();
		taskDefault.setId(1L);
		Date date = Calendar.getInstance().getTime();
		taskDefault.setCreatedDate(date);
		taskDefault.setDescription("description of task.");
		taskDefault.setFinishDate(date);
		taskDefault.setStartDate(date);
		taskDefault.setDone(true);
		
		Comment comment = new Comment();
		comment.setId(1L);
		comment.setIdTodoTask(1L);
		comment.setDescription("Some comment about the task.");
		comment.setCreatedDate(date);
		taskDefault.getComments().add(comment);
	}
}