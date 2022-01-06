<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/28
  Time: 4:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">
        html{
            background-color: white;
            opacity: 0.7;
        }
    </style>
    <script type="text/javascript">
        function conceal(){
            document.forms[0].action = "${pageContext.request.contextPath}/toLogin";
            document.forms[0].submit();
        }
        //重置按钮
        function reset(){
            document.forms[0].reset();
        }
        function submit(){
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<div align="center">
    <h1>图书馆预定系统</h1>
</div>
<div align="center">
    <%--@elvariable id="user" type="pojo"--%>
    <jsp:useBean id="user" class="pojo.User" scope="session" />
    <form:form action="${pageContext.request.contextPath}/register" modelAttribute="user" method="post">
        <div style="border: 1px solid black;width: 300px;height: 200px">
            <div>
                <div><h3>注册界面</h3></div>
            </div>
            <div>
                姓名:&nbsp;&nbsp;<form:input path="uname"/>(8-16)位<br>
                密码:&nbsp;&nbsp;<form:password path="upassword" maxlength="20"/>(8-16)位<br>
                邮箱:&nbsp;&nbsp;<form:input path="uemail" maxlength="20"/>(QQ邮箱)<br>
            </div>
            <div style="margin-top: 20px">
                <input type="button" value="返回登录" onclick="conceal()">
                <input type="button" value="重置" onclick="reset()" >
                <input type="button" value="提交" onclick="submit()" >
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
