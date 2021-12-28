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
<form:form action="${pageContext.request.contextPath}/admin/login" modelAttribute="AdminUser" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td>

            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>

            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
