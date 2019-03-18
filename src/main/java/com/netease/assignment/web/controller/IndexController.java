package com.netease.assignment.web.controller;

import com.netease.assignment.meta.Item;
import com.netease.assignment.meta.User;
import com.netease.assignment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * R1展示（首页）<br/>
 * R1.1系统的基本界面为卖家所有内容的展示<br/>
 * R1.1.1系统的细节为内容的标题、图片和价格<br/>
 * R1.2买家登陆后，界面显示用户昵称，有退出、财务、购物车三个功能按钮<br/>
 * R1.3买家登陆后，已购买的内容上有特殊标示表明已购买<br/>
 * R1.4买家登陆后，可以只查看未购买的内容，<br/>
 * R1.5卖家登陆后，展示界面显示用户昵称，有退出，发布两个功能按钮<br/>
 * R1.6卖家登陆后，已出售的内容上有数字表明已出售的数量<br/>
 * R1.7卖家登陆后，可以在展示界面删除未出售的内容<br/>
 * 
 * @author Tank
 *
 */
@Controller
public class IndexController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = { "/index.html", "/" })
	public String index(HttpServletRequest request, ModelMap map) {

		HttpSession session = request.getSession(false);
		if (session == null) {
			// 未登录
			List<Item> list = itemService.getItems();
			if (list.size() > 0) {
				map.put("unbought", list);
			}
		} else {
			User user = (User) session.getAttribute("user");
			if ("seller".equals(user.getUserType())) {
				// 卖家
				List<Item> sellerItems =
						itemService.getSellerItems(user.getUserId());
				if (sellerItems.size() > 0) {
					map.put("sellerItems", sellerItems);
				}
			} else {
				// 买家
				Integer userid = user.getUserId();
				// 获取购买过的物品
				List<Item> boughtList = itemService.getBoughtItems(userid);
				if (boughtList.size() > 0) {
					map.put("bought", boughtList);
				}

				// 获取未购买过的物品
				List<Item> unboughtList = itemService.getUnBoughtItems(userid);
				if (unboughtList.size() > 0) {
					map.put("unbought", unboughtList);
				}
			}
		}

		return "index";
	}

	/**
	 * 卖家在主页上删除物品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	public String deleteItem(@RequestParam("itemid") Integer itemId) {

		Item item = itemService.getItem(itemId);

		// 物品已售出
		if (item.getCount() != 0) {
			// 删除失败，返回到主页
			return "redirect:/index.html";
		}

		// 更新数据库，删除物品
		itemService.deleteItem(itemId);

		// 返回到主页
		return "redirect:/index.html";

	}
}
