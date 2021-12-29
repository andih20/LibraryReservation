<%--
  Created by IntelliJ IDEA.
  User: JomQ
  Date: 2021/12/28
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <style>
        .father{
            background-color:rgba(140,11,13,1.00);
            height: 900px;
            width: 1530px;
            position: relative;
        }
        .p2son{
            display: none;
            font-family:宋体;
            color: rgba(255,255,255,1.00);
            font-size: 20px;
            position: absolute;

        }
        a{
            text-decoration: none;
            color: rgba(255,255,255,1.00);
        }
        .nav {
            height: 70px; background-color:rgba(122,15,17,1.00); margin-top: 50px;
        }
        .nav ul {
            margin: auto; width: 1530px; height: 60px;
        }
        .nav ul li {
            float: left;  list-style:none ;  width: 120px;
        }
        .nav ul li a{
            display: inline-block;  width: 120px; height: 60px;   text-decoration: none;  text-align: center;
            line-height: 60px;  color:white; font-size: 20px; font-family: "宋体";
        }
        .nav ul li a:hover {
            background-color:rgba(243,0,4,1.00);
        }
        .dropdown{
            position: relative;
            display: inline-block;
        }
        .dropdown:hover .p2son{
            display: block;
        }

    </style>
</head>
<body>
<div class="father">
    <div>
        <h1>您好，${adminUser.getUname()}，欢迎进入后台管理系统！</h1>
    </div>

    <div class="nav">
        <ul>
            <li>
                <div class="dropdown">
                    <a>座位管理</a>
                    <div class="p2son">
                        <a>添加座位</a>
                        <a>删除座位</a>
                        <a>修改座位</a>
                        <a>查找座位</a>
                    </div>
                </div>
            </li>

            <li>
                <div class="dropdown">
                    <a>用户管理</a>
                    <div class="p2son">
                        <a>添加用户</a>
                        <a>删除用户</a>
                        <a>修改用户</a>
                        <a>查找用户</a>
                    </div>
                </div>
            </li>

            <li>
                <div class="dropdown">
                    <a>预约管理</a>
                    <div class="p2son">
                        <a>添加预约</a>
                        <a>删除预约</a>
                        <a>修改预约</a>
                        <a>查找预约</a>
                    </div>
                </div>
            </li>

            <li>
                <div class="dropdown">
                    <a>公告管理</a>
                    <div class="p2son">
                        <a>添加公告</a>
                        <a>删除公告</a>
                        <a>修改公告</a>
                        <a>查找公告</a>
                    </div>
                </div>
            </li>

            <li>
                <div class="dropdown">
                    <a>安全退出</a>
                </div>
            </li>

        </ul>
    </div>
</div>

</body>
</html>