<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/28
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="adminUser" type="pojo"--%>
<form:form action="/login" modelAttribute="adminUser" method="post">
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
                <form:password path="upassword"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
