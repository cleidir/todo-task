package com.bravi.todo.task.domain.usecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bravi.todo.task.domain.model.TodoTask;
import com.bravi.todo.task.infrastructure.repository.TodoTaskRepository;

@Service
public class TodoTaskService {

	@Autowired
	private TodoTaskRepository todoTaskRepository;

	public Long insert(TodoTask todoTask) {
		return todoTaskRepository.insert(todoTask);
	}

	public TodoTask findOne(Long id) {
		return todoTaskRepository.findOne(id);
	}

	public List<TodoTask> findAll() {
		return todoTaskRepository.findAll();
	}

	public void update(TodoTask todoTask) {
		todoTaskRepository.update(todoTask);
	}

	public void delete(Long id) {
		todoTaskRepository.delete(id);
	}
}