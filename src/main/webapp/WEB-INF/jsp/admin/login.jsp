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

<%--@elvariable id="AdminUser" type="pojo"--%>

<jsp:useBean id="AdminUser" class="pojo.AdminUser" scope="request" ></jsp:useBean>
<form:form action="${pageContext.request.contextPath}/admin/login" modelAttribute="AdminUser" method="post">
    <table>
        <tr>
            <td>姓名:</td>
            <td>
                <form:input path="uname"/>
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <form:input path="upassword"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="确定"/>
                <input type="reset" value="重置" />
            </td>
        </tr>

    </table>

</form:form>

${msg }

</body>
</html>
