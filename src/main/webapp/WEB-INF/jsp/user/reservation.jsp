<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
    <%--@elvariable id="recording" type="pojo"--%>
    <jsp:useBean id="recording" class="pojo.Recording" scope="session" />
    <form:form action="${pageContext.request.contextPath}/reservation" modelAttribute="recording" method="post">
        <%
            String id = (String)request.getAttribute("id");
            request.setAttribute("id",id);
        %>
        (8:00--22:00)<br>
        开始时间:<form:input path="start_time"/>(HH-MM)<br>
        结束时间:<form:input path="end_time"/>(HH-MM)<br><br>

        <input type="reset" id="reset" value="重置"/>
        <input type="submit" id="submit" value="提交"/>
    </form:form>
</body>
</html>
