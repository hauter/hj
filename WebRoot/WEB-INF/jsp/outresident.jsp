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
   		<div id="title">迁出</div>
   		<form action="${pageContext.request.contextPath }/servlet/OutResident">
   		<input type="hidden" name="rsid" value="${editform.rsid }">
   		
   		<table id="inout">
   		<tr>
   			<td>姓名：</td>
   			<td><input type="text" value="${editform.name }" readonly="readonly"></td>
   		</tr>
   		<tr>
   			<td>原派出所编号</td>
   			<td><input type="text" name="oldPS" value="${editform.psid }" readonly="readonly"></td>
	   	</tr>
	   	<tr><td></td><td><img src="${pageContext.request.contextPath }/pic/down.png" /></td></tr>
	   	<tr>
	   		<td>目的派出所编号</td>
	   		<td><input type="text" name="nowPS" ></td>
	   		<td class="errors">${outform.errors.psid }</td>
	   	</tr>
	   	</table>
	   	<input type="submit" id="button" value="确认"/>
   		</form>
   
   </div>
   <%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
  </body>
</html>
