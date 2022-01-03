<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2022/1/3
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectBlackUser</title>
    <script type="text/javascript">
        function returnAdmin(){
            if(window.confirm("是否返回主界面？")){
                window.location.href = "/LibraryReservation_war_exploded/admin/main";
            }
        }
        function BlackUserDel(id){
            if(window.confirm("是否将其移除黑名单？")){
                window.location.href = "/LibraryReservation_war_exploded/adminUser/deleteBlackUser?id="+id;
            }
        }
    </script>
</head>
<body>
<c:if test="${allUser.size()==0}">
    暂无预约
</c:if>
<c:if test="${allUser.size()!=0}">
    <jsp:useBean id="User" class="pojo.User" scope="request" ></jsp:useBean>
    <%--@elvariable id="Recording" type="pojo"--%>
    <form:form action="${pageContext.request.contextPath}/adminUser/selectBlackUser" method="post">
        <table>
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
                <th>用户邮箱</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${UserList}" var="userlist">
                <tr>
                    <td>${userlist.get("uid")}</td>
                    <td>${userlist.get("uname")}</td>
                    <td>${userlist.get("uemail")}</td>
                    <td><a href="javascript:BlackUserDel('${userlist.get("uid")}')">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="right">
                    &nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
                    第${pageCur}页&nbsp;&nbsp;
                    <c:url var="url_pre" value="/adminUser/selectBlackUser">
                        <c:param name="pageCur" value="${pageCur - 1 }"/>
                    </c:url>
                    <c:url var="url_next" value="/adminUser/selectBlackUser">
                        <c:param name="pageCur" value="${pageCur + 1 }"/>
                    </c:url>
                    <!-- 第一页没有上一页 -->
                    <c:if test="${pageCur != 1 }">
                        <a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                    <!-- 最后一页，没有下一页 -->
                    <c:if test="${pageCur != totalPage && totalPage != 0}">
                        <a href="${url_next}">下一页</a>
                    </c:if>
                </td>

        </table>

    </form:form>

</c:if>


</body>
</html>
