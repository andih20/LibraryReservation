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
    <%--@elvariable id="user" type="pojo"--%>
    <jsp:useBean id="user" class="pojo.User" scope="session" />
    <form:form action="${pageContext.request.contextPath}/register" modelAttribute="user" method="post">
        <table>
            <tr>
                <td>注册界面</td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>
                    <form:input path="uname"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <form:password path="upassword" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td>
                    <form:input path="uemail" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="button" value="返回登录" onclick="conceal()">
                    <input type="button" value="重置" onclick="reset()" >
                    <input type="button" value="提交" onclick="submit()" >
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
