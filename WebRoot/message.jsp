<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>网站消息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles.css">
  </head>
  
  <body>
  	<div>
  	<%@include file="/WEB-INF/jsp/public/pagehead.jsp" %>
  		<div id = "message">
  		<br>
			<c:if test="${goodMessage != null}">
				<img src="${pageContext.request.contextPath }/pic/good.png">
				<p id="goodmessage">${goodMessage }</p>
			</c:if>
			<c:if test="${badMessage != null }">
				<img src="${pageContext.request.contextPath }/pic/bad.png">
				<p id="badMessage">${badMessage }</p>
			</c:if>
			<a href="${pageContext.request.contextPath }/servlet/ResidentUI">转到首页</a>
  		<div id="forie8"></div>
  		</div>
  		
  		
  	<%@include file="/WEB-INF/jsp/public/pagefoot.jsp" %>
  	</div>
  </body>
</html>
