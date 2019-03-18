<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${ctx.contextPath}/css/h_f.css" />
		<link rel="stylesheet" href="${ctx.contextPath}/css/login.css" />
		<script type="text/javascript" src="${ctx.contextPath}/js/login.js"></script>
		<script type="text/javascript" src="${ctx.contextPath}/js/md5.js"></script>
	</head>

	<body>
		<#include "header.ftl">
		<div id="login">
			<div id="login-title">
				<h1>登录</h1>
				<hr />
			</div>
			<div id="login-form">
				<#if refererPage?? >
					<form action="${ctx.contextPath}/login.do?refererPage=${refererPage}" method="post" onsubmit=checkForm()>
				<#else>
					<form action="${ctx.contextPath}/login.do" method="post" onsubmit=checkForm()>
				</#if>
					<div class="login-input"><label for="username">用户名</label><br />
						<input id="username" name="username" type="text" maxlength="20" />
						<#if error??>
						<span>${error}</span>
						</#if>		
					</div>
					<div class="login-input"><label for="password">密码</label><br />
						<input id="password" name="password" type="password" maxlength="20" /></div>
					<div id="login-submit-div">
						<button>登录</button>
					</div>
				</form>
			</div>
		</div>
		<#include "footer.ftl">
	</body>

</html>