<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2022/1/3
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectRecord</title>
    <script type="text/javascript">
        function returnAdmin(){
            if(window.confirm("是否返回主界面？")){
                window.location.href = "/LibraryReservation_war_exploded/admin/main";
            }
        }
    </script>
</head>
<body>
    <c:if test="${allRecord.size()==0}">
        暂无预约
    </c:if>
    <c:if test="${allRecord.size()!=0}">
        ${msg}
        <jsp:useBean id="Recording" class="pojo.Recording" scope="request" ></jsp:useBean>
        <%--@elvariable id="Recording" type="pojo"--%>
        <form:form action="${pageContext.request.contextPath}/adminRecord/ToselectRecord" modelAttribute="Recording" method="post">
           <table>
               <tr>
                   <th>用户ID</th>
                   <th>用户名</th>
                   <th>用户邮箱</th>
                   <th>座位ID</th>
                   <th>楼层</th>
                   <th>开始时间</th>
                   <th>结束时间</th>
                   <th>是否出席</th>
               </tr>
               <c:forEach items="${recordList}" var="recording">
                   <tr>
                       <td>${recording.get("user_id")}</td>
                       <td>${recording.get("uname")}</td>
                       <td>${recording.get("uemail")}</td>
                       <td>${recording.get("seat_id")}</td>
                       <td>${recording.get("floor")}</td>
                       <td>${recording.get("start_time")}</td>
                       <td>${recording.get("end_time")}</td>
                       <td>${recording.get("presence")}</td>
                   </tr>
               </c:forEach>
               <tr>
                   <td colspan="5" align="right">
                       &nbsp;&nbsp;&nbsp;
                       &nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
                       第${pageCur}页&nbsp;&nbsp;
                       <c:url var="url_pre" value="/adminRecord/ToselectRecord">
                           <c:param name="pageCur" value="${pageCur - 1 }"/>
                       </c:url>
                       <c:url var="url_next" value="/adminRecord/ToselectRecord">
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
