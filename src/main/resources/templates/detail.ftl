<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${ctx.contextPath}/css/h_f.css" />
		<link rel="stylesheet" href="${ctx.contextPath}/css/detail.css" />
		<script type="text/javascript" src="${ctx.contextPath}/js/detail.js" ></script>
	</head>

	<body>
		<#include "header.ftl">
		<div id="content">
			<div id="detail-title">
				<h1>${item.itemTitle}</h1>
				<hr />
			</div>
			<div id="detail-img">
				<#if item.locationType="local">
				<img src="${ctx.contextPath}/img/${item.imageLocation}" />
				<#else>
				<img src="${item.imageLocation}" />
				</#if>
			</div>
			<div id="detail-info">
				<div id="detail-info-abstract">
					<label>摘要：</label><h2>${item.itemAbstract}</h2>
				</div>
				<#if user??>
					<#if user.userType="customer">
						<#if status="unbought">
						<div id="detail-info-price">
							价格：<span>${item.itemPrice}</span>元
						</div>
						<div id="detail-info-count">
							选择数量<button id="btn-minus" onclick="minusCount()">-</button>
							<input type="text" id="input-count" value="1" />
							<button id="btn-add" onclick="addCount()">+</button>
						</div>
						<div id="detail-info-btn">
							<div id="detail-info-btn-buyer">
								<a href="#" onclick="addToChart(${item.itemId})">添加到购物车</a>
							</div>
						</div>
						<#else>
						<div id="detail-info-price">
							价格：<span>${trade.price}</span>元
						</div>
						<div id="detail-info-btn">
							<div id="detail-info-btn-buyer">
								购买不可用
							</div>
						</div>
						</#if>
					<#else>
						<div id="detail-info-price">
							价格：<span>${item.itemPrice}</span>元
						</div>
						<div id="detail-info-btn">
							<div id="detail-info-btn-seller">
								<a href="${ctx.contextPath}/edit/${item.itemId}.html">编辑</a>
							</div>
						</div>
					</#if>
				<#else>
					<div id="detail-info-price">
						价格：<span>${item.itemPrice}</span>元
					</div>
					<div id="detail-info-btn">
						<div id="detail-info-btn-buyer">
							<a href="#" onclick="addToChart(${item.itemId})">添加到购物车</a>
						</div>
					</div>
				</#if>
			</div>
			<div id="detail-total">
				<hr />
				<p>全文描述</p><br/>
				${item.itemContent}
			</div>
		</div>
		<#include "footer.ftl">
	</body>
</html>