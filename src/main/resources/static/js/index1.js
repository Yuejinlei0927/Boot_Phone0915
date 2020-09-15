$(function () {
    $("#btn_sou").click(function () {

        var brandKey = $("#search").val();
        var data = {brandname:brandKey}
        $.ajax({
            url:"../phone/getMore",
            data:JSON.stringify(data),
            type:"POST",
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function (reqData) {
                console.log(brandKey+"：多条记录");
                console.log(reqData);

                if(reqData.data.length==0){
                    alert("没有该品牌")
                }else {
                    sessionStorage.setItem("phones",JSON.stringify(reqData.data));
                    window.open("phoneDetail.html","_self");
                }

            }
        })
    });
    $("#lookAll").click(function () {
        var brandKey = $("#search").val();
        var data = {brandname:brandKey}
        $.ajax({
            url:"../phone/getMore",
            data:JSON.stringify(data),
            type:"POST",
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function (reqData) {
                console.log(brandKey+"：多条记录");
                console.log(reqData);
                sessionStorage.setItem("phones",JSON.stringify(reqData.data));
                window.open("phoneDetail.html","_blank");
            }
        })
    })
})
//定义一个函数，获取相应手机的信息
function getPhoneById(hwid) {

    window.open("allPhone.html","_self");

    sessionStorage.setItem("phoneID",hwid);

}










