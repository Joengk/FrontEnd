<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="../css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <%-- 登录跳转地址--%>
    <form action="../loginServlet" method="post" id="form">
        <h1 id="loginMsg">登 录</h1>
        <%-- 使用 cookie 内置对象 --%>
        <p>用户名:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
        <p>密码:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <%-- 复选框选中的时候为 value 的值, 没选中就为 null--%>
        <p>记住我: <input name="remember" value="1" type="checkbox" ${cookie.username.value!= null?'checked="checked"':""}
        </p>

        <div id="errorMsg">${errorMsg}</div>

        <div id="subDiv">
            <input type="submit" class="button" value="登 录">
            <input type="reset" class="button" value="重 置">
            <br>
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>
</body>
</html>