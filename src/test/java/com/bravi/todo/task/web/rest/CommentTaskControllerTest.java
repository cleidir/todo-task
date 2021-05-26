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

import com.bravi.todo.task.domain.model.Comment;
import com.bravi.todo.task.web.rest.dtos.CommentInsertDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CommentTaskControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@org.junit.jupiter.api.Test
	public void shouldPostANewTask() throws Exception {

		CommentInsertDTO dto = new CommentInsertDTO();
		dto.setDescription("new comment");

		URL url = new URL("http://localhost:" + port + "/api/todoTasks/1/comments");
		
		ResponseEntity<Long> response = restTemplate.postForEntity(url.toString(), dto, Long.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldReturnNotFound() throws Exception {

		CommentInsertDTO dto = new CommentInsertDTO();
		dto.setDescription("new comment");

		URL url = new URL("http://localhost:" + port + "/api/todoTasks/1/comments");
		
		ResponseEntity<Comment> response = restTemplate.getForEntity(url.toString(), Comment.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void shouldDeleteAComment() throws Exception {

		URL url = new URL("http://localhost:" + port + "/api/todoTasks/1/comments/1");
		
		restTemplate.delete(url.toString());
	}
}