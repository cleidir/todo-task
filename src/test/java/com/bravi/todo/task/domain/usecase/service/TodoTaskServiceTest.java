package com.bravi.todo.task.domain.usecase.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bravi.todo.task.domain.model.TodoTask;

@SpringBootTest
public class TodoTaskServiceTest {

	@Autowired
	private TodoTaskService taskService;
	
	@Test
	public void shouldInsertNewTask() {
		TodoTask newTask = new TodoTask();
		newTask.setDescription("My new task was created.");
		newTask.setComments(new ArrayList<>());
		Long id = taskService.insert(newTask);
		
		assertThat(id).isNotNull(); 
		
		TodoTask task = taskService.findOne(id);
		assertThat(task.getCreatedDate()).isEqualTo(newTask.getCreatedDate()); 
		assertThat(task.getDescription()).isEqualTo(newTask.getDescription()); 
		assertThat(task.getStartDate()).isNull(); 
		assertThat(task.getFinishDate()).isNull(); 
		assertThat(task.getComments()).isEmpty(); 
		assertThat(task.isDone()).isFalse(); 
	}
	
	@Test
	public void shouldReturnTodoTaskWhenPassedAnId() {
		TodoTask taskDefault = createTaskDefault();
		Long id = taskService.insert(taskDefault);
		
		TodoTask task = taskService.findOne(id);
		assertThat(task.getCreatedDate()).isInSameHourAs(taskDefault.getCreatedDate()); 
		assertThat(task.getDescription()).isEqualTo(taskDefault.getDescription()); 
		assertThat(task.getStartDate()).isInSameHourAs(taskDefault.getStartDate()); 
		assertThat(task.getFinishDate()).isNull(); 
	}
	
	@Test
	public void shouldUpdateOneTask() {
		TodoTask taskDefault = createTaskDefault();
		Long id = taskService.insert(taskDefault);
		
		taskDefault.setDescription("Work on task is starting now.");
		taskDefault.setStartDate(Calendar.getInstance().getTime());
		
		taskService.update(taskDefault );
		
		TodoTask task = taskService.findOne(id);
		assertThat(task.getDescription()).isEqualTo(taskDefault.getDescription()); 
		assertThat(task.getStartDate()).isEqualTo(taskDefault.getStartDate()); 
	}
	
	@Test
	public void shouldDeleteOneTask() {
		TodoTask taskDefault = createTaskDefault();
		Long id = taskService.insert(taskDefault);
		
		assertThat(taskService.findOne(id)).isNotNull();
		
		taskService.delete(id);
		
		assertThat(taskService.findOne(id)).isNull();
	}
	
	@Test
	public void shouldReturnAllTasks() {
		TodoTask taskDefault = createTaskDefault();
		taskService.insert(taskDefault);
		taskService.insert(taskDefault);
		
		assertThat(taskService.findAll().size()).isGreaterThan(1);
	}
	
	@Test
	public void shouldUpdateOneTaskToDone() {
		TodoTask taskDefault = createTaskDefault();
		Long id = taskService.insert(taskDefault);
		
		taskDefault.setDescription("Work on task was finished.");
		taskDefault.setFinishDate(plusHoursToDate(taskDefault.getStartDate(), 8));
		taskDefault.setDone(true);
		
		taskService.update(taskDefault);
		
		TodoTask task = taskService.findOne(id);
		assertThat(task.getDescription()).isEqualTo(taskDefault.getDescription()); 
		assertThat(task.getCreatedDate()).isEqualTo(taskDefault.getCreatedDate()); 
		assertThat(task.getStartDate()).isEqualTo(taskDefault.getStartDate()); 
		assertThat(task.getFinishDate()).isEqualTo(taskDefault.getFinishDate()); 
		assertThat(task.isDone()).isTrue(); 
	}

	private TodoTask createTaskDefault() {
		TodoTask taskDefault = new TodoTask();
		taskDefault.setId(1L);
		Date date = createDateLocal();
		taskDefault.setCreatedDate(date);
		taskDefault.setDescription("description of task.");
		taskDefault.setStartDate(date);
		taskDefault.setDone(true);
		return taskDefault;
	}

	private Date plusHoursToDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}

	private Date createDateLocal() {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		return gc.getTime();
	}
}