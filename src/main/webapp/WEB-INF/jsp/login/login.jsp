<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <!-- 注意，验证码本身是不需要 jquery 库，此处使用 jquery 仅为了在 demo 使用，减少代码量 -->
    <script src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.js"></script>
    <!-- 引入 gt.js，既可以使用其中提供的 initGeetest 初始化函数 -->
    <script src="${ctx}/assets/geetest/js/gt.js"></script>
    <%--引入geetestcss--%>
    <link rel="stylesheet" href="${ctx}/assets/geetest/css.css">
    <script src="${ctx}/commom//login/login.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>gt-node-sdk-demo</title>
</head>
<body>
<h1>评论登陆</h1>
<hr>
<form action="${ctx}/login" method="post">

    <br>
    <div>
        <label for="username1">用户名：</label>
        <input class="inp" id="username1" type="text" value="admin">
    </div>
    <br>
    <div>
        <label for="password1">密码：</label>
        <input class="inp" id="password1" type="password" value="123456">
    </div>
    <br>
    <div>
        <label>完成验证：</label>
        <div id="captcha1">
            <p id="wait1" class="show">正在加载验证码......</p>
        </div>
    </div>
    <br>
    <p id="notice1" class="hide">请先完成验证</p>
    <input class="btn" id="submit1" type="submit" value="提交">
</form>

</body>
</html>