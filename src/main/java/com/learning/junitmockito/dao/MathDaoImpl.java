package com.learning.junitmockito.dao;

public class MathDaoImpl implements MathDao {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public double add(double a, double b) {
		return a + b;
	}
}
