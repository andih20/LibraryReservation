<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/29
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteUser</title>
    <script type="text/javascript">
        function UserDel(uemail){
            if(window.confirm("是否删除该用户？")){
                window.location.href = "/LibraryReservation_war_exploded/adminUser/deleteUser?uemail="+uemail;
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
    <c:if test="${AllUserInfo.size() == 0 }">
        暂无用户！
    </c:if>
    <c:if test="${AllUserInfo.size() != 0 }">
        <jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
        <%--@elvariable id="User" type="pojo"--%>
        <form:form action="${pageContext.request.contextPath}/adminUser/TodeleteUser" modelAttribute="User" method="post">
            <table>
            <tr>
                <td>请输入您想查询的用户邮箱:</td>
                <td><input type="button" value="返回" onclick="returnAdmin()"></td>
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


                <c:if test="${UserInfo.size() != 0 }">
                    <tr>
                        <td colspan="3"><h2>${userExitmsg}</h2></td>
                    </tr>
                    <tr>
                        <th>用户名</th>
                        <th>用户邮箱</th>
                        <th>违约次数</th>
                        <th>删除</th>
                    </tr>
                    <c:forEach items="${UserInfo}" var="user">
                        <tr>
                            <td>${user.uname}</td>
                            <td>${user.uemail}</td>
                            <td>${user.number}</td>
                            <td><a href="javascript:UserDel('${user.uemail}')">删除</a></td>
                        </tr>
                    </c:forEach>
                </c:if>

                <c:if test="${UserInfo.size() == 0 }">
                    <tr>
                        <th>用户名</th>
                        <th>用户邮箱</th>
                        <th>违约次数</th>
                        <th>删除</th>
                    </tr>
                    <c:forEach items="${AllUserInfo}" var="user">
                        <tr>
                            <td>${user.uname}</td>
                            <td>${user.uemail}</td>
                            <td>${user.number}</td>
                            <td><a href="javascript:UserDel('${user.uemail}')">删除</a></td>
                        </tr>
                    </c:forEach>
                </c:if>

            <tr>
                <td colspan="3">${msg }</td>
            </tr>
        </table>
        </form:form>
    </c:if>


</body>
</html>
