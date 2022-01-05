<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/4
  Time: 2:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改用户信息</title>
    <script>
        function updateUser_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <%--@elvariable id="user" type="pojo"--%>
    <jsp:useBean id="user" class="pojo.User" scope="request" />
    <form:form action="${pageContext.request.contextPath}/updateUser" modelAttribute="user"  method="post">
        用户名:<form:input path="uname"/><br>
        密码:<form:input path="upassword"/><br>
        邮箱or手机号:<form:input path="uemail"/><br><br>

        <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交"/><br><br>

        <input type="button" onclick="updateUser_toMain()" value="返回主界面"/>
    </form:form>
</body>
</html>
