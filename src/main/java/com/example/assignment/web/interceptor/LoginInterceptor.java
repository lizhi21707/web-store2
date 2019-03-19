package com.example.assignment.web.interceptor;

import com.example.assignment.service.UserService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截login.*
 * 
 * 如果用户已经登录则跳转到主页
 * 
 * 如果用户没有登录,则继续请求
 * 
 * 如果用户设置了自动登录,而cookie没有被设置,则设置cookie
 * 
 * @author Tank
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	private static final int DEFAULT_COOKIE_AGE = 1 * 24 * 3600;

	@Resource
	private UserService userService;

	@Override
	public boolean preHandle(	HttpServletRequest request,
								HttpServletResponse response,
								Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		// 用户已经登录
		if (session != null && session.getAttribute("user") != null) {
			response.sendRedirect(request.getContextPath() + "/index.html");
			return false;
		}

		// 用户没有登录
		return true;
	}

	@Override
	public void postHandle(	HttpServletRequest request,
							HttpServletResponse response,
							Object handler,
							ModelAndView modelAndView)
			throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response,
								Object handler,
								Exception ex)
			throws Exception {

	}
}
