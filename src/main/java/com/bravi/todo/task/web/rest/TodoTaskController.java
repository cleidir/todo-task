package com.bravi.todo.task.web.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bravi.todo.task.domain.model.TodoTask;
import com.bravi.todo.task.domain.usecase.service.TodoTaskService;
import com.bravi.todo.task.web.rest.dtos.TodoTaskInsertDTO;
import com.bravi.todo.task.web.rest.dtos.TodoTaskUpdateDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000/" )
public class TodoTaskController {
	
	@Autowired
	private TodoTaskService todoTaskService;
	
	@PostMapping("/api/todoItems")
	public ResponseEntity<Long> insert(@RequestBody TodoTaskInsertDTO todoTaskItemInsertDTO) {
		Long id = todoTaskService.insert(todoTaskItemInsertDTO.toEntity());
		if(id == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(id);
	}
	
	@GetMapping("/api/todoItems/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
		return Optional.ofNullable(todoTaskService.findOne(id)).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> getList() {
		return Optional.ofNullable(todoTaskService.findAll()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PatchMapping("/api/todoItems/{id}/")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TodoTaskUpdateDTO todoTaskUpdateDTO) {
		TodoTask todoTask = todoTaskService.findOne(id);
		if (todoTask == null) {
			return ResponseEntity.notFound().build();
		}
		TodoTask taskItem = todoTaskUpdateDTO.toEntity();
		taskItem.setId(id);
		todoTaskService.update(taskItem);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/api/todoItems/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		TodoTask todoTask = todoTaskService.findOne(id);
		if (todoTask == null) {
			return ResponseEntity.notFound().build();
		}
		todoTaskService.delete(id);
		return ResponseEntity.ok().build();
	}
}