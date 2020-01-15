package com.logigear.trainning.common;

public class Utility {
	public static String getValidEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("myle+%s@gmail.com", s.substring(5, s.length()));
	}
}
