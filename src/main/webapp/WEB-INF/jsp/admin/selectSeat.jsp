<%@ page import="java.util.*" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/31
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectSeat</title>
    <script type="text/javascript">
        function returnAdmin(){
            if(window.confirm("是否返回主界面？")){
                window.location.href = "/LibraryReservation_war_exploded/admin/main";
            }
        }
    </script>
</head>
<body>
<%
    List<Integer> floors = new ArrayList<Integer>();
    floors.add(1);
    floors.add(2);
    floors.add(3);
    floors.add(4);
    floors.add(5);
    session.setAttribute("floors",floors);
%>
<c:if test="${SelectAllSeatInfo.size()==0}">
    暂无座位！
</c:if>
<c:if test="${SelectAllSeatInfo.size()!=0}">
    <jsp:useBean id="Seat" class="pojo.Seat" scope="request" ></jsp:useBean>
    <%--@elvariable id="Seat" type="pojo"--%>
    <form:form action="${pageContext.request.contextPath}/adminSeat/ToselectSeat" modelAttribute="Seat" method="post">
        <table>

            <c:if test="${SelectFloorInfo.size()!=0}">
                <tr>
                    <td><h2>${SelectseatExitmsg}</h2></td>
                </tr>
                <tr>
                    <th>座位号</th>
                    <th>是否空闲</th>
                    <th>是否损坏</th>
                    <th>所在层数</th>
                </tr>
                <c:forEach items="${SelectFloorInfo}" var="seat">
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
                    <c:url var="url_pre" value="/adminSeat/ToselectSeat">
                        <c:param name="pageCur" value="${pageCur - 1 }"/>
                    </c:url>
                    <c:url var="url_next" value="/adminSeat/ToselectSeat">
                        <c:param name="pageCur" value="${pageCur + 1 }"/>
                    </c:url>
                    <!-- 第一页没有上一页 -->
                    <c:if test="${pageCur != 1 }">
                        <a href="${url_pre}&&floor=${floor}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                    <!-- 最后一页，没有下一页 -->
                    <c:if test="${pageCur != totalPage && totalPage != 0}">
                        <a href="${url_next}&&floor=${floor}">下一页</a>
                    </c:if>
                </td>
            </tr>
            </c:if>

            <c:if test="${SelectFloorInfo.size()==0}">
                <tr>
                    <th>座位号</th>
                    <th>是否空闲</th>
                    <th>是否损坏</th>
                    <th>所在层数</th>
                </tr>
                <c:forEach items="${SelectAllSeatInfo}" var="seat">
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
                    <c:url var="url_pre" value="/adminSeat/selectSeatByPage">
                        <c:param name="pageCur" value="${pageCur - 1 }"/>
                    </c:url>
                    <c:url var="url_next" value="/adminSeat/selectSeatByPage">
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
            <tr>
                <td>按楼层查询所有座位:</td>
                <td>
                    <form:select path="floor">
                        <option/>请选择楼层
                        <form:options items="${floors}"/>
                    </form:select>
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

        </table>
    </form:form>

</c:if>

</body>
</html>
