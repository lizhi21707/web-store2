package com.netease.assignment.web.interceptor;

import com.netease.assignment.meta.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截account.html
 * 
 * 如果用户没有登录,则跳转到登录页面
 * 
 * 如果用户是卖家,则跳转到主页
 * 
 * @author Tank
 *
 */
public class AccountInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(	HttpServletRequest request,
								HttpServletResponse response,
								Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 如果是卖家
		if ("seller".equals(user.getUserType())) {
			response.sendRedirect(request.getContextPath() + "/index.html");

			return false;
		}

		// 买家,继续请求
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
