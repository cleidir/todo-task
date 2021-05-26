package com.bravi.todo.task.web.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bravi.todo.task.domain.model.TodoTask;
import com.bravi.todo.task.web.rest.dtos.TodoTaskInsertDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoTaskControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldPostANewTask() throws Exception {

		TodoTaskInsertDTO dto = new TodoTaskInsertDTO();
		dto.setDescription("new task");

		URL url = new URL("http://localhost:" + port + "/api/todoTasks");
		
		ResponseEntity<Long> response = restTemplate.postForEntity(url.toString(), dto, Long.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldReturnNotFound() throws Exception {

		TodoTaskInsertDTO dto = new TodoTaskInsertDTO();
		dto.setDescription("new task");

		URL url = new URL("http://localhost:" + port + "/api/todoTasks/1");
		
		ResponseEntity<TodoTask> response = restTemplate.getForEntity(url.toString(), TodoTask.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void shouldDeleteATask() throws Exception {

		URL url = new URL("http://localhost:" + port + "/api/todoTasks/1");
		
		restTemplate.delete(url.toString());
	}
}