$(function () {

    $("#but").click(function () {
        let starting = $("#starting").val();
        let end = $("#end").val();
        let time1 =$("#time1").val();

        window.location.href="train_ticket.html?starting="+starting+"&end="+end+"&time1="+time1;
    })
})