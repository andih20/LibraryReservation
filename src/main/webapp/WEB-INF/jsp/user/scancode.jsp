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
    <title>扫码界面</title>
    <script>
        //生成二维码函数
        function getQRCode() {
            //随机数+时间戳生成一个二维码唯一标识
            var qrCode = Math.random().toString().substring(2) + new Date().getTime();
            //生成二维码，第一个参数是放二维码的容器，第二个参数是二维码访问地址
            new QRCode(document.getElementById("QRCodeDiv"), "http://192.168.1.113:2222/tm-shop-show/shop-front-end/QRCode.html?QRCode=" + qrCode);
            //创建一个定时器执行函数获取二维码登入状态
            var interval = setInterval(getQRCodeStatus, 1000);
            //定时器函数获取二维码登入状态
            function getQRCodeStatus() {
                $.ajax({
                    url: "http://localhost:7777/user/user/getQRCodeStatus",
                    type: "post",
                    data: {"qrCode": qrCode},
                    dataType: "json",
                    success: function (result) {
                        if (result.code === 200) {
                            //登入成功把token存入sessionStore中
                            sessionStorage.setItem("token", result.result);
                            //跳转页面
                            $(location).attr("href", "index.html");
                            //关闭定时器
                            clearInterval(interval);
                        }
                    },
                    error: function () {
                        alert("获取登入状态失败");
                    }
                })
            }
        }
    </script>
</head>
<body>

</body>
</html>
