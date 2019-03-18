<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/account.css" />
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/h_f.css" />
	</head>

	<body>
		<#include "header.ftl">
		<div id="content">
			<div id="account-title">
				<h1>账务</h1>
			</div>
			
			<div id="account-table">
			<#if trades??>
				<#list trades as trade>
				<div class="account-item">
					<div class="account-item-img">
						<#if trade.locationType="url">
						<img src="${trade.imageLocation}" />
						<#else>
						<img src="${ctx.contextPath}/img/${trade.imageLocation}" />
						</#if>
					</div>
					<div class="account-item-info">
						<div class="account-item-title">
							物品名称:${trade.itemTitle}
							<hr />
						</div>
						<div class="account-item-price">
							购买价格：<span>${trade.price}</span>元
						</div>
						<div class="account-item-number">
							购买数量：<span>${trade.count}</span>个
						</div>
						<div class="account-item-date">
							购买日期：<span>${trade.time}</span>
						</div>
					</div>
				</div>
				</#list>
			<#else>
				<p>还没有买过任何物品。
			</#if>
			</div>
			<div id="account-total">
				总计：<span>${total}</span>元
			</div>
		</div>
		<#include "footer.ftl">
	</body>

</html>