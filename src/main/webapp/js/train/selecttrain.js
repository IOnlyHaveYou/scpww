$("#d1").on("click" ,".butt" ,function () {
    var tr1 = $(this).parents("tr");
    var trainCode  = tr1.children().eq(0).text()
    let starting = $("#starting").val();
    let end = $("#end").val();
    let time1 =$("#time1").val();
    if(trainCode .endsWith("动车组")){
        var trainCode = trainCode.replace("动车组","")

    } else if(trainCode .endsWith("高速动车")){
        var trainCode = trainCode.replace("高速动车","")

    }else if(trainCode .endsWith("空调特快")){
        var trainCode = trainCode.replace("空调特快","")

    }else if(trainCode .endsWith("直达特快")){
        var trainCode = trainCode.replace("直达特快","")

    }else if(trainCode .endsWith("快速")){
        var trainCode = trainCode.replace("快速","")

    }else if(trainCode .endsWith("城际高速")){
        var trainCode = trainCode.replace("城际高速","")

    }
    window.location.href="/html/ticketInfo.html?starting="+starting+"&end="+end+"&time1="+time1+"&trainCode="+trainCode;
})
// $("#d2").on("click","#tb",function () {
//     alert("heheh")
// })