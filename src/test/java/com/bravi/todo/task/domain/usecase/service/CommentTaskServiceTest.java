package com.bravi.todo.task.domain.usecase.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bravi.todo.task.domain.model.Comment;

@SpringBootTest
public class CommentTaskServiceTest {

	@Autowired
	private CommentTaskService commentService;
	
	@Test
	public void shouldInsertNewComment() {
		Comment newComment = new Comment();
		newComment.setIdTodoTask(1L);
		newComment.setDescription("new comment to my task.");
		Long id = commentService.insert(newComment);
		
		assertThat(id).isNotNull(); 
		
		Comment comment = commentService.findOne(newComment.getIdTodoTask(), id);
		assertThat(comment.getCreatedDate()).isEqualTo(comment.getCreatedDate()); 
		assertThat(comment.getDescription()).isEqualTo(comment.getDescription()); 
	}
	
	@Test
	public void shouldReturnCommentWhenPassedAnId() {
		Comment newComment = new Comment();
		newComment.setIdTodoTask(1L);
		newComment.setDescription("first comment to my task.");
		commentService.insert(newComment);
		newComment = new Comment();
		newComment.setIdTodoTask(1L);
		newComment.setDescription("second comment to my task.");
		commentService.insert(newComment);
		
		List<Comment> comments = commentService.findAll(newComment.getIdTodoTask());
		assertThat(comments.size()).isGreaterThan(1);
		assertThat(comments.get(0).getDescription()).isEqualTo("first comment to my task.");
		assertThat(comments.get(1).getDescription()).isEqualTo("second comment to my task.");
	}

	@Test
	public void shouldDeleteComment() {
		Comment newComment = new Comment();
		newComment.setIdTodoTask(1L);
		newComment.setDescription("first comment to my task.");
		Long id = commentService.insert(newComment);
		
		commentService.delete(id);
		Comment comment = commentService.findOne(newComment.getIdTodoTask(), id);
		assertThat(comment).isNull(); 
	}
	
	@Test
	public void shouldReturnEmpty() {
		List<Comment> comments = commentService.findAll(100L);
		assertThat(comments).isNull();
	}
}