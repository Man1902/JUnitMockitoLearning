package com.learning.junitmockito.service;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Case2 : Using Mock impl
@RunWith(MockitoJUnitRunner.class)	// OR Approach2 : using initMocks
public class TodoBusinessImplMockTest {

	@Mock
	private TodoService todoService; // Approach1 : using @Mock

	@InjectMocks
	private TodoBusinessImpl todoBusinessImpl;

	@Captor	// Approach1
	private ArgumentCaptor<String> strArgumentCaptor;

	@Before
	public void setUp() {
		// todoService = Mockito.mock(TodoService.class); // Approach2 : using Mockito.mock()
		// MockitoAnnotations.initMocks(this); // OR Approach1 : using MockitoJUnitRunner
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
		// given - setup
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		BDDMockito.given(todoService.retrieveTodos("User1")).willReturn(allTodos);

		// when - actual method call
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("User1");

		// then - Asserts
		Assert.assertThat(todos.size(), CoreMatchers.is(2));
	}

	@Test
	public void testdDeleteTodosNotRelatedToSpring() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("User1")).thenReturn(allTodos);
		Mockito.doNothing().when(todoService).deleteTodo(Mockito.anyString()); 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("User1");
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
	}

	@Test
	public void captureArgument() {
		// strArgumentCaptor = ArgumentCaptor.forClass(String.class); // Approach2
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		Mockito.verify(todoService).deleteTodo(strArgumentCaptor.capture());
		assertEquals("Learn to Dance", strArgumentCaptor.getValue());
	}

}