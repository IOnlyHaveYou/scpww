
function ff() {
    //存放查询的车票数据
    var dataArray = [];

    var start_station = GetQueryString("start_station");
    var end_station = GetQueryString("end_station");
    var date = GetQueryString("date");
    var trainCode =  GetQueryString("trainCode");
    $.ajax({
        url: "/chePiaoChaXue",
        type: "post",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({startStation:start_station,arriveStation:end_station,date:date}),
        success: function (datas) {
            // $("#ticket_info_table").html("");
            $("#ticket_info_table tr:not(:first)").remove();

            var dataArray = JSON.parse(datas[0]).data;
                var innerHtml = "";
                for(idx in dataArray) {
                    if (trainCode == null || trainCode == dataArray[idx].trainGrade){
                        innerHtml += "<tr class='addtr' data-index='" + idx + "'>" +
                            "<td><font color='#2292DD'size='4px'>" + dataArray[idx].trainCode + "</font></td>" +       //车次
                            "<td>" + dataArray[idx].startStation + "</td>" +    //发站
                            "<td>" + dataArray[idx].startTime + "</td>" +       //发时
                            "<td>" + dataArray[idx].arriveStation + "</td>" +   //到站
                            "<td>" + dataArray[idx].endTime + "</td>" +         //到时
                            "<td>" + dataArray[idx].takeTime + "</td>" +        //运行时间
                            "<td>" + dataArray[idx].trainGrade + "</td><td>";      //车型
                    var selectHtml = "";    //同时用于添加下拉选
                    if (dataArray[idx]['business-prc'] != "--") {
                        innerHtml += "<div>商务座：" + dataArray[idx]['business-prc'] + "</div>";  //参考票价
                        selectHtml += "<option value='" + dataArray[idx]['business-prc'] + "'>商务座</option>";
                    }
                    if (dataArray[idx]['one-seat-prc'] != "--") {
                        innerHtml += "<div>一等座：" + dataArray[idx]['one-seat-prc'] + "</div>";
                        selectHtml += "<option value='" + dataArray[idx]['one-seat-prc'] + "'>一等座</option>";
                    }
                    if (dataArray[idx]['two-seat-prc'] != "--") {
                        innerHtml += "<div>二等座：" + dataArray[idx]['two-seat-prc'] + "</div>";
                        selectHtml += "<option value='" + dataArray[idx]['two-seat-prc'] + "'>二等座</option>";
                    }
                    if (dataArray[idx]['soft-seat'] != "--") {
                        innerHtml += "<div>软 座：" + dataArray[idx]['soft-seat'] + "</div>";
                        selectHtml += "<option value='" + dataArray[idx]['soft-seat'] + "'>软 座</option>";

                    }
                    if (dataArray[idx]['hard-seat-prc'] != "--") {
                        innerHtml += "<div>硬 座：" + dataArray[idx]['hard-seat-prc'] + "</div>";
                        selectHtml += "<option value='" + dataArray[idx]['hard-seat-prc'] + "'>硬 座</option>";

                    }
                    if (dataArray[idx]['none-seat-prc'] != "--") {
                        innerHtml += "<div>无 座：" + dataArray[idx]['none-seat-prc'] + "</div>";
                        selectHtml += "<option value='" + dataArray[idx]['none-seat-prc'] + "'>无 座</option>";
                    }
                    //选票
                    innerHtml += "</td><td><select id='select_price_" + idx + "'>" + selectHtml +
                        "</select></td>" +
                        //自设属性 data-index='idx' 用于点击购买按钮时获取当前行索引
                        "<td><button class='btn_buy' data-index='" + idx + "' style='background-color: darkorange'>点击购票</button></td></tr>";//购票
                }
                }
                $("#ticket_info_table").append(innerHtml);
            }

    });

    $("#ticket_info_table").on("click",".btn_buy",function () {
        var index = $(this).attr('data-index');  
        var train_code = dataArray[index].trainCode;
        var start_station = dataArray[index].startStation;
        var end_station = dataArray[index].arriveStation;
        var start_time = date+" "+dataArray[index].startTime;
        var ticket_price = $("#select_price_"+index).find("option:selected").val();
        var ticket_type = $("#select_price_"+index).find("option:selected").text();
        if(ticket_price == "--"){
            alert("请选择正确车票类型！")
            return ;
        }
        window.location.href = "/html/order.html?train_code="+train_code+"&start_station="+start_station
            +"&end_station="+end_station+ "&start_time="+start_time
            +"&ticket_price="+ticket_price+"&ticket_type="+ticket_type;
    })
};
// <!--html获取请求URL的参数方法(name是url的key)-->
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) return decodeURI(r[2]);
    return null;
}
ff()