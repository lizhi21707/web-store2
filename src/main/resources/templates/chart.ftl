<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/h_f.css" />
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/chart.css" />
		<script type="text/javascript" src="${ctx.contextPath}/js/chart.js"></script>
	</head>

	<body>
		<#include "header.ftl">
		<div id="content">
			<div id="chart-title">
				<h1>购物车</h1>
			</div>
			<div id="chart-table">
				<div class="table-title">
					购物车详单
				</div>
				<div class="table-header">
					<div class="table-header-title">
						标题
					</div>
					<div class="table-header-price">
						价格
					</div>
					<div class="table-header-number">
						数量
					</div>
				</div>
				<div class="table-body">
					<#if chartList?? >
					<#list  chartList as chartItem> 
					<div class="table-row">
						<div class="table-column-title">
							${chartItem.itemTitle}
						</div>
						<div class="table-column-price">
							${chartItem.price} 元
						</div>
						<div class="table-column-number">
							${chartItem.count}
						</div>
					</div>
					</#list>
					</#if>
				</div>
				<div id="total">
					总计：<span>${totalPrice}</span>元
				</div>
				<hr />
				<div id="button">
					<button id="confirm" onclick="buy()">购买</button>
					<button id="exit" onclick="returnPrevious()">退出</button>
				</div>
			</div>

		</div>
		<#include "footer.ftl">
	</body>

</html>