<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/jquery-2.1.0.js"></script>
</head>

<body>
<div id="web">
    <p style="height:180px;"></p>
    <p align="center"><img src="/img/logzi.png"/></p>
    <p style="height:40px;"></p>
    <div class="login">
        <div class="banner">
            <iframe id="frame_banner" src="/sban/banner.html" height="218" width="100%" allowtransparency="true"
                    title="test" scrolling="no" frameborder="0"></iframe>
        </div>
        <form action="/employee/login.do" method="post" onsubmit="return check()">
            <div class="logmain">
                <h1>&nbsp;</h1>
                <div class="logdv">
                    <span class="logzi">账 号：</span>
                    <input name="ename" value="" type="text" id="ename" class="ipt"/>
                </div>
                <div class="logdv">
                    <span class="logzi">密 码：</span>
                    <input name="epass" value="" type="password" id="epass" class="ipt"/>
                </div>
                <div class="logdv">
                    <p class="logzi">&nbsp;</p>
                    <a href="#" class="more">忘记密码</a>
                    <input name="" type="checkbox" value="" class="cex"/>记住密码
                </div>
                <div class="logdv" style="height:40px;">
                    <p class="logzi">&nbsp;</p>
                    <input name="提交" type="submit" class="btnbg" value="点击登录"/>
                </div>
                <div>
                    <a href="#" class="more">注册</a>
                </div>
            </div>
        </form>
    </div>
    <p style="height:100px;"></p>
    <!--<p align="center">技术支持:xxxxxxxxxx</p>-->
    <script>

        function check() {
            var ename = $("#ename").val().trim();
            var epass = $("#epass").val().trim();
            if (ename == null || ename == '') {
                return  false;
            }
            if (epass == null || epass == '') {
                return  false;
            }
        }
    </script>
</div>
</body>
</html>
