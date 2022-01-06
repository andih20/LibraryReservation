<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <style type="text/css">
        html{
            background-color: white;
            opacity: 0.7;
        }
    </style>
    <script type="text/javascript">
        //确定按钮
        function login(){
            document.forms[0].submit();
        }
        //重置按钮
        function reset(){
            document.forms[0].reset();
        }
        //注册
        function toRegister(){
            document.forms[0].action="${pageContext.request.contextPath}/toRegister";
            document.forms[0].submit();
        }
    </script>
</head>
<body style="background-image:url(../image/library.jpg)">
<%--@elvariable id="user" type="pojo"--%>
<jsp:useBean id="user" class="pojo.User" scope="session" />
<%--    <div align="center">--%>
<%--        <h1>图书馆预定系统</h1>--%>
<%--    </div>--%>
    <div align="center">
        <div align="center" style="width: 250px;align-content: center;padding: 10px;border: 1px solid black;">
            <form:form action="${pageContext.request.contextPath}/login" modelAttribute="user" method="post">
                <div style="text-align: center">
                    <h3>登录界面</h3><br>
                </div>
                <div>
                    用户名:<form:input path="uname"/><br>
                    密&nbsp;&nbsp;&nbsp;码:<form:password path="upassword" maxlength="20"/><br>
                </div>
                <div style="">
                    <input type="button" value="重置" onclick="reset()"  style="margin-top: 20px">
                    <input type="button" value="提交" onclick="login()" style="margin-left: 80px"><br><br>
                </div>
                <div>
                    <a style="color: cyan; "
                       href="${pageContext.request.contextPath}/admin">管理员登录</a>
                    <a style="color: cyan;margin-left: 120px" onclick="toRegister()">注册</a>
                </div>
            </form:form>
        </div>
    </div>

</body>
</html>
