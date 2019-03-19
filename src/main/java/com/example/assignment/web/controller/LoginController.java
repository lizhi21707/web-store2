package com.example.assignment.web.controller;

import com.example.assignment.meta.User;
import com.example.assignment.service.UserService;
import com.example.assignment.web.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * R2登陆 <br/>
 * R2.1用户登陆时，需要输入用户名和密码，前端密码用MD5加密后传输 <br/>
 * R2.2登陆后，所有界面上要显示用户的昵称和购物车图标（按钮）
 * 
 * @author Tank
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String showLoginPage(HttpServletRequest request, ModelMap map) {

		String refererPage = request.getHeader("Referer");
		if (refererPage != null) {
			map.put("refererPage", refererPage);
		}

		String error = request.getParameter("error");
		if (error != null) {
			map.put("error", error);
		}

		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String processLogin(	@Valid LoginForm loginForm,
								Errors errors,
								ModelMap map,
								HttpServletRequest request) {

		// 校验失败
		if (errors.hasErrors()) {
			map.put("error", "用户名或密码错误。");
			return "redirect:/login.html";
		}

		User tmpUser = userService.getUser(loginForm.getUsername());
		// 用户不存在
		if (tmpUser == null) {
			map.put("error", "用户名或密码错误。");
			return "redirect:/login.html";
		}

		// 校验密码
		if (tmpUser.getPassword().equals(loginForm.getPassword())) {
			// 校验成功，更新用户信息bean
			User user = new User();
			user.setUserId(tmpUser.getUserId());
			user.setUserName(tmpUser.getUserName());
			user.setUserType(tmpUser.getUserType());
			user.setOnline(true);

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// 重定向到主页
			return "redirect:/index.html";
		}

		// 密码错误，返回登录页面
		map.put("error", "用户名或密码错误。");
		return "redirect:/login.html";
	}

	@RequestMapping("/exit.do")
	public String exit(	HttpServletRequest request,
						HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/login.html";
	}
}
