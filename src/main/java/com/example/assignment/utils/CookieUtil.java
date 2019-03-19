package com.example.assignment.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

	public static Map<String, String> getCookieMap(HttpServletRequest request) {

		HashMap<String, String> map = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			return map;
		}
		
		String name;
		String value;
		for (Cookie cookie : cookies) {
			name = cookie.getName();
			value = cookie.getValue();
			map.put(name, value);
		}

		return map;
	}

}
