<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/30
  Time: 11:20 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息界面</title>
</head>
<body>
    <%--@elvariable id="user" type="pojo"--%>
    <form:form action="${pageContext.request.contextPath}/toMain" modelAttribute="user" method="post" enctype="multipart/form-data">
        ID:${user.id}<br>
        姓名:${user.uname}<br>
        密码:${user.upassword}<br>
        邮箱:${user.uemail}<br>
        漏签次数:${user.number}<br>
        是否进入黑名单:${user.black}<br>
        <c:if test="${user.black}">
            申述<input type="file" name="Appeal" value="上传文件">
        </c:if>

        <br>
        <input type="submit" value="返回主界面"/>
    </form:form>
</body>
</html>
