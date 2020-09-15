
    var phoneID = sessionStorage.getItem("phoneID");
    var phone = JSON.parse(sessionStorage.getItem("phone"));
    $(function () {

        // location.reload()
        console.log(phoneID)

        $("#backarea").hide();
        $("#backSub").hide();
        $("#backNow").click(function () {
            $("#backarea").show();
            $("#backSub").show();
        })
        getHw(phoneID);
        getBack(phoneID)


        $("#imgl").on("click",function () {
            $("#img img").attr("src",phone.imgl)
            $("#imgl").css("border","1px solid red").siblings("#imgr").css("border","0")
        })
        $("#imgr").on("click",function () {
            $("#img img").attr("src",phone.imgr)
            $("#imgr").css("border","1px solid red").siblings("#imgl").css("border","0")
        })
        $(".arrow_next,.arrow_prev").on("click",function () {
            if($("#img img").attr("src")==phone.imgl){
                $("#img img").attr("src",phone.imgr)
                $("#imgr").css("border","1px solid red").siblings("#imgl").css("border","0")
            }else {
                $("#img img").attr("src",phone.imgl)
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

        console.log(phone);
        $("#count").val(phone.hwcount)


        $("#btn_basket7").click(function () {
            var user = JSON.parse(sessionStorage.getItem("user")) ;
            var phone = JSON.parse(sessionStorage.getItem("phone"));
            if (user){
                console.log(phone);
                var hwid = phone.hwid;
                var userid = user.userid;
                var count = $("#input-num").val();

                var data = {"hwids":hwid,"userids":userid,"countids":count}
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
                        sessionStorage.removeItem("phone")

                    }
                })}else {
                alert("请先登录！")
            }
        })

    });


//定义一个函数 获取当前的手机信息
function getHw(hwid) {
    $.ajax({
        url:"../phone/getById/"+hwid,
        type:"get",
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        success:function (reqData) {
            var str1 = "";
            console.log(reqData.data.hwimg);
            str1 = "<img style='width: 400px;height: 400px' src="+reqData.data.hwimg+">";
            $("#img").html(str1);
            str2 = "<img src="+reqData.data.imgr+" style='width: 100%'>";
            $("#imgr").html(str2)
            str3 = "<img src="+reqData.data.imgl+" style='width: 100%'>";
            $("#imgl").html(str3)

            // console.log(reqData);
            var phone = reqData.data;
            console.log(phone.hwid);
            console.log(phone);
            sessionStorage.setItem("phone",JSON.stringify(phone));
            console.log(phone.hwviews)
            $("#dd_brand").text(phone.brandname);
            $("#dd_name").text(phone.hwname);
            $("#dd_price").text("￥"+phone.hwprice);
            $("#dd_sales").text(phone.hwsales);
            $("#dd_count").text(phone.hwcount);
            $("#dd_desc").text(phone.hwviews);
        }
    });
}
function getBack(hwids) {
    var ids = hwids;
    $.ajax({
        url: "../basket/getBack/"+ids,
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

