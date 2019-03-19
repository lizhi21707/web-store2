package com.example.assignment.web.controller;

import com.example.assignment.meta.TradeItem;
import com.example.assignment.meta.User;
import com.example.assignment.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {

	@Autowired
	private TradeService tradeService;

	@RequestMapping("/account.html")
	public String getAccount(HttpServletRequest request, ModelMap map) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<TradeItem> list = tradeService.getTrades(userId);

		// 没买过东西
		if (list.size() == 0) {
			map.put("total", 0.0);

			return "account";
		}

		// 计算总价
		double total = 0;
		int count;
		double price;
		for (TradeItem tradeItem : list) {
			count = tradeItem.getCount();
			price = tradeItem.getPrice();
			total += count * price;
		}

		map.put("trades", list);
		map.put("total", total);

		return "account";
	}
}
