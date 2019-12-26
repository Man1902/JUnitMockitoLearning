package com.learning.junitmockito.service;

import com.learning.junitmockito.dao.MathDao;

public class MathServiceImpl implements MathService {
	private MathDao mathDao;

	public MathServiceImpl(MathDao mathDao) {
		this.mathDao = mathDao;
	}

	@Override
	public Object add(Object a, Object b) {
		if (a instanceof Integer && b instanceof Integer) {
			return mathDao.add((int) a, (int) b);
		}
		if (a instanceof Double && b instanceof Double) {
			return mathDao.add((double) a, (double) b);
		}
		return null;
	}
}
