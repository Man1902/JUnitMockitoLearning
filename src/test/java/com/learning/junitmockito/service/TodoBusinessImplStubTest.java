package com.learning.junitmockito.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.learning.junitmockito.stub.TodoServiceStub;

//Case1 : Using stub impl
public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("User1");
		Assert.assertEquals(2, todos.size());
	}
}