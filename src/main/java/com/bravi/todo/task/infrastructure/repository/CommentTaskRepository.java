package com.bravi.todo.task.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bravi.todo.task.domain.model.Comment;

@Repository
public class CommentTaskRepository {

	private Long idCounter = 1L;
	private Map<Long, Comment> mapComments = new HashMap<Long, Comment>();
	
	public Long insert(Comment comment) {
		comment.setId(idCounter++);
		mapComments.put(comment.getId(), comment);
		return comment.getId();
	}

	public List<Comment> findAll(Long idTask) {
		List<Comment> comments = new ArrayList<>();
		for (Iterator<Comment> iterateComment = mapComments.values().iterator(); iterateComment.hasNext();) {
			Comment comment = (Comment) iterateComment.next();
			if(comment.getIdTodoTask() == idTask) {
				comments.add(comment);
			}
		}
		return comments.isEmpty() ? null : comments;
	} 
	
	public Comment findOne(Long idTask, Long id) {
		for (Iterator<Comment> iterateComment = mapComments.values().iterator(); iterateComment.hasNext();) {
			Comment comment = (Comment) iterateComment.next();
			if(comment.getIdTodoTask() == idTask && comment.getId() == id) {
				return comment;
			}
		}
		return null;
	}
	
	public void delete(Long id) {
		mapComments.remove(id);
	}
}