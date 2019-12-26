package com.learning.junitmockito.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathDaoImplTest {
	private static MathDao mathDao;

	@BeforeClass
	public static void setUp() {
		mathDao = new MathDaoImpl();
	}

	@Test
	public void testAddIntInt() {
		int output = mathDao.add(2, 2);
		Assert.assertEquals(4, output);

		output = mathDao.add(2, 3);
		Assert.assertNotEquals(4, output);

	}

	@Test
	public void testAddDoubleDouble() {
		double output = mathDao.add(2.0, 2.0);
		Assert.assertEquals(4.0, output, 0);

		output = mathDao.add(2.0, 3.0);
		Assert.assertNotEquals(4.0, output);
	}
}
