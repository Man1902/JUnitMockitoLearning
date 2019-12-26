package com.learning.junitmockito.service;

import org.junit.Assert;
import org.junit.Test;

import com.learning.junitmockito.dao.MathDao;
import com.learning.junitmockito.dao.MathDaoImpl;

// Case1 : Using stub impl
public class MathServiceImplStubTest {
	@Test
	public void testAdd() {
		MathDao mathDao = new MathDaoImpl(); // Stub Impl not Mock Impl
		MathService mathService = new MathServiceImpl(mathDao);
		Object output = mathService.add(1, 1);
		Assert.assertEquals(2, output);

		output = mathService.add(1.0, 1.0);
		Assert.assertEquals(2.0, output);

		output = mathService.add(null, null);
		Assert.assertNull(output);
	}
}
