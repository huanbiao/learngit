<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="InsertServlet" method="post">
		<table border="1" cellspacing="0" align="center">
			<tr>
				<td colspan="4">添加新的货品信息</td>
			</tr>
			<tr>
				<td>id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>unit</td>
				<td><input type="text" name="unit"></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交"> &nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="重置"></td>
			</tr>
		</table>    
    </form>
  </body>
</html>