package com.bravi.todo.task.infrastructure.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.bravi.todo.task.domain.model.TodoTask;

@Repository
public class TodoTaskRepository {

	private Long idTaskCounter = 1L;
	private Map<Long, TodoTask> mapTodoTasks = new HashMap<Long, TodoTask>();
	
	public Long insert(TodoTask todoTask) {
		todoTask.setId(idTaskCounter++);
		mapTodoTasks.put(todoTask.getId(), todoTask);
		return todoTask.getId();
	}

	public List<TodoTask> findAll() {
		List<TodoTask> tasks = mapTodoTasks.values().stream().collect(Collectors.toList());
		return mapTodoTasks.isEmpty() ? null : tasks;
	}
	
	public TodoTask findOne(Long id) {
		return mapTodoTasks.get(id);
	}

	public void update(TodoTask todoTask) {
		mapTodoTasks.put(todoTask.getId(), todoTask);
	}
	
	public void delete(Long id) {
		mapTodoTasks.remove(id);
	}
}