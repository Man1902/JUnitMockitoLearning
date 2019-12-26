package com.learning.junitmockito.handler;

import com.learning.junitmockito.dao.MathDaoImpl;
import com.learning.junitmockito.service.MathService;
import com.learning.junitmockito.service.MathServiceImpl;

public class MathHandler {
	public static void main(String[] args) {
		MathService mathService = new MathServiceImpl(new MathDaoImpl());
		System.out.println(mathService.add(1, 1));

		System.out.println(mathService.add(1.0, 2.0));

		System.out.println(mathService.add(null, null));
	}

}
