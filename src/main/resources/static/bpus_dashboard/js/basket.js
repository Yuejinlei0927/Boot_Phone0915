
var login = sessionStorage.getItem("login");

$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
    // getBasket();
    getAllBasket();
    $("#close").click(function () {
        $("#updateType").modal("hide");
    })
    //根据用户名搜索订单
    $("#sousuo2").click(function () {
        var brandKey = $("#brandType").val();
        console.log(brandKey);
        var data = brandKey;
        $.ajax({
            url: "../basket/getMore/"+brandKey,
            type: "GET",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("baskets", JSON.stringify(reqData.data));
                var baskets = reqData.data;
                console.log(baskets)
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str = "";
                if (baskets.length > 0) {
                    $.each(baskets, function (index, item) {
                        str += "<tr>"+ "</th>" + "<td>" + item.basketids + "</td>"  + "<td>" + item.username + "</td>" + "<td>" + item.shopname + "</td>"+ "<td>" + item.shopprice + "</td>"+ "<td>" + item.shopcount + "</td>"+ "<td>" + item.shopcount*(item.shopprice) + "</td>" + "<td>" + item.status+ "</td>"+"<td>" + "<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" + "</td>" + "<td>" + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" + "</td>" + "</tr>";
                    });
                    $("#baskets tbody").html(str);
                } else {
                    $("#baskets tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                }
            }
        })
    })

    //更新订单
    $("#save").click(function () {
        var upbasket = JSON.parse(sessionStorage.getItem("upbaskets"));
        var basketids =upbasket.basketids;
        var status = $("#shopstatus option:selected").text();
        console.log(status)
        var count = $("#count").val();
        var data = {"basketids":basketids,"countids":count,"statusids":status}
        console.log(data)
        $.ajax({
            url: "../basket/update",
            type: "PUT",
            data:JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType:"json",
            success: function (reqData) {
                console.log(reqData);
                if (reqData) {
                    alert("更新成功")
                    $("#updateType").modal("hide");
                    location.reload();
                } else {
                    alert("更新失败！")
                }
            }
        });
    })

})
//定义一个方法获取所有的购物车信息
function getAllBasket() {
        $.ajax({
            url:"../basket/getByBasketAll",
            type:"GET",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success:function (reqData) {
                console.log(reqData.data)
                var data = JSON.stringify(reqData.data);
                $.ajax({
                    url:"../basket/getShopList",
                    data:data,
                    type:"POST",
                    dataType:"json",
                    contentType: "application/json;charset=utf-8",
                    success:function (reqData) {
                        var baskets = reqData.data;
                        sessionStorage.setItem("baskets",JSON.stringify(baskets));
                        var str1 = "";
                        $("#page+").click(function () {
                            pageMarkadd(baskets)
                        })
                        $("#page-").click(function () {
                            pageMarkdel(baskets)
                        })
                        for(var i= 0;i<Math.ceil(baskets.length/6);i++){
                            let x = i+1;
                            str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(baskets)+")'>"+x+"</span>"
                            $("#page").html(str1)

                        };
                        if (baskets.length > 0) {
                            var str = "";
                            $.each(baskets.slice(0,6), function (index, item) {
                                str += "<tr>"
                                    + "<td>" + item.basketids + "</td>"
                                    + "<td>" + item.username + "</td>"
                                    + "<td>" + item.shopname + "</td>"
                                    + "<td>" + item.shopprice + "</td>"
                                    + "<td>" + item.shopcount + "</td>"
                                    + "<td>" + item.shopprice*(item.shopcount) + "</td>"
                                    + "<td>" + item.status+ "</td>"
                                    + "<td>"
                                    + "<button class='btn btn-info' type='button'"
                                    +" onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>"
                                    + "</td>" +
                                    "<td>" + "<button" +
                                    " class='btn btn-danger' type='button'" +
                                    " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>"
                                    + "</td>" + "</tr>";

                            });

                            $("#baskets tbody").html(str);
                        } else {
                            $("#baskets tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                        }
                    }

                })
            }
        })
    }

function del(baskets) {
    var r = confirm("确认删除？")
    if (r) {
        var id = baskets.basketids;
        console.log(id);
        $.ajax({
            url: "../basket/delById/" + id,
            type: "DELETE",
            success: function (reqData) {
                console.log(reqData);
                if (reqData.data) {
                    alert("删除成功！")
                    location.reload();
                } else {
                    alert("删除失败！")
                    location.reload();
                }
            }
        })
    }
}

function update(baskets) {
    $("#updateType").modal("show");
    $("#basketid").val(baskets.basketids);
    $("#hwid").val(baskets.hwids);
    $("#username").val(baskets.username);
    $("#hwname").val(baskets.shopname);
    $("#count").val(baskets.shopcount);
    $("#hwprice").val(baskets.shopprice);
    $("#totalmoney").val((baskets.shopcount)*(baskets.shopprice));
    sessionStorage.setItem("upbaskets",JSON.stringify(baskets));
}
function pageNext(x,baskets) {
    // alert(x)
    // console.log(baskets)
    if (baskets.length > 0) {
        thispage = x;
        var str = "";
        $.each(baskets.slice((x-1)*6,x*6), function (index, item) {
            str += "<tr>"
                + "<td>" + item.basketids + "</td>"
                + "<td>" + item.username + "</td>"
                + "<td>" + item.shopname + "</td>"
                + "<td>" + item.shopprice + "</td>"
                + "<td>" + item.shopcount + "</td>"
                + "<td>" + item.shopprice*(item.shopcount) + "</td>"
                + "<td>" + item.status + "</td>"
                + "<td>"
                + "<button class='btn btn-info' type='button'"
                +" onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>"
                + "</td>" +
                "<td>" + "<button" +
                " class='btn btn-danger' type='button'" +
                " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>"
                + "</td>" + "</tr>";
            // console.log(item.username);
            // console.log(item.basketid);
            // console.log(str);
        });

        $("#baskets tbody").html(str);
    } else {
        $("#baskets tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
    }
}
var thispage = 1;
function pageMarkadd(baskets) {


    thispage++;
    if(thispage>Math.ceil(baskets.length/6)){
        alert("这是最后一页！")
    }else {
        pageNext(thispage,baskets)
    }


}
function pageMarkdel(baskets) {
    thispage--;
    if(thispage==0){
        alert("这是第一页！")
    }else {
        pageNext(thispage,baskets)
    }



}