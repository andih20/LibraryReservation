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
        //取消按钮
        function cancel(){
            document.forms[0].action = "";
        }
    </script>
</head>
<body>
<form:form action="" method="post">
    <table>
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
        <tr>
            <td colspan="2">
                <input type="button" onclick="login()" >
                <input type="button" onclick="cancel()" >
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
