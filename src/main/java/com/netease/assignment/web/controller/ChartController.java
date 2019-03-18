package com.netease.assignment.web.controller;

import com.netease.assignment.meta.ChartItem;
import com.netease.assignment.meta.User;
import com.netease.assignment.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ChartController {

	@Autowired
	private ChartService chartService;

	@RequestMapping("/chart.html")
	public String getChart(HttpServletRequest request, ModelMap map) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();
		Map<Integer, ChartItem> list = chartService.getChartItems(userId);
		double total = 0.0;
		int count;
		for (ChartItem chartItem : list.values()) {
			count = chartItem.getCount();
			total += count * chartItem.getPrice();
		}

		if (list.values().size() > 0) {
			map.put("chartList", list.values());
		}

		map.put("totalPrice", total);

		return "chart";
	}

	@RequestMapping("/buy.do")
	public String buy(HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();
		chartService.buyAll(userId);

		return "redirect:/chart.html";
	}

}
