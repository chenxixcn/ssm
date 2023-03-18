<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link href="/css/cropper.min.css" rel="stylesheet">
    <link href="/css/sitelogo.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">

    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/cropper.js"></script>
    <script src="/js/sitelogo.js"></script>
    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="/css/theme.css">
    <link rel="stylesheet" type="text/css" href="/css/utility.css">
    <link rel="stylesheet" type="text/css" href="/css/custom.css">
    <!-- Favicon -->
    <link rel="shortcut icon" href="/img/favicon.ico">

    <style>
        .nav li {
            border-bottom: 1px solid #eee;
        }

        .glyphicons-facebook {
            margin-right: 40px;
        }
    </style>

</head>

<!-- Start: Header -->
<header class="navbar navbar-fixed-top">
    <div class="navbar-branding"><span id="toggle_sidemenu_l" class="glyphicons glyphicons-show_lines"></span>
        <a class="navbar-brand" style="padding-top: 7px;">OA管理系统</a>
    </div>
</header>
<!-- End: Header -->
<!-- Start: Main -->
<div id="main">
    <!-- Start: Sidebar -->
    <aside id="sidebar_left">

        <div class="user-info">
            <div class="media">
                <div class="pull-left">
                    <div class="media-object border border-purple br64 bw2 p2" data-toggle="modal"
                         data-target="#avatar-modal">
                        <img id="photo" class="br64" src="/img/timg.gif" alt="...">
                    </div>
                </div>
                <div class="mobile-link"><span class="glyphicons glyphicons-show_big_thumbnails"></span></div>
                <div class="media-body">
                    <h5 class="media-heading mt5 mbn fw700 cursor">
                        <a href="#" target="right">${emp.ename}</a>
                    </h5>
                    <div class="media-links fs11">
                        <a href="#">${emp.depart.dname}</a><i class="fa fa-circle text-muted fs3 p8 va-m"></i>
                        <a href="/employee/loginOut.do">退出</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="sidebar-menu">
            <ul class="nav sidebar-nav">
                <li>
                    <a class="accordion-toggle" href="/depart/selectByDStatus.do?dstatus=0" target="right"> <span
                            class="glyphicons glyphicons-user"></span><span class="sidebar-title">部门管理</span><span
                            class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="/employee/selectEmployeeByStatus.do?estatus=0" target="right"><span
                            class="glyphicons glyphicons-user"></span><span class="sidebar-title">员工管理</span><span
                            class="caret"></span></a>
                </li>

                <li>
                    <a class="accordion-toggle" href="/note/selectNoteByEid.do?eid=${emp.eid}"
                       target="right"><span class="glyphicons glyphicons-user"></span><span
                            class="sidebar-title">请假管理</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="javascript:void(0)" onclick="updatePwd()"
                       target="right"><span class="glyphicons glyphicons-user"></span><span
                            class="sidebar-title">修改密码</span><span class="caret"></span></a>
                </li>
            </ul>
        </div>
    </aside>
    <!-- End: Sidebar -->
    <!-- Start: Content -->
    <div style="position: absolute;left: 230px;width:67%;">
        <iframe scrolling="yes" frameborder="0" name="right" src="/myinfo.jsp" width="100%" height="900"></iframe>
    </div>
</div>
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/myplugs/js/plugs.js"></script>
<script type="text/javascript">
    //添加编辑弹出层
    function updatePwd() {
        $.jq_Panel({
            title: "修改密码",
            iframeWidth: 500,
            iframeHeight: 300,
            url: "/updatePwd.jsp"
        });
    }
</script>
</body>
</html>