<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/31
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectImpairSeat</title>
    <script type="text/javascript">
        function returnAdmin(){
            if(window.confirm("是否返回主界面？")){
                window.location.href = "/LibraryReservation_war_exploded/admin/main";
            }
        }
    </script>
</head>
<body>
<%--@elvariable id="Seat" type="pojo"--%>
<jsp:useBean id="Seat" class="pojo.Seat" scope="request" ></jsp:useBean>
<form:form action="${pageContext.request.contextPath}/adminSeat/selectImpairSeat" modelAttribute="Seat" method="post">
    <table>
        <tr>
            <td><input type="button" value="返回主界面" onclick="returnAdmin()"></td>
        </tr>
        <c:if test="${SelectAllImpairFloorInfo.size()==0}">
            无损坏座位！
        </c:if>

        <c:if test="${SelectAllImpairFloorInfo.size()>0}">
            <tr>
                <td><h2>${SelectImpairseatExitmsg}</h2></td>
            </tr>
            <tr>
                <th>座位号</th>
                <th>是否空闲</th>
                <th>是否损坏</th>
                <th>所在层数</th>
            </tr>
            <c:forEach items="${SelectImpairFloorInfo}" var="seat">
                <tr>
                    <td>${seat.id}</td>
                    <td>${seat.isempty}</td>
                    <td>${seat.impair}</td>
                    <td>${seat.floor}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="right">
                    &nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
                    第${pageCur}页&nbsp;&nbsp;
                    <c:url var="url_pre" value="/adminSeat/selectImpairSeat">
                        <c:param name="pageCur" value="${pageCur - 1 }"/>
                    </c:url>
                    <c:url var="url_next" value="/adminSeat/selectImpairSeat">
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
            </tr>
        </c:if>

    </table>
</form:form>

</body>
</html>
