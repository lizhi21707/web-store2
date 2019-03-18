<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/h_f.css" />
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/publish.css" />
		<script type="text/javascript" src="${ctx.contextPath}/js/publish.js"></script>
	</head>

	<body>
		<#include "header.ftl">
		<div id="content">
			<div id="publish-title">
			<#if edititem??>
				<h1>编辑商品</h1>
			<#else>
				<h1>发布商品</h1>
			</#if>
			</div>
			<div id="publish-box">
			<#if edititem??>
				<form action="${ctx.contextPath}/edit/${edititem.itemId}.do" 
					enctype="multipart/form-data" id="uploadform" onsubmit="checkForm()" method="post">
					<div id="item-id" class="aline">
						<div class="title-block">
							<label class="title-label">ID:</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemId" id="item-id-input" value="${edititem.itemId}" />
						</div>
					</div>
					<div id="item-title" class="aline">
						<div class="title-block">
							<label class="title-label">标题：</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemTitle" id="item-title-input" value="${edititem.itemTitle}" />
							<label class="label-hint" id="title-hint">标题长度必须在2-80字符之间</label>
						</div>
					</div>
					<div id="item-abstract" class="aline">
						<div class="title-block">
							<label class="title-label">摘要：</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemAbstract" id="item-abstract-input" value="${edititem.itemAbstract}" />
							<label class="label-hint" id="abstract-hint">摘要长度必须在[ 2 - 140 ]字符之间</label>
						</div>
					</div>
					<div id="item-price" class="aline">
						<div class="title-block">
							<label class="title-label">价格：</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemPrice" id="item-price-input" value="${edititem.itemPrice}" />
							<label class="label-hint" id="price-hint">必须是数字</label>
						</div>
					</div>
					<div id="item-total" class="aline">
						<div class="title-block">
							<label class="title-label">正文：</label></div>
						<div class="input-block">
							<textarea type="text" rows="6" name="itemTotal" id="item-total-input">${edititem.itemContent}</textarea>
							<label class="label-hint" id="total-hint">正文长度必须在[ 2 - 1000 ]字符之间</label>
						</div>
					</div>
					<div id="item-img" class="aline">
						<div class="title-block"><label class="title-label">图片：</label></div>
						<div class="input-block" id="img-input-block">
							<div id="radio-choose">
								<laebel>
									<input type="radio" checked="checked" name="imgRadio" id="item-img-input" value="file" onclick="to_change()" />文件
								</laebel>
								<label>
									<input type="radio" name="imgRadio" id="item-img-input" value="url" onclick="to_change()"/>网络地址
									</laebel>
							</div>
							<div id="img-block">
								<div id="file-block">
									<input type="file" name="inputFile" id="input-file" accept="image/jpeg"/>
									<label class="label-hint" id="file-hint">图片大小限制在 1 MB以内</label>
								</div>
								<div id="url-block">
									<label>输入地址</label>
									<input type="text" name="inputUrl" id="input-url" />
								</div>
							</div>
						</div>
					</div>
					<div id="item-btn" class="aline">
						<input id="modify" type="submit" value="提交编辑" />
					</div>
				</form>
				<#else>
				<form action="${ctx.contextPath}/publish.do" 
					enctype="multipart/form-data" id="uploadform" onsubmit="checkForm()" method="post">
					<div id="item-title" class="aline">
						<div class="title-block">
							<label class="title-label">标题：</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemTitle" id="item-title-input" value="" />
							<label class="label-hint" id="title-hint">标题长度必须在2-80字符之间</label>
						</div>
					</div>
					<div id="item-abstract" class="aline">
						<div class="title-block">
							<label class="title-label">摘要：</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemAbstract" id="item-abstract-input" value="" />
							<label class="label-hint" id="abstract-hint">摘要长度必须在[ 2 - 140 ]字符之间</label>
						</div>
					</div>
					<div id="item-price" class="aline">
						<div class="title-block">
							<label class="title-label">价格：</label>
						</div>
						<div class="input-block">
							<input type="text" name="itemPrice" id="item-price-input" value="" />
							<label class="label-hint" id="price-hint">必须是数字</label>
						</div>
					</div>
					<div id="item-total" class="aline">
						<div class="title-block">
							<label class="title-label">正文：</label></div>
						<div class="input-block">
							<textarea type="text" rows="6" name="itemTotal" id="item-total-input"></textarea>
							<label class="label-hint" id="total-hint">正文长度必须在[ 2 - 1000 ]字符之间</label>
						</div>
					</div>
					<div id="item-img" class="aline">
						<div class="title-block"><label class="title-label">图片：</label></div>
						<div class="input-block" id="img-input-block">
							<div id="radio-choose">
								<laebel>
									<input type="radio" checked="checked" name="imgRadio" id="item-img-input" value="file" onclick="to_change()" />文件
								</laebel>
								<label>
									<input type="radio" name="imgRadio" id="item-img-input" value="url" onclick="to_change()"/>网络地址
									</laebel>
							</div>
							<div id="img-block">
								<div id="file-block">
									<input type="file" name="inputFile" id="input-file" accept="image/jpeg"/>
									<label class="label-hint" id="file-hint">图片大小限制在 1 MB以内</label>
								</div>
								<div id="url-block">
									<label>输入地址</label>
									<input type="text" name="inputUrl" id="input-url" />
								</div>
							</div>
						</div>
					</div>
					<div id="item-btn" class="aline">
						<input id="publish" type="submit" value="提交发布" />
					</div>
				</form>
				</#if>
			</div>
		</div>
		<#include "footer.ftl">
	</body>
</html>