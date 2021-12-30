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
<%--        <%Floor floor = (Floor)session.getAttribute("floor");%>--%>
        //查看个人信息
        function user_info(){

        }
        //预定座位
        function reservationSeat(){

        }
    </script>
</head>
<body>
<%--@elvariable id="user" type="pojo"--%>
<form:form action="" method="post">
    欢迎-- ${user.uname}<br>
    <input type="button" onclick="user_info()" value="查看个人信息"><br><br>
    请选择楼层:
    <table>
        <tr>
<%--            <td><a onclick="function floor(){--%>
<%--                    <%floor.setId(1);session.setAttribute("floor",floor);%>--%>
<%--                    }">第一层</a></td>--%>
<%--            <td><a onclick="function floor(){--%>
<%--                    <%floor.setId(2);session.setAttribute("floor",floor);%>--%>
<%--                    }">第二层</a></td>--%>
<%--            <td><a onclick="function floor(){--%>
<%--                    <%floor.setId(3);session.setAttribute("floor",floor);%>--%>
<%--                    }">第三层</a></td>--%>
<%--            <td><a onclick="function floor(){--%>
<%--                    <%floor.setId(4);session.setAttribute("floor",floor);%>--%>
<%--                    }">第四层</a></td>--%>
<%--            <td><a onclick="function floor(){--%>
<%--                    <%floor.setId(5);session.setAttribute("floor",floor);%>--%>
<%--                    }">第五层</a></td>--%>
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
