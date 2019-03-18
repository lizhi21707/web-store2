package com.netease.assignment.web.controller;

import com.netease.assignment.meta.ChartItem;
import com.netease.assignment.meta.Item;
import com.netease.assignment.meta.TradeItem;
import com.netease.assignment.meta.User;
import com.netease.assignment.service.ChartService;
import com.netease.assignment.service.ItemService;
import com.netease.assignment.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 
 * R3查看<br/>
 * 点击展示中的每个内容的网格，进入查看界面，可以查看内容 <br/>
 * R3.1买家对于没有购买的内容，看到的是标题、摘要文字、当前的价格、购买按钮、全文 <br/>
 * R3.2买家对于已经购买的内容，看到的是标题、摘要文字、购买时的价格、购买不可用、全文 <br/>
 * R3.3卖家看到的是标题、摘要文字、价格、全文、编辑按钮 <br/>
 * 
 * @author Tank
 *
 */
@Controller
@RequestMapping("/detail")
public class DetailController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private TradeService tradeService;

	@Autowired
	private ChartService chartService;

	@RequestMapping("/{itemId}.html")
	public String itemDetail(	@PathVariable("itemId") Integer itemId,
								ModelMap map,
								HttpServletRequest request) {

		Item item = itemService.getItem(itemId);
		// 物品不存在
		if (item == null) {

			return "redirect:/index.html";
		}

		// 保存物品信息到模型中
		map.put("item", item);

		// 未登录看到普通的页面
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			return "detail";
		}

		// 已登录
		User user = (User) session.getAttribute("user");
		if ("customer".equals(user.getUserType())) {
			// 买家
			if (item.getCount() == 0) {
				// 没买过
				map.put("status", "unbought");
			} else {
				// 买过
				map.put("status", "bought");
				TradeItem trade = tradeService.getTrade(user.getUserId(),
						item.getItemId());
				map.put("trade", trade);
			}
		}

		return "detail";
	}

	@RequestMapping("/addtochart.do")
	public String addToChart(	@RequestParam("itemid") Integer itemId,
								@RequestParam Integer count,
								HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// 校验物品是否存在
		Item item = itemService.getItem(itemId);
		if (item == null) {
			// 物品不存在，返回来源页
			return "redirect:" + request.getHeader("Referer");
		}

		// 校验是否曾经买过
		// 如果购物车里有,可以认为还没买过
		Integer userId = user.getUserId();
		Map<Integer, ChartItem> list = chartService.getChartItems(userId);
		if (list.containsKey(itemId)) {
			// 购物车里存在，就更新
			ChartItem chartItem = list.get(itemId);
			chartItem.setCount(chartItem.getCount() + count);
			chartService.updateChartItem(chartItem);

			return "redirect:/chart.html";
		}

		// 如果购物车里没有,看是否有交易记录
		TradeItem ti = tradeService.getTrade(user.getUserId(), itemId);
		if (ti == null) {
			// 购物车里不存在就增加一条
			ChartItem chartItem = new ChartItem();
			chartItem.setUserId(userId);
			chartItem.setItemId(itemId);
			chartItem.setCount(count);
			chartItem.setItemTitle(item.getItemTitle());
			chartItem.setPrice(item.getItemPrice());

			chartService.addChartItem(chartItem);
		}
		// 必须使用/chart.html,不能使用chart.html,否则被重定向到/detail/chart.html
		return "redirect:/chart.html";

	}
}
