<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${ctx.contextPath}/css/item.css" />
		<link rel="stylesheet" href="${ctx.contextPath}/css/h_f.css" />
		<link rel="stylesheet" href="${ctx.contextPath}/css/index.css" />
		<script type="text/javascript" src="${ctx.contextPath}/js/item.js"></script>
		<script type="text/javascript" src="${ctx.contextPath}/js/index.js"></script>
	</head>

	<body>
		<#include "header.ftl">
		<div id="content">
			<#if user?? && user.userType="customer">
			<div id="switch-btn" onclick="hideItem()">
				<a href="#">
					只显示未购买过的
				</a>
			</div>
			</#if>
			<div id="items">
			<#if sellerItems??>
				<div id="seller-items">
				<#list sellerItems as item>
					<div class="item-box">
						<div class="item-link" onclick="openItem(${item.itemId})">
							<div class="item-box-title">
								${item.itemId}:${item.itemTitle}
							</div>
							<div class="item-box-img">
								<#if item.locationType="url">
								<img src="${item.imageLocation}" />
								<#elseif item.locationType="local">
								<img src="${ctx.contextPath}/img/${item.imageLocation}" />
								</#if>
							</div>
							<div class="item-box-price">
								价格：<span>${item.itemPrice}</span>元
							</div>
						</div>
						<div class="item-box-seller">
							<div class="item-box-tip-seller">
								已售<span>${item.count}</span>个。
							</div>
							<#if item.count = 0 >
							<div class="item-box-btn-seller">
								<a href="${ctx.contextPath}/main/deleteitem.do?itemid=${item.itemId}">删除</a>
							</div>
							</#if>
						</div>
					</div>
				</#list>
				</div>
			</#if>
			<#if bought??>
				<div id="bought">
				<#list bought as item>
					<div class="item-box">
						<div class="item-link" onclick="openItem(${item.itemId})">
							<div class="item-box-title">
								${item.itemId}:${item.itemTitle}
							</div>
							<div class="item-box-img">
								<#if item.locationType="local">
								<img src="${ctx.contextPath}/img/${item.imageLocation}" />
								<#else>
								<img src="${item.imageLocation}" />
								</#if>
							</div>
							<div class="item-box-price">
								价格：<span>${item.itemPrice}</span>元
							</div>
						</div>
						<div class="item-box-tip-buyer">
							已购买过。
						</div>
					</div>
				</#list>
				</div>
			</#if>
			<#if unbought??>
				<div id="unbought">
				<#list unbought as item>
					<div class="item-box">
						<div class="item-link" onclick="openItem(${item.itemId})">
							<div class="item-box-title">
								${item.itemId}:${item.itemTitle}
							</div>
							<div class="item-box-img">
								<#if item.locationType="local">
								<img src="${ctx.contextPath}/img/${item.imageLocation}" />
								<#else>
								<img src="${item.imageLocation}" />
								</#if>
							</div>
							<div class="item-box-price">
								价格：<span>${item.itemPrice}</span>元
							</div>
						</div>
					</div>
				</#list>
				</div>
			</#if>
			</div>
			<div>
				<p>
			</div>
		</div>
		<#include "footer.ftl">
	</body>
</html>