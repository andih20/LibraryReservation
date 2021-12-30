<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/30
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectUser</title>
</head>
<body>

<c:if test="${SelectAllUserInfo.size() == 0 }">
    暂无用户！
</c:if>
<c:if test="${SelectAllUserInfo.size() != 0 }">
    <jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
    <%--@elvariable id="User" type="pojo"--%>
    <form:form action="${pageContext.request.contextPath}/adminUser/ToselectUser" modelAttribute="User" method="post">
        <table>
            <tr>
                <td>请输入您想查询的用户邮箱:</td>
                <td>
                    <form:input path="uemail"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="确定"/>
                    <input type="reset" value="重置" />
                </td>
            </tr>


            <c:if test="${SelectUserInfo.size() != 0 }">
                <tr>
                    <td colspan="3"><h2>${SelectuserExitmsg}</h2></td>
                </tr>
                <tr>
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th>用户邮箱</th>
                    <th>违约次数</th>
                    <th>是否在黑名单中</th>
                </tr>
                <c:forEach items="${SelectUserInfo}" var="user">
                    <tr>
                        <td>${user.uname}</td>
                        <td>${user.upassword}</td>
                        <td>${user.uemail}</td>
                        <td>${user.number}</td>
                        <td>${user.black}</td>
                    </tr>
                </c:forEach>
            </c:if>

            <c:if test="${SelectUserInfo.size() == 0 }">
                <tr>
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th>用户邮箱</th>
                    <th>违约次数</th>
                    <th>是否在黑名单中</th>
                </tr>
                <c:forEach items="${SelectAllUserInfo}" var="user">
                    <tr>
                        <td>${user.uname}</td>
                        <td>${user.upassword}</td>
                        <td>${user.uemail}</td>
                        <td>${user.number}</td>
                        <td>${user.black}</td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </form:form>
</c:if>


</body>
</html>
