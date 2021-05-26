package com.bravi.todo.task.domain.usecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bravi.todo.task.domain.model.Comment;
import com.bravi.todo.task.infrastructure.repository.CommentTaskRepository;

@Service
public class CommentTaskService {

	@Autowired
	private CommentTaskRepository commentTaskRepository;

	public Long insert(Comment comment) {
		return commentTaskRepository.insert(comment);
	}

	public Comment findOne(Long idTask, Long id) {
		return commentTaskRepository.findOne(idTask, id);
	}

	public List<Comment> findAll(Long idTask) {
		return commentTaskRepository.findAll(idTask);
	}

	public void delete(Long id) {
		commentTaskRepository.delete(id);
	}
}