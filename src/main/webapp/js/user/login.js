$(function () {

    $("#sub").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        // if(username == "" || password == "") {
        //     return;
        // }
        $.ajax({
            url: "/userlogin",   //请求路径
            type: "POST",  //请求方式
            asyns: true,   //true :异步 flase:同步   默认true
            cache: "false",  //是否缓存  false关闭缓存  目的是避免部分浏览器缓存加载出错(IE))
            datatype: "json",  //返回类型html, text , json
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({username: username, password: password}),//经过序列化的对象,
            success: function (data) {
                console.log("返回的data数据" + data.code)
                console.log("成功:" + JSON.stringify(data));
                alert(data.msg);
                if (data.code == 200) {
                    sessionStorage.setItem("userId", data.id);
                    sessionStorage.setItem("username", data.username);
                    if (sessionStorage.getItem("currentUrl")!=null){
                        window.location.href=sessionStorage.getItem("currentUrl")
                    } else {

                        window.location.href = data.url;
                    }
                }

            },
            error: function (data) {
                //1响应失败 2 服务器中断 3网络中断 4 返回的不是json数据,无法解析
                console.log("失败:");
                alert("失败");
            }
        });
    })
})
