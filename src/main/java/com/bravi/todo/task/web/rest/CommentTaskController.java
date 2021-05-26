package com.bravi.todo.task.web.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bravi.todo.task.domain.model.Comment;
import com.bravi.todo.task.domain.usecase.service.CommentTaskService;
import com.bravi.todo.task.web.rest.dtos.CommentInsertDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class CommentTaskController {

	@Autowired
	private CommentTaskService commentService;

	@PostMapping("/api/todoTasks/{id}/comments")
	public ResponseEntity<?> insert(@PathVariable("id") Long idTask, @RequestBody CommentInsertDTO commentInsertDTO) {
		Comment comment = commentInsertDTO.toEntity();
		comment.setIdTodoTask(idTask);

		Long id = commentService.insert(comment);
		if (id == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(id);
	}

	@PostMapping("/api/todoTasks/{id}/comments/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long idTask, @PathVariable("id") Long id) {
		return Optional.ofNullable(commentService.findOne(idTask, id)).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/api/todoTasks/{id}/comments")
	public ResponseEntity<?> getList(@PathVariable("id") Long idTask) {
		return Optional.ofNullable(commentService.findAll(idTask)).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/api/todoTasks/{id}/comments/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long idTask, @PathVariable("id") Long id) {
		Comment comment = commentService.findOne(idTask, id);
		if (comment == null) {
			return ResponseEntity.notFound().build();
		}
		commentService.delete(comment.getId());
		return ResponseEntity.ok().build();
	}
}