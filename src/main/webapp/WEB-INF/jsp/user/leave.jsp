<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        function leave_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/leave">
    <input type="button" onclick="leave_toMain()" value="返回主界面"/>
    <input type="submit" name="submit" value="离开签到"><br>
</form:form>
</body>
</html>
