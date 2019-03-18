package com.netease.assignment.web.interceptor;

import com.netease.assignment.meta.User;
import com.netease.assignment.service.UserService;
import com.netease.assignment.utils.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 拦截所有路径
 * 
 * 如果用户没有登录
 * 
 * 如果用户设置了自动登录,则从自动登录中卫用户登录
 * 
 * @author Tank
 *
 */
public class GlobalInterceptor implements HandlerInterceptor {

	@Resource
	private UserService userService;

	@Override
	public boolean preHandle(	HttpServletRequest request,
								HttpServletResponse response,
								Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		// 没有登录
		if (session == null) {
			// 获取CookieMap
			Map<String, String> cookieMap = CookieUtil.getCookieMap(request);
			// 检查用户名密码
			String username = cookieMap.get("username");
			String password = cookieMap.get("password");
			// 用户名密码都存在
			if (username != null && password != null && !"".equals(username)
					&& !"".equals(password)) {
				// 判断正确性
				User user = userService.getUser(username);
				if (user != null) {
					if (user.getPassword().equals(password)) {
						// 登录成功
						session = request.getSession();
						session.setAttribute("user", user);
					}
					// 否则登录失败,session里没有用户
				}
			}
		}

		// 限制未登录情况下不允许访问的路径
		String[] loggedUrls = new String[] { "/publish.html", "/publish.do",
				"/chart.html", "/buy.do", "/account.html", "/edit/",
				"/addtochart.do", "exit.do" };
		if (session == null) {
			String url = request.getRequestURL().toString();
			for (String string : loggedUrls) {
				if (url.contains(string)) {
					response.sendRedirect(
							request.getContextPath() + "/login.html");

					return false;
				}
			}
		}

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
