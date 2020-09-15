
$(function () {
        phone();
   $("#btn_sou").click(function () {
       phone();
   })


})
function phone() {
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
            var phones = sessionStorage.getItem("phones");
            if(phones.length>0){
                var str = "";
                var phone = JSON.parse(phones);
                console.log(phone);
                console.log(phone[0].brandname);
                $.each(phone,function (index,item) {
                    str += " <div class=\"item\">\n" +
                        "<img src="+item.hwimg+" >" +
                        "<p  onclick='getPhoneById("+item.hwid+")' class=\"name\">"+item.hwname+"</p>" +
                        "<p class=\"desc\">"+item.hwviews+"</p>" +
                        "<p class=\"price\">￥"+item.hwprice+"</p>" +
                        " </div>";
                });
                $("#phone-box").html(str)
            }
        }
    })
}
function getPhoneById(hwid) {

    window.open("allPhone.html","_self");

    sessionStorage.setItem("phoneID",hwid);

}
