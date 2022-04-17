/* 验证用户名是否存在*/
document.getElementById("username").onblur = function () {
    //获取输入的值
    let username = document.getElementById("username").value;

    let xmlHttpRequest = new XMLHttpRequest();
    /* 访问数据库, 用户是否存在*/
    xmlHttpRequest.open("get", "/checkUserServlet?username=" + username);
    xmlHttpRequest.send();

    xmlHttpRequest.onreadystatechange = function () {
        if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
            let responseResult = xmlHttpRequest.responseText
            console.log(responseResult)
            if (responseResult === "true") {
                /* 不存在, 提示错误信息*/
                document.getElementById("username_err").innerText = "用户名已存在,请重新输入";
            } else {
                document.getElementById("username_err").innerText = "";
            }
        }
    }
}


/* 判断验证码是否正确*/
document.getElementById("changeImg").onclick = function () {
    /* 添加无用参数(时间)来实现路径改变*/
    document.getElementById("checkCodeImg").src = "../verifyCodeServlet?time=" + new Date().getTime();
}
