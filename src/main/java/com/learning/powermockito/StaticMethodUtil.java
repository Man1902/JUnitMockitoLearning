package com.learning.powermockito;

public class StaticMethodUtil {
	public static void voidStatic() throws Exception {
		System.out.println("voidStatic");
	}

	public static void voidStaticWithArgs(String msg) throws Exception {
		System.out.println("voidStaticWithArgs : " + msg);
	}

	public static String staticMethod() throws Exception {
		return "staticMethod";
	}

	public static String staticWithArg(String msg) throws Exception {
		return "staticWithArg. msg : " + msg;
	}

}
