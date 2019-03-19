package com.example.assignment.web.controller;

import com.example.assignment.meta.Item;
import com.example.assignment.meta.User;
import com.example.assignment.service.ItemService;
import com.example.assignment.web.form.PublishForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class PublishController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/edit/{itemId}.html", method = RequestMethod.GET)
	public String editItem(@PathVariable Integer itemId, ModelMap map) {

		Item item = itemService.getItem(itemId);
		// 物品不存在
		if (item == null) {
			return "redirect:/index.html";
		}

		map.put("edititem", item);

		return "publish";
	}

	@RequestMapping(value = "/edit/{itemId}.do", method = RequestMethod.POST)
	public String editItem(	@RequestPart("inputFile") MultipartFile file,
							@Valid PublishForm form,
							Errors errors,
							@PathVariable("itemId") Integer itemId,
							HttpServletRequest request) {

		// 判断是否存在该物品
		Item item = itemService.getItem(itemId);
		if (item == null) {
			// 物品不存在，重定向到主页
			return "redirect:/index.html";
		}

		// 判断输入数据是否符合规定的长度
		if (errors.hasErrors()) {
			// 不符合，重定向回修改页面
			return "redirect:" + request.getHeader("Referer");
		}

		try {
			// 校验文件以及保存各个字段信息到item对象中
			if (processPublishForm(file, form, request, item)) {
				item.setItemId(itemId);
				// 更新数据库中的对象
				itemService.updateItem(item);

				return "redirect:/detail/" + itemId + ".html";
			}
		} catch (IllegalStateException | IOException e) {
			// 出现异常
			return "redirect:" + request.getHeader("Referer");
		}

		// 校验失败，重定向
		return "redirect:" + request.getHeader("Referer");
	}

	private boolean processPublishForm(	MultipartFile file,
										PublishForm form,
										HttpServletRequest request,
										Item item)
			throws IllegalStateException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		// 判断选择的是Url还是上传文件
		String radioValue = form.getImgRadio();
		// 选择上传文件
		if ("file".equals(radioValue)) {
			long size = file.getSize();
			// 有文件被选择
			if (size > 0) {
				// 文件大小超过限制
				if (size > 1048576L) {
					// 取消添加/更新
					return false;
				}
				// 为文件命名
				String fileName =
						user.getUserName() + System.currentTimeMillis();
				String fileExtension = file.getOriginalFilename()
						.substring(file.getOriginalFilename().lastIndexOf('.'));
				String filePath = request.getServletContext().getRealPath("/")
						+ "img/" + fileName + fileExtension;
				// 创建文件对象
				File saveFile = new File(filePath);
				// 保存文件到指定目录
				file.transferTo(saveFile);
				// 更新Item对象信息
				item.setImageLocation(fileName + fileExtension);
				item.setLocationType("local");
			}
		} else if ("url".equals(radioValue)
				&& form.getInputUrl().trim().length() > 0) {
			// 选择设置Url
			String url = form.getInputUrl().trim();
			if (!url.toLowerCase().startsWith("http://")) {
				url = "http://" + url;
			}
			item.setImageLocation(url);
			item.setLocationType("url");
		}

		if (item.getImageLocation() == null) {
			item.setImageLocation("item.jpg");
			item.setLocationType("local");
		}

		// 设置每个字段的信息
		item.setItemAbstract(form.getItemAbstract());
		item.setItemContent(form.getItemTotal());
		item.setItemPrice(form.getItemPrice());
		item.setItemTitle(form.getItemTitle());
		item.setSellerId(user.getUserId());

		return true;
	}

	@RequestMapping(value = "/publish.html", method = RequestMethod.GET)
	public String getPublishPage() {

		return "publish";
	}

	@RequestMapping(value = "/publish.do", method = RequestMethod.POST)
	public String publishItem(	@RequestPart("inputFile") MultipartFile file,
								@Valid PublishForm form,
								Errors errors,
								HttpServletRequest request) {

		// 判断表单中字段是否符合规定的长度
		if (errors.hasErrors()) {
			return "redirect:" + request.getHeader("Referer");
		}
		// 创建要保存的对象
		Item item = new Item();
		try {
			// 校验文件对象以及填充itme对象
			if (processPublishForm(file, form, request, item)) {
				itemService.addItem(item);
				Integer itemId = item.getItemId();

				return "redirect:/detail/" + itemId + ".html";
			}
		} catch (IllegalStateException | IOException e) {
			// 出现异常，重定向
			return "redirect:" + request.getHeader("Referer");
		}
		// 校验失败，重定向
		return "redirect:" + request.getHeader("Referer");
	}
}
