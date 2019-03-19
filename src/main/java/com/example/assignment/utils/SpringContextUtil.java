package com.example.assignment.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	private SpringContextUtil() {
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {

		SpringContextUtil.applicationContext = ctx;
	}

	public static ApplicationContext getApplicationContext() {

		return applicationContext;
	}

	public static Object getBean(String name) throws BeansException {

		return applicationContext.getBean(name);
	}
}
