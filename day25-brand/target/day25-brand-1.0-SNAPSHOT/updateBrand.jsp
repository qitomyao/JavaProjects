<%@ page import="com.itheima.pojo.Brand" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改品牌</title>
</head>
<body>

<h3>修改品牌</h3>
<%
    Brand brand = (Brand) request.getAttribute("brand");
%>
<form action="updateServlet" method="post">
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input name="brandName" value="<%=brand.getBrandName()%>"><br>
    企业名称：<input name="companyName" value="<%=brand.getCompanyName()%>"><br>
    排序：<input name="ordered" value="<%=brand.getOrdered()%>"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态：
    <c:if test="${brand.status ==1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked="checked">启用<br>
    </c:if>
    <c:if test="${brand.status ==0}">
        <input type="radio" name="status" value="0" checked="checked">禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>
    <input type="submit" value="提交">
</form>

</body>
</html>
