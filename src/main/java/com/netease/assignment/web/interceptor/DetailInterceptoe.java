package com.netease.assignment.web.interceptor;

import com.netease.assignment.meta.User;
import com.netease.assignment.utils.NumberCheck;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 若访问的路径不是物品的Id,则跳转到主页
 * 
 * @author Tank
 *
 */
public class DetailInterceptoe implements HandlerInterceptor {

	@Override
	public boolean preHandle(	HttpServletRequest request,
								HttpServletResponse response,
								Object handler)
			throws Exception {

		String uri = request.getRequestURI();
		// 物品详情的GET请求
		if (request.getMethod().toUpperCase().equals("GET")) {
			// 添加购物车的物品id必须是数字，且数量必须是数字
			if (uri.contains("addtochart.do")) {
				// 校验添加时是数量
				String itemId = request.getParameter("itemid");
				if (itemId == null || !NumberCheck.isNumber(itemId)) {
					// 如果不是数字,则跳转到主页
					response.sendRedirect(
							request.getContextPath() + "/index.html");
					return false;
				}
				String count = request.getParameter("count");
				if (count == null || !NumberCheck.isNumber(count)) {
					// 如果不是数字,则跳转到主页
					response.sendRedirect(
							request.getContextPath() + "/index.html");
					return false;
				}
			} else if (uri.contains("edititem.html")) {
				// 编辑物品必须是卖家
				HttpSession session = request.getSession(false);
				// 全局过滤器已经验证过session不为null
				User user = (User) session.getAttribute("user");
				if ("customer".equals(user.getUserType())) {
					// 如果是买家，重定向到主页上
					response.sendRedirect(
							request.getContextPath() + "/index.html");
				}
			} else {
				// 获取物品详情中物品id必须是数字
				String itemId = uri.substring(uri.lastIndexOf("/") + 1,
						uri.lastIndexOf(".html"));
				// 判断是否是数字
				boolean isNumber = NumberCheck.isNumber(itemId);
				if (!isNumber) {
					// 如果不是数字,则跳转到主页
					response.sendRedirect(
							request.getContextPath() + "/index.html");
					return false;
				}
				// 是数字
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
