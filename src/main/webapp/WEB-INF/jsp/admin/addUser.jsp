<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/30
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>
<jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
<%--@elvariable id="User" type="pojo"--%>
<form:form action="${pageContext.request.contextPath}/adminUser/addUser" modelAttribute="User" method="post">
    <table>
        <tr>
            <td>后台添加用户</td>
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
        <tr>
            <td>邮箱：</td>
            <td>
                <form:input path="uemail" maxlength="20"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>

</form:form>


</body>
</html>
