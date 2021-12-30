<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/30
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RealUpdate</title>
    <!--
    <script type="text/javascript">
        function UserUpdate(uname,upassword,uemail){
            if(window.confirm("是否更新该用户？")){
                // window.location.href = "/LibraryReservation_war_exploded/adminUser/updateUser?uemail="+uemail;
                window.location.href = "/LibraryReservation_war_exploded/adminUser/updateUser?uemail="+uemail+"&uname="+uname+"&upassword="+upassword;
            }
        }
    </script>
    -->
</head>
<body>
<%--@elvariable id="User" type="pojo"--%>
<jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
<form:form action="${pageContext.request.contextPath}/adminUser/updateUser?uemail=${Updateuemail}" modelAttribute="User" method="post">
    <table>
        <tr>
            <td>后台更新用户</td>
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
            <td colspan="2">
                <input type="submit" value="确定" />
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>
