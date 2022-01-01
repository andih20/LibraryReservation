<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/30
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateUser</title>

    <script type="text/javascript">
        function UserUpdate(uemail){
            if(window.confirm("是否更新该用户？")){
                window.location.href = "/LibraryReservation_war_exploded/adminUser/updateRealUser?uemail="+uemail;
            }
        }

        function returnAdmin(){
            if(window.confirm("是否返回主界面？")){
                window.location.href = "/LibraryReservation_war_exploded/admin/main";
            }
        }

    </script>

</head>
<body>
    <c:if test="${UpdateAllUserInfo.size() == 0 }">
        暂无用户！
    </c:if>
    <c:if test="${UpdateAllUserInfo.size() != 0 }">
        <jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
        <%--@elvariable id="User" type="pojo"--%>
        <form:form action="${pageContext.request.contextPath}/adminUser/ToupdateUser" modelAttribute="User" method="post">
            <table>
                <tr>
                    <td>请输入您想查询的用户邮箱:</td>
                    <td>
                        <form:input path="uemail"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="确定"/>
                        <input type="reset" value="重置" />
                    </td>
                </tr>
                <tr>
                    <td><input type="button" value="返回主界面" onclick="returnAdmin()"></td>
                </tr>

                <c:if test="${UpdateUserInfo.size() != 0 }">
                    <tr>
                        <td colspan="3"><h2>${UpdateuserExitmsg}</h2></td>
                    </tr>
                    <tr>
                        <th>用户名</th>
                        <th>用户密码</th>
                        <th>用户邮箱</th>
                        <th>更新</th>
                    </tr>
                    <c:forEach items="${UpdateUserInfo}" var="user">
                        <tr>
                            <td>${user.uname}</td>
                            <td>${user.upassword}</td>
                            <td>${user.uemail}</td>
                            <td><a href="javascript:UserUpdate('${user.uemail}')">更新</a></td>
                        </tr>
                    </c:forEach>



                </c:if>

                <c:if test="${UpdateUserInfo.size() == 0 }">
                    <tr>
                        <th>用户名</th>
                        <th>用户密码</th>
                        <th>用户邮箱</th>
                        <th>更新</th>
                    </tr>
                    <c:forEach items="${UpdateAllUserInfo}" var="user">
                        <tr>
                            <td>${user.uname}</td>
                            <td>${user.upassword}</td>
                            <td>${user.uemail}</td>
                            <td><a href="javascript:UserUpdate('${user.uemail}')">更新</a></td>
                        </tr>
                    </c:forEach>
                </c:if>

                <tr>
                    <td colspan="3">${updatemsg}</td>
                </tr>
            </table>
        </form:form>
    </c:if>



</body>
</html>
