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
  <form action="${pageContext.request.contextPath}/servlet/Search" method="post">
  	<div id="searchframe">
  	  	<a href="${pageContext.request.contextPath}/servlet/InResidentUI"><img src="${pageContext.request.contextPath}/pic/in.png" alt="添加居民"></a>
  		<a href="${pageContext.request.contextPath}/servlet/AddResidentUI"><img src="${pageContext.request.contextPath}/pic/add.png" alt="迁入居民"></a>
  		

		<div>
		<input type="text" name="word" id="text" value="${word }">
		<input type="submit" value="" id="button">
		</div>
	</div>
	<table id="resident">
		<tr>
			<th><label><input type="radio" name="key" value="name" ${name}>姓名</label></th>
			<th><label><input type="radio" name="key" value="sex" ${sex}>性别</label></th>
			<th><label><input type="radio" name="key" value="idnum"	${idnum}>身份证号</label></th>
			<th><label><input type="radio" name="key" value="nation" ${nation}>民族</label></th>
			<th><label><input type="radio" name="key" value="birthday" ${birthday}>生日</label></th>
			<th><label><input type="radio" name="key" value="contact" ${contact}>联系方式</label></th>
			<th><label><input type="radio" name="key" value="address" ${address}>家庭地址</label></th>
			<th><label><input type="radio" name="key" value="unit" ${unit}>所在单位</label></th>
			<th><label><input type="radio" name="key" value="state" ${state}>状况描述</label></th>
			<th>&nbsp;编辑&nbsp;</th>
			<th>&nbsp;办理&nbsp;</th>
		</tr>
		
		
		<c:forEach var="resident" items="${rel }">
		<c:if test="${resident.state == 0}">
		<tr>
		</c:if>
		<c:if test="${resident.state == 1}">
		<tr class="deleted">
		</c:if>
		<c:if test="${resident.state == 2}">
		<tr class="outed">
		</c:if>
			<td>${resident.name }</td>
			<td>${resident.sex }</td>
			<td>${resident.idnum }</td>
			<td>${resident.nation }</td>
			<td>${resident.birthday }</td>
			<td>${resident.contact }</td>
			<td>${resident.address }</td>
			<td>${resident.unit }</td>
			<td>
			<c:if test="${resident.state == 0}">
			正常
			</c:if>
			<c:if test="${resident.state == 1}">
			注销
			</c:if>
			<c:if test="${resident.state == 2}">
			迁出
			</c:if>
			
			</td>
			<td><a href="${pageContext.request.contextPath }/servlet/EditResidentUI?rsid=${resident.rsid }">
				<img src="${pageContext.request.contextPath }/pic/edit.png"></a></td>
			<td><a href="${pageContext.request.contextPath }/servlet/CheckinUI?rsid=${resident.rsid }">
				<img src="${pageContext.request.contextPath }/pic/checkin.png"></a></td>
		</tr>
		</c:forEach>
		
	
	
	</table>
	</form>
</div>
<%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
  </body>
</html>
