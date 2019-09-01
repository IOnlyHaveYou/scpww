/**
 * 常用乘车人js
 */
searchpassenger();
    function searchpassenger() {
        var userId = sessionStorage.getItem("userId")
        alert(userId)
        $.ajax({
            url: "/displayPassenger",   //请求路径
            type: "POST",  //请求方式
            asyns: true,   //true :异步 flase:同步   默认true
            cache: "false",  //是否缓存  false关闭缓存  目的是避免部分浏览器缓存加载出错(IE))
            datatype: "json",  //返回类型html, text , json
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({userId:userId}),//经过序列化的对象,
            success: function (data) {
                console.log("返回的data数据" + data.code)
                console.log("成功:" + JSON.stringify(data));

                if (data.code == 200) {
                   console.log(data.passenger);
                    var mytr = "";

                    var mytr = "<tr id=\"tr1\">";
                    mytr += "<td hidden='hidden'>" + "id" + "</td>";
                    mytr += "<td>" + "姓名" + "</td>";
                    mytr += "<td>" + "电话号码" + "</td>";
                    mytr += "<td>" + "身份证" + "</td>";
                    mytr += "<td>" + "操作" + "</td>";
                    mytr += "</tr>";
                    $("#passengerth").html(mytr)
                    var passenger = data.passenger;
                    var outHtml = "";
                    for(i in passenger){
                        outHtml += "<tr>"+
                            "<td hidden>" + passenger[i].id+ "</td>" +
                            "<td>" + passenger[i].name+ "</td>" +
                            "<td>" + passenger[i].telephone + "</td>" +
                            "<td>" + passenger[i].identityNumber + "</td>" +
                            "<td><button class=\"layui-btn , del\" >删除</button></td>" +
                            "</tr>";
                    }
                    $("#passengertb").html(outHtml)
                }

            },
            error: function (data) {
                //1响应失败 2 服务器中断 3网络中断 4 返回的不是json数据,无法解析
                console.log("失败:");
                alert("失败");
            }
        });
    }

$("#passengertb").on('click','.del',function(){
        var truthBeTold = window.confirm("确定删除？")
        if(truthBeTold) {
            var tr1 = $(this).parents("tr");
            var pId = tr1.children().eq(0).text()
            $.ajax({
                url: "/deleltPassenger",   //请求路径
                type: "POST",  //请求方式
                asyns: true,   //true :异步 flase:同步   默认true
                cache: "false",  //是否缓存  false关闭缓存  目的是避免部分浏览器缓存加载出错(IE))
                datatype: "json",  //返回类型html, text , json
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify({id: pId}),//经过序列化的对象,
                success: function (data) {

                    searchpassenger();

                },
                error: function (data) {
                    //1响应失败 2 服务器中断 3网络中断 4 返回的不是json数据,无法解析
                    console.log("失败:");
                    alert("失败");
                }
            });
        }
    })

$("#addbutt").click(function () {

    layer.open({
        title: '添加常用乘车人',
        type: 1,
        area: ['600px', '360px'],
        shadeClose: true, //点击遮罩关闭
        content: "<div >\n" +
            "        <div class=\"layui-form-item\" >\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <input  style=\"width: 300px ; margin-left: -50px ; margin-bottom: 30px ; margin-top: 30px\" type=\"text\" name=\"username\" placeholder=\"请输入真实姓名\" class=\"layui-input\" id=\"username\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\"  >\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <input style=\"width: 300px ; margin-left: -50px; margin-bottom: 30px\" type=\"text\" name=\"telephone\" placeholder=\"请输入电话号码\" class=\"layui-input\" id=\"telephone\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\" >\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <input style=\"width: 300px ; margin-left: -50px\" type=\"text\" name=\"user_identity\" placeholder=\"请输入身份证\" class=\"layui-input\" id=\"user_identity\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <button class=\"layui-btn\" id = \"addbut\" style=\"margin-left: 60px\">添加</button>\n" +
            "        </div>"

    });

})
$(document).on("click","#addbut",function(){
    var username = $("#username").val();
    var telephone =$("#telephone").val();
    var useridentity =$("#user_identity").val();
    var userId = sessionStorage.getItem("userId");
    $.ajax({
        url: "/addPassenger",   //请求路径
        type: "POST",  //请求方式
        asyns: true,   //true :异步 flase:同步   默认true
        cache: "false",  //是否缓存  false关闭缓存  目的是避免部分浏览器缓存加载出错(IE))
        datatype: "json",  //返回类型html, text , json
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({name: username , telephone:telephone , identityNumber:useridentity ,userId :userId}),//经过序列化的对象,
        success: function (data) {
            console.log("返回的data数据" + data.code)
            console.log("成功:" + JSON.stringify(data));
            if(data.code == 200){
            layer.closeAll();
            searchpassenger();
            }else if(data.code == 500){
                alert(data.msg);
            }else{
                alert(data.msg);
            }

        },
        error: function (data) {
            //1响应失败 2 服务器中断 3网络中断 4 返回的不是json数据,无法解析
            console.log("失败:");
            alert("失败");
        }
    });

})

