$(function () {
    var userId = sessionStorage.getItem("userId");
    if (userId != null) {
        $("#ul01").html("  <li class=\"layui-nav-item\">\n" +
            "                    <img src=\"http://t.cn/RCzsdCq\" class=\"layui-nav-img\">\n" +
            "                    " + sessionStorage.getItem("username") + "\n" +
            "                <dl class=\"layui-nav-child\">\n" +
            "                    <dd><a href=\"\" id='a01'>基本资料</a></dd>\n" +
            "                    <dd><a href=\"\" id='a02'>常用乘车人管理</a></dd>\n" +
            "                    <dd><a href=\"\" id='a03'>退出登录</a></dd>\n" +
            "                </dl>\n" +
            "            </li>\n" + "<li class=\"layui-nav-item\">&nbsp &nbsp</a></li>"
        )
    }

    $("#a01").click(function () {
        $("#a01").attr("href","/user/userdetail.html")
    })

    $("#a02").click(function () {

    })

    $("#a03").click(function () {
        sessionStorage.removeItem("userId");
        window.location.href="/user/index.html"
    })
})