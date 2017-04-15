<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.biao.bean.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		//给del函数增加形参
		 function del(id)
		{
			
			if (confirm("是否要删除这条记录？"))
			{
				window.location.href = "DeleteServlet?id=" + id;
			} 
			else 
			{
				window.location.href = "QueryServlet";
			}
		}
	</script>
</head>

<body>
	<table border="1" cellspacing="0" align="center">
		<tr>
			<td>id</td>
			<td>名称</td>
			<td>价格</td>
			<td>单位</td>
			<td>操作</td>
		</tr>
		<% int b = 1; %>
		<% List<Commodity> list = (List<Commodity>)request.getAttribute("list");%>
		<c:forEach items="${list }" var="c">
		<tr>
			<td >${c.id }</td>
			<td>${c.name}</td>
			<td>${c.price}</td>
			<td>${c.unit}</td>
			<td>
			<a href="UpdateServlet?id=${c.id }">修改 </a> 
			<!--<a href="DeleteServlet?id=${c.id }">删除</a>-->
			<input type="button" id="<%=b %>" value="删除" onclick="del(${c.id })">
			<% b++; %>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
