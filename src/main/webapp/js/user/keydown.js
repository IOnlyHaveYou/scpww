// 鼠标点击添加回车事件,id为sub
$(function () {
    // 回车事件
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#sub").click();
        }
    });
})