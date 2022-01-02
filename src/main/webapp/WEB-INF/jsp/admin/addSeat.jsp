<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2022/1/2
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addSeat</title>
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
<form:form action="${pageContext.request.contextPath}/adminSeat/addSeat" modelAttribute="Seat" method="post">
    <table>
        <tr>
            <td>后台添加座位</td>
        </tr>
        <tr>
            <td>楼层1-5：</td>
            <td>
                <form:input path="floor"/>
                <span class="name">请输入1-5</span>
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
    ${addSeatmsg}
</form:form>


</body>
</html>
