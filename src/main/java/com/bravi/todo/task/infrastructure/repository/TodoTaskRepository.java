package com.bravi.todo.task.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bravi.todo.task.domain.model.TodoTask;

@Repository
public class TodoTaskRepository {

	private Long idCounter = 0L;
	private Map<Long, TodoTask> mapTodoTasks = new HashMap<Long, TodoTask>();
	
	public Long insert(TodoTask todoTask) {
		todoTask.setId(idCounter++);
		mapTodoTasks.put(todoTask.getId(), todoTask);
		return todoTask.getId();
	}
	
	public List<TodoTask> findAll() {
		return mapTodoTasks.isEmpty() ? null : new ArrayList<>(mapTodoTasks.values());
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
	
	
//	
//	TodoTaskItem taskItem = new TodoTaskItem();
//	taskItem.setId(idCounter++);
//	taskItem.setDone(false);
//	taskItem.setCreatedDate(Calendar.getInstance().getTime());
//	Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT -3"));
//	calendar.set(2021, 06, 10, 15, 30);
//	taskItem.setStartDate(calendar.getTime());
//	calendar.set(2021, 06, 10, 17, 30, 00);
//	taskItem.setFinishDate(calendar.getTime());
//	taskItem.setDescription("Task #1 here");
//	todoItems.add(taskItem);
}