<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/4
  Time: 2:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销用户</title>
    <script>
        function deleteUser_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <%--@elvariable id="user" type="pojo"--%>
    <form:form action="${pageContext.request.contextPath}/deleteUser" modelAttribute="user" method="post">
        ID:${user.id}<br>
        姓名:${user.uname}<br>
        密码:${user.upassword}<br>
        邮箱:${user.uemail}<br>
        漏签次数:${user.number}<br>
        是否进入黑名单:${user.black}<br><br>

        <input type="button" value="返回主界面" onclick="deleteUser_toMain()"/>&nbsp;&nbsp;&nbsp;
        <input type="submit" value="确定注销"/>

    </form:form>
</body>
</html>
