package com.learning.junitmockito.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.learning.junitmockito.dao.MathDao;

//Case2 : Using Mock impl
public class MathServiceImplMockTest {

	@Mock
	private MathDao mathDao; // Mock Impl not Stub Impl

	@InjectMocks
	private MathServiceImpl mathService; // OR
	// private MathService mathService = new MathServiceImpl(mathDao);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAdd() {
		Mockito.when(mathDao.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(2);
		Object output = mathService.add(1, 1);
		Assert.assertEquals(2, output);

		Mockito.when(mathDao.add(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(2.0);
		output = mathService.add(1.0, 1.0);
		Assert.assertEquals(2.0, output);

		output = mathService.add(null, null);
		Assert.assertNull(output);
	}
}
