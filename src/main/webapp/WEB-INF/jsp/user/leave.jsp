<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/1
  Time: 10:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>离开签到</title>
    <style type="text/css">
        html{
            background-color: white;
            opacity: 0.7;
        }
    </style>
    <script type="text/javascript">
        function leave_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        function leave_toUser_info(){
            document.forms[0].action="${pageContext.request.contextPath}/toUser_info";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <div align="center" style="background: darkgray;">
            <span style="float: left">
                <input type="button" onclick="reservation_toMain()" value="返回主界面">
            </span>
        <span style="">
                欢迎 -- ${user.uname}
            </span>
        <span style="float: right">
                <input type="button" onclick="leave_toUser_info()" value="查看个人信息" style="margin-left: 100px">
            </span>
    </div><br>

    <div align="center">
        <form:form method="post" action="${pageContext.request.contextPath}/leave">
            <input type="submit" name="submit" value="离开签到"><br><br>
            <input type="button" onclick="leave_toMain()" value="返回主界面"/>
        </form:form>
    </div>

</body>

</html>
