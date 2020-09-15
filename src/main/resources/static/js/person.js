var user = sessionStorage.getItem("user");
// sessionStorage.removeItem("user");
 var baskets = sessionStorage.getItem("baskets")
console.log(user);
$(function () {

    $("#all").click(function () {

})

       console.log(baskets)
        // $(":checkbox").attr("checked","checked");
        $(":checkbox").filter((index, item) => {
            // console.log(item.dis)
            return !item.disabled
        }).attr("checked", "checked")
        var total = new Array();
        if(baskets.length>0){
            $.each(baskets,function (index,item) {
                total.push(item.shopprice*item.shopcount);
            })
        }
    $(".checkbox").each(function (index,item) {
        if($(".checkbox:checked")){

        }
        console.log(total)
        function getSum(total, num) {
            return +total + +num;
        }
        $("#tol").text(total.reduce(getSum)) ;
    })
    $("#zf").click(function () {
        var r = confirm("你确定要支付吗");
        if(r){
            window.open("pay.html","_blank");
        }

    })





    //清空购物车操作
    $("#delall").click(function () {
        var r = confirm("确认删除？")
        if(r){
        var baskets = JSON.parse(sessionStorage.getItem("baskets"))
            console.log(baskets);
        var ids = new Array();
        if(baskets.length>0){
            $.each(baskets,function (index,item) {
                ids.push(item.basketids);
            })
        }
        console.log(ids)
        var data = {"ids":ids};
        $.ajax({
            url: "../basket/delByIds",
            type: "DELETE",
            data:JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType:"json",
            success: function (reqData) {
                console.log(reqData);
                if (reqData) {
                    alert("清空购物车成功！")
                    window.location.reload()

                } else {
                    alert("清空购物车失败")
                }
            }
        })
        }
    })


//修改个人中心购物车 操作
    $("#divmodifypwd").hide();
    //修改信息按钮
    $("#btn_update").click(function () {
        $("#divmodifypwd").show();
        // $("#userName").val(users.username)
        $("#passWord").val(users.userpass)
        $("#Email").val(users.useremail)
        $("#Tel").val(users.usertel)
    })
    $("#btnclose").click(function () {
        $("#divmodifypwd").hide();
    })
    $("#btnexit").click(function () {
        $("#divmodifypwd").hide();
    })
    $("#btnsub").click(function () {
        //更新个人信息
        var id = JSON.parse(user).userid;
        console.log(id);
        var username = users.username;
        var userpass= $("#passWord").val()
         var useremail=$("#Email").val()
         var usertel=$("#Tel").val()
        var data = {
            "userid":id,
            "username":username,
            "userpass": userpass,
            "useremail": useremail,
            "usertel": usertel,
        };
        $.ajax({
            url: "../user/update",
            type: "PUT",
            data:JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType:"json",
            success: function (reqData) {
                console.log(reqData);
                if (reqData) {

                    alert("更新成功!")
                    alert("账号密码已过期，请重新登录!")
                    $("#divmodifypwd").hide();
                    window.open("userlogin.html","_self");

                } else {
                    alert("更新失败！")
                }
            }
        });
    })

//获取页面的用户信息
    var user1 = JSON.parse(user);

    var userid = user1.userid;
    console.log(userid)
    $.ajax({
        url: "../basket/getShopByUserId/"+userid,
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (reqData) {
                console.log(reqData)
            var baskets = reqData.data;
            sessionStorage.setItem("baskets",JSON.stringify(baskets));
            var str = "";
            if (baskets.length > 0) {

                $.each(baskets, function (index, item) {
                    if (item.status == '未支付'){
                        str += "<tr>" +"<td>"+"<input  type = 'checkbox'" +
                            " onchange='change()'" +
                            " class='checkbox'" +
                            "  value='"+JSON.stringify((item.shopprice)*item.shopcount) +"' " +
                            " id='"+(item.basketids)*item.shopcount+"'>"+"</td>"+
                            "<td>" + item.shopname+"</td>" +
                            // "<td> <img src='" + item.hwimg+"'> </td>" +
                            "<td>" +item.shopprice+"</td>"+
                            "<td class=\"money\">" + item.shopcount*(item.shopprice) +"</td>"+
                            "<td>" + item.adddatetime +"</td>"+
                            "<td>" + item.status +"</td>"+ "<td>" +
                            /*"<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" */
                            "<div>" +
                            "        <ul class=\"btn-numbox\">" +
                            "            <li>" +
                            "                <ul class=\"count\">" +
                            "                    <li class=\"count-count\">购买数量</li>" +
                            "                    <li><span id='"+item.basketids+"'  " +
                            " onclick='jian("+ JSON.stringify(item) + ")' class=\"num-jian\">-</span></li>" +
                            "                    <li><input type=\"text\" class=\"input-num\"" +
                            " id='"+(item.shopcount)*(item.shopprice)+"'  value="+item.shopcount+" /></li>" +
                            "                    <li><span id='"+item.shopprice+"' " +
                            "onclick='jia("+ JSON.stringify(item) +" )'  class=\"num-jia\">+</span></li>" +
                            "                </ul>" +
                            "            </li>" +
                            "        </ul>" +
                            "    </div>"+ "</td>" +
                            "<td>" + "<button" + " class='btn btn-primary' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "更新" + "</button>" +
                            /*"</td>"+
                            "<td>" +*/ "<button" +
                            " class='btn btn-success' type='button'" +
                            " onclick='back(" + JSON.stringify(item) + ")'>" + "评论" + "</button>" /*+ "</td>"+

                            "<td>"*/ + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" /*+ "</td>"+
                            "<td>"*/ + "<button" +
                            " class='btn btn-warning' id='"+(item.basketids)*(item.shopprice)+"' type='button'" +
                            " onclick='pay(" + JSON.stringify(item) + ")'>" + "支付" + "</button>" + "</td>"+"</tr>";
                    }
                    else {
                        str += "<tr>" +"<td>"+"<input  type = 'checkbox'" +
                            " onchange='change()'" +
                            " class='checkbox' disabled='true'" +
                            "  value='"+JSON.stringify((item.shopprice)*item.shopcount) +"' " +
                            " id='"+(item.basketids)*item.shopid+"'>"+"</td>"+
                            "<td>" + item.shopname+"</td>" +
                            // "<td> <img src='" + item.hwimg+"'> </td>" +
                            "<td>" +item.shopprice+"</td>"+
                            "<td>" + item.shopcount*(item.shopprice) +"</td>"+
                            "<td>" + item.adddatetime +"</td>"+
                            "<td>" + item.status +"</td>"+ "<td>" +
                            /*"<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" */
                            "<div>" +
                            "        <ul class=\"btn-numbox\">" +
                            "            <li>" +
                            "                <ul class=\"count\">" +
                            "                    <li class=\"count-count\">购买数量</li>" +
                            "                    <li><span id='"+item.basketids+"'  " +
                            " onclick='jian("+ JSON.stringify(item) + ")' class=\"num-jian\">-</span></li>" +
                            "                    <li><input type=\"text\" class=\"input-num\"" +
                            " id='"+(item.shopcount)*(item.shopprice)+"'  value="+item.shopcount+" /></li>" +
                            "                    <li><span id='"+item.shopprice+"' " +
                            "onclick='jia("+ JSON.stringify(item) +" )'  class=\"num-jia\">+</span></li>" +
                            "                </ul>" +
                            "            </li>" +
                            "        </ul>" +
                            "    </div>"+ "</td>" +
                            "<td>" + "<button" + " class='btn btn-primary' disabled='disabled'   type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "更新" + "</button>" +
                            /*"</td>"+
                            "<td>" +*/ "<button" +
                            " class='btn btn-success' disabled='disabled' type='button'" +
                            " onclick='back(" + JSON.stringify(item) + ")'>" + "评论" + "</button>" /*+ "</td>"+

                            "<td>"*/ + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" /*+ "</td>"+
                            "<td>"*/ + "<button" +
                            " class='btn btn-warning' disabled='disabled' id='"+(item.basketids)*(item.shopprice)+"' type='button'" +
                            " onclick='pay(" + JSON.stringify(item) + ")'>" + "支付" + "</button>" + "</td>"+"</tr>";
                    }

                });
                $("#tablebasket tbody").html(str);

            } else {
                $("#zf").attr("disabled","disabled")
                $("#delall").attr("disabled","disabled")
                $("#all").attr("disabled","disabled")
                $("#tablebasket tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
            }
        }
    })
    if(user){
        var str = "";
        var users = JSON.parse(user);
        console.log(users);
            str += "<tr>";
            str += "<td>" + users.username + "</td>";
            str += "<td>" + users.userpass+ "</td>";
            str += "<td>" + users.useremail + "</td>";
            str += "<td>" + users.adddatetime + "</td>";
            str += "<td>" + users.usertel + "</td>";
            str += "</tr>";

        $("#tableShowPerson tbody").html(str);
    } else {
        $("#tableShowPerson tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>")

    }
    $("#btn_exit").click(function () {
        sessionStorage.removeItem("user");
        open("index.html","_self");
    })
    $("#btn_update").click(function () {
        $("#updateType").modal("show");
    })
})
var baskets = JSON.parse(sessionStorage.getItem("baskets"))
//删除操作
function del(baskets) {
    var r = confirm("确认删除？")
    console.log(baskets)
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
//更新操作
function update(baskets) {
    var basketid = baskets.basketids;

    var shopcount = $("#"+(baskets.shopcount)*(baskets.shopprice)).val();


    var data = {"basketids":basketid,"countids":shopcount}
    console.log(data);
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
                location.reload()
            } else {
                alert("更新失败！")
            }
        }
    });

}
function jia(item) {
    $("#"+(item.shopcount)*(item.shopprice)).val(parseInt($("#"+(item.shopcount)*(item.shopprice)).val()) + 1);
}
function jian(item) {
    if($("#"+(item.shopcount)*(item.shopprice)).val() <= 1) {
        $("#"+(item.shopcount)*(item.shopprice)).val(1);
    } else {

        $("#"+(item.shopcount)*(item.shopprice)).val(parseInt($("#"+(item.shopcount)*(item.shopprice)).val()) - 1);
    }
}
function change() {
    var vals = [0];
    $('input:checkbox:checked').each(function (index, item) {
        vals.push($(this).val());

    });

    function getSum(total, num) {
        return +total + +num;
    }
    if(vals){
        $("#tol").text(vals.reduce(getSum)) ;
    }else {
        $("#tol").text(vals)
    }


}
function pay(baskets) {
    var r = confirm("确认支付？");
    console.log(baskets)
    sessionStorage.setItem("payBasket",JSON.stringify(baskets))
    if(r){
        window.open("pay.html","_self")


    }
}
function back(baskets) {
    window.open("personback.html","_self");
    console.log(baskets)
    var backbasket = JSON.stringify(baskets)
    console.log(backbasket)
    sessionStorage.setItem("backbasket",backbasket);
}


