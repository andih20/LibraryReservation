<%@ page import="pojo.Floor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书馆预定系统</title>
    <style type="text/css">
        html{
            background-color: white;
            opacity: 0.7;
        }
    </style>
    <script  type="text/javascript" >
        function toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        //查看个人信息
        function user_info(){
            document.forms[0].action = "${pageContext.request.contextPath}/toUser_info";
            document.forms[0].submit();
        }
        //扫码签到
        function scan_code1(){
            document.forms[0].action = "${pageContext.request.contextPath}/toSign";
            document.forms[0].submit();
        }
        //离开签到
        function scan_code2(){
            document.forms[0].action = "${pageContext.request.contextPath}/toLeave";
            document.forms[0].submit();
        }
        //选择楼层
        function lay(floor_lay){
            window.location.href = "${pageContext.request.contextPath}/toMain?id="+floor_lay;
        }
        //预约座位
        function reservation(id){
            window.location.href = "${pageContext.request.contextPath}/toReservation?id="+id;
        }
    </script>
</head>
<body>
<%--@elvariable id="user" type="pojo"--%>
<jsp:useBean id="floor" class="pojo.Floor" scope="session" />
<%--<jsp:useBean id="user" class="pojo.User" scope="session" />--%>
<form:form action="${pageContext.request.contextPath}/toMain" modelAttribute="floor" method="post">

    <div align="center" style="background: darkgray;">
        <span style="float: left">
            <input type="button" onclick="toMain()" value="返回主界面">
        </span>
        <span style="">
            欢迎 -- ${user.uname}
        </span>
        <span style="float: right">
            <input type="button" onclick="user_info()" value="查看个人信息" style="margin-left: 100px">
        </span>
    </div>


    <div align="center">
        <h3>签到区</h3>
        <input type="button" value="扫码签到" onclick="scan_code1()"/>
        <input type="button" value="离开签到" onclick="scan_code2()"><br><br>
    </div>


    <div align="center">
        请选择楼层:
        <table>
            <tr>
                <td><input type="button" value="第一层" onclick="lay(1)"></td>
                <td><input type="button" value="第二层" onclick="lay(2)"></td>
                <td><input type="button" value="第三层" onclick="lay(3)"></td>
                <td><input type="button" value="第四层" onclick="lay(4)"></td>
                <td><input type="button" value="第五层" onclick="lay(5)"></td>
            </tr>
        </table><br>
        座位示意图<br>
        <table style="border: 1px black; align-content: center;">
            <tr>
                <c:forEach items="${seats}" var="seat">
                <c:if test="${seat.isempty}">
                    <c:if test="${!seat.impair}">
                        <td style="color: green">
                            <input type="button" onclick="reservation(${seat.id})" value="预约" style="color: green">
                                <%--                        <a style="color: green" href="toReservation?id=${seat.id}">预约</a>--%>
                        </td>
                    </c:if>
                </c:if>
                <c:if test="${!seat.isempty||seat.impair}">
                    <td style="color: red">
                            <%--                    <a href="toReservation?id=${seat.id}">预约</a>--%>
                        <input type="button" onclick="" value="预约" style="color: red">
                    </td>
                </c:if>
                <c:if test="${(seats.indexOf(seat)+1)%2==0}">
                    <td>&nbsp;&nbsp;&nbsp;</td>
                </c:if>
                <c:if test="${(seats.indexOf(seat)+1)%6==0}">
            </tr>
            <tr>
                </c:if>
                </c:forEach>
            </tr>
        </table>
    </div>




    <br>
    <br>
<%--    <table style="border:1px black">--%>
<%--        <tr style="background-color: blanchedalmond">--%>
<%--            <td>楼层</td>--%>
<%--            <td>座位ID</td>--%>
<%--            <td>是否为空</td>--%>
<%--            <td>座位是否损坏</td>--%>
<%--            <td>是否预约此座位</td>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${seats}" var="seat">--%>
<%--            <tr style="background-color: darkgray">--%>
<%--                <td>${floor.id}</td>--%>
<%--                <td>${seat.id}</td>--%>
<%--                <td>${seat.isempty}</td>--%>
<%--                <td>${seat.impair}</td>--%>
<%--                <td>--%>
<%--                    <c:if test="${seat.isempty}">--%>
<%--                        <c:if test="${!seat.impair}">--%>
<%--                            <a href="toReservation?id=${seat.id}">预约</a>--%>
<%--                        </c:if>--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
</form:form>

</body>
</html>
