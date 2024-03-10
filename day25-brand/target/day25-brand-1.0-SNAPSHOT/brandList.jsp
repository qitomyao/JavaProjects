<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.itheima.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有品牌</title>
</head>
<body>

<input type="button" value="新增" onclick="location.href='addBrand.jsp'"><br>
<hr>

<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

    <c:forEach items = "${brands}" var="brand" varStatus="sta">
        <tr align="center">
            <td>${sta.count}</td> <%-- 从1开始 --%>
            <%-- <td>${brand.id}</td> --%>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status == 0}">
                <td>禁用</td>
            </c:if>
            <td><a href="selectByIdServlet?id=${brand.id}">修改</a> <a href="deleteByIdServlet?id=${brand.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

