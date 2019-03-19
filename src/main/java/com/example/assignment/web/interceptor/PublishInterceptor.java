package com.example.assignment.web.interceptor;

import com.example.assignment.meta.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截publish.*和edit.*请求
 * 
 * 如果用户是买家,则跳转到主页
 * 
 * 如果用户没登录,则跳转到登录页面
 * 
 * @author Tank
 *
 */
public class PublishInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(	HttpServletRequest request,
								HttpServletResponse response,
								Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		// 如果是买家
		if ("customer".equals(user.getUserType())) {
			response.sendRedirect(request.getContextPath() + "/index.html");

			return false;
		}

		// 卖家,继续请求
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
