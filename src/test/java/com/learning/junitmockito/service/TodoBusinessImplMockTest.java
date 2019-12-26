package com.learning.junitmockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

//Case2 : Using Mock impl
//@RunWith(MockitoJUnitRunner.class)	// OR Approach2 : Line 29
public class TodoBusinessImplMockTest {

	@Mock
	private TodoService todoService; // Approach1

	@InjectMocks
	private TodoBusinessImpl todoBusinessImpl;

	@Before
	public void setUp() {
		// todoService = Mockito.mock(TodoService.class); // Approach2
		MockitoAnnotations.initMocks(this); // OR Approach1 : Line 17
	}

	@Test
	public void testRetrieveTodosRelatedToSpring() {
		List<String> mockTodoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos(Mockito.anyString())).thenReturn(mockTodoList);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("User1");
		Assert.assertEquals(2, todos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDD() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		// given
		BDDMockito.given(todoService.retrieveTodos("User1")).willReturn(allTodos);

		// when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("User1");

		// then
		Assert.assertThat(todos.size(), CoreMatchers.is(2));
	}

	@Test
	public void testdDeleteTodosNotRelatedToSpring() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("User1")).thenReturn(allTodos);
		Mockito.doNothing().when(todoService).deleteTodo(Mockito.anyString()); 

		todoBusinessImpl.deleteTodosNotRelatedToSpring("User1");
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
	}

	@Test
	public void captureArgument() {
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());

		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}

}