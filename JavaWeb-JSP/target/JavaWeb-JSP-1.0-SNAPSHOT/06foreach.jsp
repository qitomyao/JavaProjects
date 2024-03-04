<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL的foreach标签</title>
</head>
<body>

<input type="button" value="新增"><br>
<hr>

<table border="1" cellspacing="0" width="70%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

     <tr align="center">
         <td>1</td>
         <td>小米</td>
         <td>小米科技有限公司</td>
         <td>1000</td>
         <td>为发烧而生</td>
         <td>启用</td>
         <td><a href="#">修改</a> <a href="#">删除</a></td>
     </tr>
</table>

<hr/>

<%--类似于普通for循环--%>

</body>
</html>
