<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书馆预定系统</title>
    <script type="text/javascript">
        //查看所有座位
        function queryAllseat(){

        }
        //预定座位
        function reservationSeat(){

        }
    </script>
</head>
<body>
<%--@elvariable id="user" type="pojo"--%>
<%--<jsp:useBean id="user" class="pojo.User" scope="request" />--%>
    欢迎-- ${user.getUname()}<br>

    <%--查看所有座位--%>
    <input type="button" value="查看所有座位" onclick="queryAllseat()"/><br>
    <%--预定座位--%>
    <input type="button" value="预定座位" onclick="reservationSeat()"/><br>

</body>
</html>
