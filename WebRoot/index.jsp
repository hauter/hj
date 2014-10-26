<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页-立警为公 执法为民</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/styles.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/card.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		card();
	});
</script>

</head>

<body>
	<%@include file="/WEB-INF/jsp/public/pagehead.jsp"%>
	<div id="context">
		<div id="show">
			<div id="carddiv">
				<div class="card"></div>
			</div>
			<div id="line"></div>
			<div id="index">
				<a href="${pageContext.request.contextPath }/servlet/LoginUI"><input
					type="button" id="loginlink" value="登录" />
				</a> <a href="${pageContext.request.contextPath }/servlet/RegisterUI"><input
					type="button" id="registerlink" value="注册">
				</a>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
</body>
</html>
