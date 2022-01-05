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
    <script type="text/javascript">
        function updateUser_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        function updateUser_toUser_info(){
            document.forms[0].action="${pageContext.request.contextPath}/toUser_info";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<div align="center">

    <%--@elvariable id="user" type="pojo"--%>
    <jsp:useBean id="user" class="pojo.User" scope="request" />
    <form:form action="${pageContext.request.contextPath}/updateUser" modelAttribute="user"  method="post">
        <div align="center" style="background: darkgray;">
        <span style="float: left">
            <input type="button" onclick="updateUser_toMain()" value="返回主界面">
        </span>
            <span style="">
            欢迎 -- ${user.uname}
        </span>
            <span style="float: right">
            <input type="button" onclick="updateUser_toUser_info()" value="查看个人信息" style="margin-left: 100px">
        </span>
        </div><br>

        <div style="align-content: center">
            <h3>更新信息</h3>
            <div>
                用户名:<form:input path="uname"/><br>
                密&nbsp;&nbsp;&nbsp;码:<form:input path="upassword"/><br>
                邮&nbsp;&nbsp;&nbsp;箱:<form:input path="uemail"/><br><br>
            </div>
        </div>


        <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交"/><br><br>

<%--        <input type="button" onclick="updateUser_toMain()" value="返回主界面"/>--%>
    </form:form>

</div>
</body>
</html>
