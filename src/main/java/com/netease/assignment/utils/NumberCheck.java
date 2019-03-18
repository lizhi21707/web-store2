package com.netease.assignment.utils;

import java.util.regex.Pattern;

public class NumberCheck {

	public static boolean isNumber(String target) {

		return Pattern.matches("^[0-9]*$", target);
	}
}
