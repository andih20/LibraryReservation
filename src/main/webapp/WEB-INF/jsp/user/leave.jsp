<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/1
  Time: 10:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>离开签到</title>
    <script>

    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/leave" method="post">
    <input type="button" name="return" value="返回主界面" onclick="lay(1)">
    <input type="submit" name="submit" value="离开签到"><br>
</form>
</body>
</html>
