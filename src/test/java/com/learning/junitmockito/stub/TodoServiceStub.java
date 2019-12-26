package com.learning.junitmockito.stub;

import java.util.Arrays;
import java.util.List;

import com.learning.junitmockito.service.TodoService;

public class TodoServiceStub implements TodoService {
	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	@Override
	public void deleteTodo(String todo) {
	}
}
