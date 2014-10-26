<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<script type="text/javascript">
	/*更新验证图片*/
	function changeImg(img) {
		img.src = img.src + "?" + new Date().getTime();
	}
</script>
</head>
<body>
	<div>
		<%@include file="/WEB-INF/jsp/public/pagehead.jsp"%>

		<div id="login">
			<div id="title">户籍管理--登录</div>
			<table>
			<form action="${pageContext.request.contextPath }/servlet/Login" method="post">
				<tr>
					<td class="name">用户名:</td>
					<td><input type="text" name="userName" class="text" value="${lf.userName }" /></td>
					<td class="message"><span class="error">${lf.errors.userName }</span></td>
				</tr>
				<tr>
					<td class="name">密码:</td>
					<td><input type="password" name="password" class="text" value="${lf.password }" /></td>
					<td class="message"><span class="error">${lf.errors.password }</span></td>
				</tr>
				<tr>
					<td class="name">验证码:</td>
					<td><input type="text" name="checkCodeC"  class="text" /></td>
					<td class="message"><span class="error">${lf.errors.checkCodeC }</span></td>
				</tr>
				<tr>
					<td></td>
					<td><img src="${pageContext.request.contextPath }/servlet/CheckImage" alt="换一张"
						onclick="changeImg(this)" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><input id="button" type="submit" value="登录" />
					</td>
				</tr>
			</form>
			</table>
		</div>


		<%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
	</div>
</body>
</html>
