<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/4
  Time: 2:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注销</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/updateUser"  method="post">
        用户名:<form:input path="uname"/><br>
        密码:<form:input path="upassword"/><br>
        邮箱or手机号<form:input path="email"/><br><br>

        <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交"/>

    </form:form>
</body>
</html>
