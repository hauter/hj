<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加居民</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
	<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/selectDate.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/js.js" type="text/javascript"></script>
</head>
  <body>
   <%@include file="/WEB-INF/jsp/public/Renavigation.jsp" %>
  <div id="back"></div>
   <div id="add">
   		<div id="title">添加居民</div>
   		
   		<form action="${pageContext.request.contextPath }/servlet/AddResident" method="post">
   		<table id="info">
   			<tr>
   				<td>姓名</td>
   				<td><input type="text" name="name" value="${addform.name }"/></td>
   				<td class="errors">${addform.errors.name }</td>
   			</tr>
   			<tr><td>性别</td>
   			<td>
   				<select name="sex">
   					<c:if test='${addform.sex != null && addform.sex != ""}'>
   					<option value="${addform.sex }">${addform.sex }</option>
   					</c:if>
	   				<option value="">请选择</option>
	   				<option value="男">男</option>
	   				<option value="女">女</option>
   				</select>
   			</td>
   			<td class="errors">${addform.errors.sex }</td>
   			</tr>
   			<tr><td>身份证号</td>
   				<td><input type="text" name="idnum" value="${addform.idnum }"/></td>
   				<td class="errors">${addform.errors.idnum }</td>
   			</tr>
   			<tr><td>民族</td><td>
   				<select name="nation">
   					<c:if test='${addform.nation != null && addform.nation != ""}'>
   					<option value="${addform.nation }">${addform.nation }</option>
   					</c:if>
   					<option value="">请选择</option>
					<option value="汉族">汉族</option>
					<option value="蒙古族">蒙古族</option>
					<option value="回族">回族</option>
					<option value="藏族">藏族</option>
					<option value="维吾尔族">维吾尔族</option>
					<option value="苗族">苗族</option>
					<option value="彝族">彝族</option>
					<option value="壮族">壮族</option>
					<option value="布依族">布依族</option>
					<option value="朝鲜族">朝鲜族</option>
					<option value="满族">满族</option>
					<option value="侗族">侗族</option>
					<option value="瑶族">瑶族</option>
					<option value="白族">白族</option>
					<option value="土家族">土家族</option>
					<option value="哈尼族">哈尼族</option>
					<option value="哈萨克族">哈萨克族</option>
					<option value="傣族">傣族</option>
					<option value="黎族">黎族</option>
					<option value="傈僳族">傈僳族</option>
					<option value="佤族">佤族</option>
					<option value="畲族">畲族</option>
					<option value="高山族">高山族</option>
					<option value="拉祜族">拉祜族</option>
					<option value="水族">水族</option>
					<option value="东乡族">东乡族</option>
					<option value="纳西族">纳西族</option>
					<option value="景颇族">景颇族</option>
					<option value="柯尔克孜族">柯尔克孜族</option>
					<option value="土族">土族</option>
					<option value="达斡尔族">达斡尔族</option>
					<option value="仫佬族">仫佬族</option>
					<option value="羌族">羌族</option>
					<option value="布朗族">布朗族</option>
					<option value="撒拉族">撒拉族</option>
					<option value="毛南族">毛南族</option>
					<option value="仡佬族">仡佬族</option>
					<option value="锡伯族">锡伯族</option>
					<option value="阿昌族">阿昌族</option>
					<option value="普米族">普米族</option>
					<option value="塔吉克族">塔吉克族</option>
					<option value="怒族">怒族</option>
					<option value="乌孜别克族">乌孜别克族</option>
					<option value="俄罗斯族">俄罗斯族</option>
					<option value="鄂温克族">鄂温克族</option>
					<option value="德昂族">德昂族</option>
					<option value="保安族">保安族</option>
					<option value="裕固族">裕固族</option>
					<option value="京族">京族</option>
					<option value="塔塔尔族">塔塔尔族</option>
					<option value="独龙族">独龙族</option>
					<option value="鄂伦春族">鄂伦春族</option>
					<option value="赫哲族">赫哲族</option>
					<option value="门巴族">门巴族</option>
					<option value="珞巴族">珞巴族</option>
					<option value="基诺族">基诺族</option>
				</select>
 
   				</td>
   				<td class="errors">${addform.errors.nation }</td>
   			</tr>
   			<tr><td>生日</td><td>
   				<input id="tDate" type="text" name="birthday" value="${addform.birthday }"/></td>
   				<td class="errors">${addform.errors.birthday }</td>	
   			</tr>
   			<tr><td>联系方式</td>
   				<td><input type="text" name="contact" value="${addform.contact }"/></td>
   				<td class="errors">${addform.errors.contact }</td>	
   			</tr>
   			<tr><td>家庭地址</td>
   				<td><input type="text" name="address" value="${addform.address }"/></td>
   				<td class="errors">${addform.errors.address }</td>
   			</tr>
   			<tr><td>所在单位</td>
   				<td><input type="text" name="unit" value="${addform.unit }" /></td>
   				<td class="errors">${addform.errors.unit }</td>
   			</tr>
   			<tr><td>状态描述</td><td>
   				<input type="text" name="state" value="正常" readonly="readonly"/></td>
   				<td class="errors">${addform.errors.state }</td>
   			</tr>
   			<tr><td>隶属派出所</td><td>
   				<input type="text" name="psid" value="0001" readonly="readonly"/></td>
   				<td class="errors">${addform.errors.psid }</td>
   			</tr>
   		</table>
   			<input id="button" type="submit" value="添加" />
   		</form>
   
   
   </div>
   <%@include file="/WEB-INF/jsp/public/pagefoot.jsp"%>
  </body>
</html>
