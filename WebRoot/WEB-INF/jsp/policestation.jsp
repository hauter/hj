<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>户籍管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

  </head>
  <body  id="rebody">
  <%@include file="/WEB-INF/jsp/public/Renavigation.jsp" %>
  <div id="residentpage">
  <form action="${pageContext.request.contextPath}/servlet/PSSearch" method="post">
  	<div id="searchframe">
  	  	<a href="${pageContext.request.contextPath}/servlet/AddPSUI">
  	  		<img src="${pageContext.request.contextPath}/pic/add.png" alt="添加派出所">
  	  	</a>
		<div>
		<input type="text" name="word" id="text" value="${word }">
		<input type="submit" value="" id="button">
		</div>
	</div>
	<table id="resident">
		<tr>
			<th><label><input type="radio" name="key" value="psid" ${psdi}>编号</label></th>
			<th><label><input type="radio" name="key" value="name" ${name}>名字</label></th>
			<th><label><input type="radio" name="key" value="address" ${address}>地址</label></th>
			<th><label><input type="radio" name="key" value="contact" ${contact}>联系方式</label></th>
			<th><label>操作</label></th>
		</tr>
		<c:forEach var="ps" items="${pslist}">
		<tr>
			<td>${ps.psid}</td>
			<td>${ps.name}</td>
			<td>${ps.address}</td>
			<td>${ps.contact}</td>
			<td><a href="${pageContext.request.contextPath }/servlet/EditPSUI?psid=${ps.psid }">
				<img src="${pageContext.request.contextPath }/pic/edit.png"></a></td>
		</tr>
		
		</c:forEach>
	
	
	</table>
	</form>
</div>
<%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
  </body>
</html>
