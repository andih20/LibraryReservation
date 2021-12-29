<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

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
