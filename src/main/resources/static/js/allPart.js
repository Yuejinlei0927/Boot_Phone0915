var partId = sessionStorage.getItem("partId")

var part = JSON.parse(sessionStorage.getItem("part"));
$(function () {
    $("#backarea").hide();
    $("#backSub").hide();
    $("#backNow").click(function () {
        $("#backarea").show();
        $("#backSub").show();
    })
    getPart(partId);
    getBack(partId);


    $("#imgl").on("click",function () {
        $("#img img").attr("src",part.imgl)
        $("#imgl").css("border","1px solid red").siblings("#imgr").css("border","0")
    })
    $("#imgr").on("click",function () {
        $("#img img").attr("src",part.imgr)
        $("#imgr").css("border","1px solid red").siblings("#imgl").css("border","0")
    })
    $(".arrow_next,.arrow_prev").on("click",function () {

        if($("#img img").attr("src")==part.imgr){
            $("#img img").attr("src",part.imgl)
            $("#imgr").css("border","1px solid red").siblings("#imgl").css("border","0")
        }else {
            $("#img img").attr("src",part.imgr)
            $("#imgl").css("border","1px solid red").siblings("#imgr").css("border","0")
        }

    })

    $("#num-jia").click(function () {
        $("#input-num").val(parseInt($("#input-num").val()) + 1);
    })

    $("#num-jian").click(function () {
        if($("#input-num").val() <= 1) {
            $("#input-num").val(1);
        } else {

            $("#input-num").val(parseInt($("#input-num").val()) - 1);
        }
    })
    var part = JSON.parse(sessionStorage.getItem("part"));
    console.log(part);
    $("#count").val(part.partcount)


    $("#btn_basket7").click(function () {
        var user = JSON.parse(sessionStorage.getItem("user")) ;
        if (user){
            console.log(part);
            var partid = part.partid;
            var userids = user.userid;
            var count = +$("#input-num").val();
            console.log(count)
            // console.log(username)
            var data = {"partids":partid,"userids":userids,"countids":count}
            console.log(data)
            $.ajax({
                url:"../basket/add",
                type:"POST",
                data:JSON.stringify(data),
                contentType:"application/json;charset=utf-8",
                dataType:"json",
                success:function (reqData) {

                    console.log(reqData);
                    alert("添加购物车成功！");
                    sessionStorage.removeItem("part")

                }
            })}else {
            alert("请先登录！")
        }
    })
});
//定义一个函数 获取当前的配件信息
function getPart(partid) {
    $.ajax({
        url:"../part/getById/"+partid,
        type:"get",
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        success:function (reqData) {
            str1 = "<img style='width: 400px;height: 400px' src="+reqData.data.partimg+">";
            $("#img").html(str1);
            str2 = "<img src="+reqData.data.imgr+" style='width: 100%'>";
            $("#imgr").html(str2)
            str3 = "<img src="+reqData.data.imgl+" style='width: 100%'>";
            $("#imgl").html(str3)

            var part = reqData.data;

            sessionStorage.setItem("part",JSON.stringify(part));

            $("#dd_name").text(part.partname);
            $("#dd_price").text("￥"+part.partprice);
            $("#dd_sales").text(part.partsales);
            $("#dd_count").text(part.partcount);
            $("#dd_desc").text(part.partdesc);
        }
    });
}
function getBack(partids) {
    var ids = partids;
    $.ajax({
        url: "../basket/getBack2/"+ids,
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (reqData) {
            var baskets = reqData.data;
            sessionStorage.setItem("baskets",JSON.stringify(baskets));
            $("#numback").text(baskets.length);
        }
    })
}
