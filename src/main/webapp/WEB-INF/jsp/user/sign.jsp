<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/31
  Time: 4:20 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>扫码签到界面</title>
    <script>

    </script>
</head>
<body>
    <c:if test="${late}">
        <h3>"你已经迟到，签到无效"</h3>
    </c:if>
    <form action="${pageContext.request.contextPath}/sign" method="post">
        <input type="button" onclick="toMain()" value="返回主界面"/>
        <input type="submit" name="submit" value="签到"><br>
    </form>
</body>
</html>
