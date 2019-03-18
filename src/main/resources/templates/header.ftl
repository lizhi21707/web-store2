<div id="header">
	<div id="header-inner">
		<div id="header-left">
			<a href="${ctx.contextPath}/index.html">首页</a>
		</div>
		<div id="header-right">
			<ul>
				<#if !user??>
				<li>
					<a href="${ctx.contextPath}/login.html">登录</a>
				</li>
				<#else>						
				<li>
					<label>你好，${user.userName}</label>
				</li>
				</#if>
				<#if user?? && user.userType="customer">
				<li>
					<a href="${ctx.contextPath}/chart.html">购物车</a>
				</li>
				<li>
					<a href="${ctx.contextPath}/account.html">财务</a>
				</li>
				<#elseif user?? && user.userType="seller">
				<li>
					<a href="${ctx.contextPath}/publish.html">发布</a>
				</li>
				</#if>
				<#if user??>
				<li>
					<a href="${ctx.contextPath}/exit.do">[退出]</a>
				</li>
				</#if>
			</ul>
		</div>
	</div>
</div>
