<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="search">
<div id="navigation">
<span id="user">
${police.realName} ,你好 

<a href="${pageContext.request.contextPath}/servlet/Logout">注销</a>

</span>
<span id="title">立警为公 执法为民</span>

<c:if test="${pagename == 'resident'}">
<a href="${pageContext.request.contextPath }/servlet/PoliceStationUI">派出所管理</a>
<a id='activation' href="${pageContext.request.contextPath }/servlet/ResidentUI">居民管理</a>
</c:if>
<c:if test="${pagename == 'policestation'}">
<a id="activation" href="${pageContext.request.contextPath }/servlet/PoliceStationUI">派出所管理</a>
<a href="${pageContext.request.contextPath }/servlet/ResidentUI">居民管理</a>
</c:if>
</div>
<div id="river"><div></div></div>
</div>