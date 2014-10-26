<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles.css">
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
			<div id="title">户籍管理--注册</div>
			<table>
			<form action="${pageContext.request.contextPath }/servlet/Register" method="post">
				<tr>
					<td class="name">警号:</td>
					<td><input type="text" name="id" class="text" value="${rf.id }" />					</td>
					<td class="message"><span class="error">${rf.errors.id }</span><br/>六位数字</td>
				</tr>
				<tr>
					<td class="name">密码:</td>
					<td><input type="password" name="password1" class="text" value="${rf.password1 }"></td>
					<td class="message"><span class="error">${rf.errors.password1 }</span><br/>6~18位数字字母下划线</td>
				</tr>
				<tr>
					<td class="name">重复密码:</td>
					<td><input type="password" name="password2" class="text" value="${rf.password2 }" />
					<td class="message"><span class="error">${rf.errors.password2 }</span></td>
					</td>
				</tr>
				<tr>
					<td class="name">用户名:</td>
					<td><input type="text" name="userName" class="text" value="${rf.userName }" />
					<td class="message"><span class="error">${rf.errors.userName }</span><br/>登录帐号名,3~18位数字字母下划线</td>
					</td>
				</tr>
				<tr>
					<td class="name">真实姓名:</td>
					<td><input type="text" name="realName" class="text" value="${rf.realName }" />
					<td class="message"><span class="error">${rf.errors.realName }</span><br/>请填写你的真实姓名</td>
					</td>
				</tr>
				<tr>
					<td class="name">验证码:</td>
					<td><input type="text" name="checkCodeC"  class="text"/>
					<td class="message"><span class="error">${rf.errors.checkCode }</span></td>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><img src="${pageContext.request.contextPath }/servlet/CheckImage" alt="换一张"
						onclick="changeImg(this)" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><input id="button" type="submit" value="注册" />
					</td>
				</tr>
			</form>
			</table>
		</div>
		<%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
	</div>
</body>
</html>
