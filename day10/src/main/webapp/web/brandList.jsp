<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>所有品牌</title>
</head>
<body>

<h1>欢迎 ${username} 使用商品管理系统</h1>

<input type="button" value="新增" onclick=location.href='/web/addBrand.jsp'><br>
<hr>


<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>状态</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${brandList}" var="brand">
        <tr align="center">
            <td>${brand.id}</td>
            <td>
                <input type="checkbox" id="brand${brand.id}"  ${brand.status ==1? "checked='checked'":''}
                       onclick="return false"/>
            </td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td><a href="/SelectByIDServlet?id=${brand.id}">修改</a> <a href="/DeletedBrandServlet?id=${brand.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
