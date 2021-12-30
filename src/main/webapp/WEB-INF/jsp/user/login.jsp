<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
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
<body>
<%--@elvariable id="user" type="pojo"--%>
<jsp:useBean id="user" class="pojo.User" scope="session" />
<form:form action="${pageContext.request.contextPath}/toMain" modelAttribute="user" method="post">
    <table>
        <tr>
            <td>登录界面</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <form:input path="uname"/>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <form:password path="upassword" maxlength="20"/>
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td>邮箱：</td>--%>
<%--            <td>--%>
<%--                <form:input path="uemail" maxlength="20"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <td colspan="2">
                <input type="button" value="重置" onclick="reset()" >
                <input type="button" value="提交" onclick="login()" >
            </td>
        </tr>
    </table>
</form:form>
<a style="color: cyan" onclick="toRegister()">如果你还没有账号，请点此处注册</a>
<br>
<br>
<a style="color: cyan" style="color: cyan">如果你是管理员，请点此处</a>
</body>
</html>
