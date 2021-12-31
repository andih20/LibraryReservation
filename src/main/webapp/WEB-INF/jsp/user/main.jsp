<%@ page import="pojo.Floor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书馆预定系统</title>
    <script type="text/javascript">
        //查看个人信息
        function user_info(){
            document.forms[0].action = "${pageContext.request.contextPath}/toUser_info";
            document.forms[0].submit();
        }
        //预定座位
        function reservationSeat(){

        }
        function lay(floor){
            switch (floor){
                case 1:{<% session.setAttribute("lay",1);%>break;}
                case 2:{<% session.setAttribute("lay",2);%>break;}
                case 3:{<% session.setAttribute("lay",3);%>break;}
                case 4:{<% session.setAttribute("lay",4);%>break;}
                case 5:{<% session.setAttribute("lay",5);%>break;}
                default :<%session.setAttribute("lay",1);%>
            }
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<%--@elvariable id="user" type="pojo"--%>
<jsp:useBean id="floor" class="pojo.Floor" scope="session" />
<form:form action="${pageContext.request.contextPath}/toMain" method="post">
    欢迎-- ${user.uname}<br>
    <input type="button" onclick="user_info()" value="查看个人信息"><br><br>
    请选择楼层:
    <table>
        <tr>
            <td><input type="button" value="第一层" onclick="lay(1)"></td>
            <td><input type="button" value="第二层" onclick="lay(2)"></td>
            <td><input type="button" value="第三层" onclick="lay(3)"></td>
            <td><input type="button" value="第四层" onclick="lay(4)"></td>
            <td><input type="button" value="第五层" onclick="lay(5)"></td>
        </tr>
    </table>
    <table style="border: 1px;color: black">
        <tr>
            <td>楼层</td>
            <td>座位ID</td>
            <td>是否为空</td>
            <td>座位是否损坏</td>
            <td>是否预约此座位</td>
        </tr>
        <c:forEach items="${seats}" var="seat">
            <tr >
                <td>${floor.id}</td>
                <td>${seat.id}</td>
                <td>${seat.isempty}</td>
                <td>${seat.impair}</td>
                <td>
                    <c:if test="${seat.isempty}">
                        <input type="button" onclick="reservationSeat()" value="预约">
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

</form:form>

</body>
</html>
