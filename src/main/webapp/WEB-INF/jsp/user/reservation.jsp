<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/30
  Time: 11:19 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预定界面</title>
    <style type="text/css">
        html{
            background-color: white;
            opacity: 0.7;
        }
    </style>
    <script type="text/javascript">
        function reservation_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        function reservation_toUser_info(){
            document.forms[0].action="${pageContext.request.contextPath}/toUser_info";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <%--@elvariable id="recording" type="pojo"--%>
    <jsp:useBean id="recording" class="pojo.Recording" scope="session" />
    <form:form action="${pageContext.request.contextPath}/reservation" modelAttribute="recording" method="post">
<%--        <jsp:useBean id="user" scope="request" type="pojo.User"/>--%>

        <%
            String id = (String)request.getAttribute("id");
            request.setAttribute("id",id);
            Boolean black = (Boolean)session.getAttribute("black");
            request.setAttribute("black",black);
        %>

        <div align="center" style="background: darkgray;">
        <span style="float: left">
            <input type="button" onclick="reservation_toMain()" value="返回主界面">
        </span>
            <span style="">
            欢迎 -- ${user.uname}
        </span>
            <span style="float: right">
            <input type="button" onclick="reservation_toUser_info()" value="查看个人信息" style="margin-left: 100px">
        </span>
        </div><br>

        <div align="center">
            <c:if test="${black}">
                您已被加入黑名单，不能进行预约操作
            </c:if>

            <span>图书馆开放时间(8:00--22:00)</span><br>
            <span>每次预约不得超过四个小时</span>
        </div>
        <br><br>
        <div align="center">
            开始时间:<form:input path="start_time"/>(HH:MM)<br>
            结束时间:<form:input path="end_time"/>(HH:MM)<br><br>
            <input type="reset" id="reset" value="重置"/>
            <input type="submit" id="submit" value="提交"/>
        </div>


    </form:form>
</body>
</html>
