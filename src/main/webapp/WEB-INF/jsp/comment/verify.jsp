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

<form>
    <h2>滑动demo，使用ajax进行二次验证</h2>
    <br>
    <div>
        <label for="username2">用户名：</label>
        <input class="inp" id="username2" type="text" value="极验验证">
    </div>
    <br>
    <div>
        <label for="password2">密码：</label>
        <input class="inp" id="password2" type="password" value="123456">
    </div>
    <br>
    <div>
        <label>完成验证：</label>
        <div id="captcha2">
            <p id="wait2" class="show">正在加载验证码......</p>
        </div>
    </div>
    <br>
    <p id="notice2" class="hide">请先完成验证</p>
    <input class="btn" id="submit2" type="submit" value="提交">
</form>

</body>
</html>