<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/4
  Time: 2:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销用户</title>
    <style type="text/css">
        html{
            background-color: white;
            opacity: 0.7;
        }
        td{
            border:1px solid blanchedalmond;
        }
    </style>
    <script type="text/javascript">
        function deleteUser_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        function deleteUser_toUser_info(){
            document.forms[0].action="${pageContext.request.contextPath}/toUser_info";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <%--@elvariable id="user" type="pojo"--%>
    <form:form action="${pageContext.request.contextPath}/deleteUser" modelAttribute="user" method="post">
        <div align="center" style="background: darkgray;">
        <span style="float: left">
            <input type="button" onclick="deleteUser_toMain()" value="返回主界面">
        </span>
            <span style="">
            欢迎 -- ${user.uname}
        </span>
            <span style="float: right">
            <input type="button" onclick="deleteUser_toUser_info()" value="查看个人信息" style="margin-left: 100px">
        </span>
        </div><br>

        <div align="center">
            <h3>个人信息</h3>
            <div style="align-content: center;">
                <table >
                    <tr>
                        <td>ID:</td>
                        <td>${user.id}</td>
                    </tr>
                    <tr>
                        <td>姓名:</td>
                        <td>${user.uname}</td>
                    </tr>
                    <tr>
                        <td>密码:</td>
                        <td>${user.upassword}</td>
                    </tr>
                    <tr>
                        <td>邮箱:</td>
                        <td>${user.uemail}</td>
                    </tr>
                    <tr>
                        <td>漏签次数:</td>
                        <td>${user.number}</td>
                    </tr>
                    <tr>
                        <td>是否进入黑名单:</td>
                        <td>${user.black}</td>
                    </tr>
                </table>
            </div>
        </div>

        <div align="center">
<%--            <input type="button" value="返回主界面" onclick="deleteUser_toMain()"/>&nbsp;&nbsp;&nbsp;--%>
            <input type="submit" value="确定注销"/>
        </div>

    </form:form>
</body>
</html>
