package com.learning.junitmockito.service;

import java.util.List;
import java.util.stream.Collectors;

public class TodoBusinessImpl {
	private TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> allTodos = todoService.retrieveTodos(user);
		List<String> filteredTodos = allTodos.stream().filter(todo -> todo.contains("Spring"))
				.collect(Collectors.toList());
		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> allTodos = todoService.retrieveTodos(user);
		allTodos.forEach(todo -> {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		});
	}
}