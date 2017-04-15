<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据</title>
    
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
    <form action="UpdateServlet" method="post">
    	<table>
    		<tr>
    			<td>货品id</td>
    			<td><input type="text" name="id" value="${c.id }" readonly="readonly"></td>
    		</tr>
    		<tr>
    			<td>货品名称</td>
    			<td><input type="text" name="name" value="${c.name}"></td>
    		</tr>
    		<tr>
    			<td>价格</td>
    			<td><input type="text" name="price" value="${c.price}"></td>
    		</tr>
    		<tr>
    			<td>单位</td>
    			<td><input type="text" name="unit" value="${c.unit}"></td>
    		</tr>
    		 <tr>
            <td colspan="2">
                <input  type="submit" value="提交"/>
                <input  type="button" value="返回" onclick="history.go(-1)"/>
            </td>
        </tr>
    	</table>
    </form>
  </body>
</html>
