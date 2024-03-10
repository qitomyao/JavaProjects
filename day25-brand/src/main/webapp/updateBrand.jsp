<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改品牌</title>
</head>
<body>

<h3>修改品牌</h3>
<form action="updateServlet" method="post">
    品牌名称：<input name="brandName" value=""><br>
    企业名称：<input name="companyName" value=""><br>
    排序：<input name="ordered" value=""><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
    状态：
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1">启用<br>
    <input type="submit" value="提交">
</form>

</body>
</html>
