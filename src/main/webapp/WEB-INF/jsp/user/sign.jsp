<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/31
  Time: 4:20 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>扫码签到界面</title>
    <script type="text/javascript">
        function sign_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        function sign_toUser_info(){
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
                <input type="button" onclick="sign_toUser_info()" value="查看个人信息" style="margin-left: 100px">
            </span>
    </div><br>

    <div align="center">
        <c:if test="${late}">
            <h3>"你已经迟到，签到无效"</h3>
        </c:if>
        <form:form action="${pageContext.request.contextPath}/sign" method="post">
            <input type="submit" name="submit" value="签到"><br><br>
            <input type="button" onclick="sign_toMain()" value="返回主界面"/>

        </form:form>
    </div>

</body>
</html>
