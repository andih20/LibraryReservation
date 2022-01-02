<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2022/1/2
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateRealSeat</title>
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
<form:form action="${pageContext.request.contextPath}/adminSeat/updateSeat?id=${SeatId}" modelAttribute="Seat" method="post">
    <table>
        <tr>
            <td>后台更新座位信息</td>
        </tr>
        <tr>
            <td>第${SeatId}号座位是否损坏：</td>
            <td>
                <form:radiobutton path="impair" value="true"/>损坏
                <form:radiobutton path="impair" value="false"/>未损坏
            </td>
        </tr>
        <tr>
            <td>第${SeatId}号座位是否空闲：</td>
            <td>
                <form:radiobutton path="isempty" value="true"/>空闲
                <form:radiobutton path="isempty" value="false"/>正在使用
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

</body>
</html>
