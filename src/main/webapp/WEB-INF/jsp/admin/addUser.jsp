<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/30
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
    <script type="text/javascript">
        function returnAdmin(){
            if(window.confirm("是否返回主界面？")){
                window.location.href = "/LibraryReservation_war_exploded/admin/main";
            }
        }

    </script>
</head>
<body>
<jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
<%--@elvariable id="User" type="pojo"--%>
<form:form action="${pageContext.request.contextPath}/adminUser/addUser" modelAttribute="User" method="post">
    <table>
        <tr>
            <td>后台添加用户</td>
            <td><input type="button" value="返回" onclick="returnAdmin()"></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <form:input path="uname" id="name" onblur="nameCheck()"/>
                <span class="name">3-8位英文或数字组成</span>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <form:password path="upassword" maxlength="20"/>
                <span class="password">6-18位英文或数字组成</span>
            </td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>
                <form:input path="uemail" maxlength="20"/>
                <span class="email">请填写正确的邮箱格式</span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
    ${addUsermsg}
</form:form>


</body>
</html>
