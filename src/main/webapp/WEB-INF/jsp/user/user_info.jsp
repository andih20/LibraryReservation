<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/30
  Time: 11:20 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息界面</title>
    <style type="text/css">
        html{
            background-color: white;
        }
        td{
            border:1px solid blanchedalmond;
        }
    </style>
    <script type="text/javascript">
        function User_toMain(){
            document.forms[0].action="${pageContext.request.contextPath}/toMain";
            document.forms[0].submit();
        }
        function toUpdateUser(){
            document.forms[0].action="${pageContext.request.contextPath}/toUpdateUser";
            document.forms[0].submit();
        }
        function toDeleteUser(){
            document.forms[0].action="${pageContext.request.contextPath}/toDeleteUser";
            document.forms[0].submit();
        }
        function toQuit(){
            document.forms[0].action="${pageContext.request.contextPath}/toQuit";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<div>
    <%--@elvariable id="user" type="pojo"--%>
    <jsp:useBean id="recordings" scope="session" type="java.util.List"/>
    <form:form action="${pageContext.request.contextPath}/onefile" modelAttribute="user" method="post" enctype="multipart/form-data">

        <div align="center" style="background: darkgray;">
        <span style="float: left">
            <input type="button" onclick="User_toMain()" value="返回主界面">
        </span>
            <span style="">
            欢迎 -- ${user.uname}
        </span>
            <span style="float: right">
            <input type="button" onclick="user_info()" value="查看个人信息" style="margin-left: 100px">
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
                <br><br>
            </div>
        </div>

        <div align="center">
            <h3>个人信息管理</h3>
            <div style="align-content: center">
                <input type="button" onclick="toUpdateUser()" value="修改个人信息"/>&nbsp;&nbsp;&nbsp;
                <input type="button" onclick="toDeleteUser()" value="注销用户"/>&nbsp;&nbsp;&nbsp;
                <input type="button" onclick="toQuit()" value="安全退出"/><br><br>
            </div>
        </div>


        <div align="center">
            <h3>座位记录</h3>
            <div style="align-content: center">
                <table style="border:1px black">
                    <tr style="background-color: blanchedalmond">
                        <td>UID</td>
                        <td>用户名ID</td>
                        <td>座位ID</td>
                        <td>开始时间</td>
                        <td>结束时间</td>
                        <td>是否开始签到</td>
                        <td>是否离开签到</td>
                    </tr>
                    <c:forEach items="${recordings}" var="record">
                        <tr style="background-color: darkgray">
                            <td>${record.uid}</td>
                            <td>${record.user_id}</td>
                            <td>${record.seat_id}</td>
                            <td>${record.start_time}</td>
                            <td>${record.end_time}</td>
                            <td>${record.presence}</td>
                            <td>${record.end_presence}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" align="right">
                            &nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
                            第${pageCur}页&nbsp;&nbsp;
                            <c:url var="url_pre" value="toUser_info">
                                <c:param name="pageCur" value="${pageCur - 1 }"/>
                            </c:url>
                            <c:url var="url_next" value="toUser_info">
                                <c:param name="pageCur" value="${pageCur + 1 }"/>
                            </c:url>
                            <!-- 第一页没有上一页 -->
                            <c:if test="${pageCur != 1 }">
                                <a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if>
                            <!-- 最后一页，没有下一页 -->
                            <c:if test="${pageCur != totalPage && totalPage != 0}">
                                <a href="${url_next}">下一页</a>
                            </c:if>
                        </td>
                    </tr>
                </table><br>
            </div>
        </div>
<%--        <c:if test="${user.black}">--%>
<%--            申述--%>
<%--            <input type="file" name="uploadFile" id="uploadFile"><br>--%>
<%--            <input type="submit" value="提交"/>--%>
<%--        </c:if>--%>
    </form:form>

</div>
</body>
</html>
