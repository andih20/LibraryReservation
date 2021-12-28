<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/12/28
  Time: 4:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript">
        function conceal(){
            document.forms[0].action = "login";
        }
        function submin(){
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form action="" method="post">
    姓名:<input type="text" name="name"><br>
    密码:<input type="password" name="password"><br>
    邮箱:<input type="text" name="email"><br>
    <input type="button" value="取消" onclick="conceal()">
    <input type="button" value="提交" onclick="submit()">
</form>
</body>
</html>
