<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>身份证办理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

</head>
  <body>
   <%@include file="/WEB-INF/jsp/public/Renavigation.jsp" %>
  <div id="back"></div>
   <div id="add">
   		<div id="title">身份证办理</div>
   		
   		<form action="${pageContext.request.contextPath }/servlet/Checkin" method="post">
   		<input type="hidden" name="rsid" value="${resident.rsid }" >
   		<table id="info">
   			<tr><td>姓名</td><td><input type="text" name="name" value="${resident.name }" readonly="readonly"></td></tr>
   			<tr><td>性别</td><td><input type="text" name="sex" value="${resident.sex }" readonly="readonly"></td></tr>
   			<tr><td>身份证号</td><td><input type="text" name="idnum" value="${resident.idnum }" readonly="readonly"></td></tr>
   			<tr><td>民族</td><td><input type="text" name="nation" value="${resident.nation }" readonly="readonly"></td></tr>
   			<tr><td>生日</td><td><input type="text" name="birthday" value="${resident.birthday }" readonly="readonly"></td></tr>
   			<tr><td>家庭住址</td><td><input type="text" name="address" value="${resident.address }" readonly="readonly"></td></tr>
   		</table>
   		
   		<c:if test="${checkin == 'unchecked'}">
   			<input id="button" type="submit" value="办理" />
   		</c:if>
 		<c:if test="${checkin == 'checking'}">
   			<input id="button" type="button" value="办理中...">
   		</c:if>
   		</form>
   
   
   </div>
   <%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
  </body>
</html>
