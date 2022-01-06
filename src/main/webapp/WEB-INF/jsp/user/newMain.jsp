<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2022/1/6
  Time: 5:08 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书馆预定系统</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <style>
        body{
            background-image: url("<%=basePath%>/image/library.jpg");
            /*background-image: url("/image/library.jpg");*/
            background-repeat: no-repeat;
            background-size:100% 100%;
            background-attachment: fixed;"
        }
    </style>
</head>
<body>

    <div style="text-align: center">
        <h1>图书馆预定系统</h1><br>
    </div>

    <div align="center">
        <iframe src="${pageContext.request.contextPath}/toLogin" height="500px" width="800px" name="content">
        </iframe>
    </div>

</body>
</html>
