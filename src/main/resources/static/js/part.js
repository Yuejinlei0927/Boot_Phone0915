$(function () {
    part();
    $("#btn_sou").click(function () {
        part();
    });


})
function part() {
    var brandKey = $("#search").val();
    var data = {partname:brandKey}
    $.ajax({
        url:"../part/getMore",
        data:JSON.stringify(data),
        type:"POST",
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        success:function (reqData) {
            console.log(brandKey+"：多条记录");
            console.log(reqData);
            sessionStorage.setItem("parts",JSON.stringify(reqData.data));
            var phones = sessionStorage.getItem("parts");
            console.log(phones);
            if(phones.length>0){
                var str = "";
                var phone = JSON.parse(phones);
                console.log(phone);
                $.each(phone,function (index,item) {
                    str += " <div class=\"item\">\n" +
                        "<img src="+item.partimg+" >" +
                        " <p  onclick='getPartById("+item.partid+")' class=\"name\">"+item.partname+"</p>" +
                        "<p class=\"desc\">"+item.partdesc+"</p>" +
                        "<p class=\"price\">￥"+item.partprice+"</p>" +
                        " </div>";
                });
                $("#phone-box").html(str)
            }
        }
    })
}
function getPartById(partid) {
    window.open('allPart.html','_self');
    sessionStorage.setItem("partId",partid);

}
