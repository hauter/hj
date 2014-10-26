<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加居民</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
  <body>
   <%@include file="/WEB-INF/jsp/public/Renavigation.jsp" %>
  <div id="back"></div>
   <div id="add">
   		<div id="title">添加派出所信息</div>
   		
   		<form action="${pageContext.request.contextPath }/servlet/AddPS" method="post">
   		<table id="info">
   			<tr><td>编号</td>
   				<td><input type="text" name="psid" value="${addpsform.psid }" ></td>
   				<td class="errors">${addpsform.errors.psid }</td>
   			</tr>
   			<tr><td>名字</td>
   				<td><input type="text" name="name" value="${addpsform.name }" ></td>
   				<td class="errors">${addpsform.errors.name }</td>
   			</tr>
   			<tr><td>地址</td>
   				<td><input type="text" name="address" value="${addpsform.address }" ></td>
   				<td class="errors">${addpsform.errors.address }</td>
   			</tr>
   			<tr><td>联系方式</td>
   				<td><input type="text" name="contact" value="${addpsform.contact }" ></td>
   				<td class="errors">${addpsform.errors.contact }</td>
   			</tr>
   		</table>
   		<input id="button" type="submit" value="添加" />
   		</form>
   
   
   </div>
   <%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
  </body>
</html>
