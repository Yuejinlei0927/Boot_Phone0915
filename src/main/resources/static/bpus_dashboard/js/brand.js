var login = sessionStorage.getItem("login");
$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
    getBrand();
    //新增手机品牌
    $("#add").click(function () {
        $("#addType").modal("show");
    })
    $("#save").click(function () {
        var brandName = $("#typeName").val();
        var brandDesc = $("#typeDesc").val();
        var data = {"brandName":brandName,"brandDesc":brandDesc};
        $.ajax({
            url:"../brand/add",
            data:JSON.stringify(data),
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            type:"POST",
            success:function (reqData) {
                console.log(reqData);
                alert("添加成功");
                $("#addType").modal("hide");
                location.reload();
            }
        })
    })
    $("#close").click(function () {
        $("#addType").modal("hide");
    })
    $("#close1").click(function () {
        $("#updateType").modal("hide");
    })
    //更新品牌
    $("#save1").click(function () {
        var upbrand = JSON.parse(sessionStorage.getItem("upbrand"));
        var id = upbrand.id;
        console.log(id)
        var brandName = $("#typeName1").val();
        var brandDesc = $("#typeDesc1").val();
        var data = {"id":id,"brandName":brandName,"brandDesc":brandDesc}
        console.log(data);
        $.ajax({
            url: "../brand/update",
            type: "PUT",
            data:JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType:"json",
            success: function (reqData) {
                console.log(reqData);
                if (reqData) {
                    /*$("#brandName1").val(reqData.data.brandname);
                    $("#typeName1").val(reqData.data.hwname);
                    $("#typeprice1").val(reqData.data.hwprice);
                    $("#typesales1").val(reqData.data.hwsales);
                    $("#typecount1").val(reqData.data.hwcount);
                    $("#typeviews1").val(reqData.data.hwviews);*/
                    alert("更新成功")
                    $("#updateType").modal("hide");
                    location.reload();
                } else {
                    alert("更新失败！")
                }
            }
        });
    })
    //根据品牌搜索手机
    $("#sousuo2").click(function () {
        var brandKey = $("#brandType").val();
        console.log(brandKey);
        var data = {brandName: brandKey};
        $.ajax({
            url: "../brand/getMore",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("brands", JSON.stringify(reqData.data));
                var phones = reqData.data;
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str = "";
                if (phones.length > 0) {
                    $.each(phones, function (index, item) {
                        str += "<tr>"+ "</th>" + "<td>" + item.id + "</td>" + "<td>" + item.brandName + "</td>" + "<td>" + item.brandDesc + "</td>" + "<td>" + "<img src='"+item.brandImg+"'>"+"</td>"+"<td>" + "<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" + "</td>" + "<td>" + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" + "</td>" + "</tr>";
                    });
                    $("#brand tbody").html(str);
                } else {
                    $("#brand tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                }
            }
        })
    })

})
//定义一个方法获取所有的手机品牌
function getBrand() {
    $.ajax({
        url:"../brand/getAll",
        type:"GET",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success:function (reqData) {
            console.log(reqData);
            var brands = reqData.data;
            sessionStorage.setItem("brands",JSON.stringify(brands))
            var str1 = "";
            $("#page+").click(function () {
                pageMarkadd(brands)
            })
            $("#page-").click(function () {
                pageMarkdel(brands)
            })

            for(var i= 0;i<Math.ceil(brands.length/6);i++){
                let x = i+1;
                str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(brands)+")'>"+x+"</span>"
                $("#page").html(str1)

            };
            var str = "";
            if (brands.length > 0) {
                $.each(brands.slice(0,6), function (index, item) {
                    str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>"
                        + "<td>" + item.id + "</td>"
                        + "<td>" + item.brandName + "</td>"
                        + "<td>" + item.brandDesc + "</td>"
                        + "<td>" + "<img src='"+item.brandImg+"'>"+"</td>"
                         + "<td>"
                        + "<button class='btn btn-info' type='button'"
                        +" onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>"
                        + "</td>" +
                        "<td>" + "<button" +
                        " class='btn btn-danger' type='button'" +
                        " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>"
                        + "</td>" + "</tr>";
                    /*console.log(item.brandname);
                    console.log(item.brandDesc);
                            console.log(str);*/
                });

                $("#brand tbody").html(str);
            } else {
                $("#brand tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
            }

        }
    })
}
function del(brands) {
    var r = confirm("确认删除？")
    if (r) {
        var id = brands.id;
        console.log(id);
        $.ajax({
            url: "../brand/delById/" + id,
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
function update(brands) {
    $("#updateType").modal("show");
    $("#typeName1").val(brands.brandName);
    $("#typeDesc1").val(brands.brandDesc);
    sessionStorage.setItem("upbrand",JSON.stringify(brands));
}
function pageNext(x,brands) {
    // alert(x)
    // console.log(baskets)
    if (brands.length > 0) {
        thispage = x;
        var str2 = "";
        $.each(brands.slice((x-1)*6,x*6), function (index, item) {
            str2 += "<tr>" + "<th scope='row'>" + (index+1) + "</th>"
                + "<td>" + item.id + "</td>"
                + "<td>" + item.brandName + "</td>"
                + "<td>" + item.brandDesc + "</td>"
                + "<td>" + "<img src='"+item.brandImg+"'>"+"</td>"
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
            console.log(brands.slice((x-1)*6,x*6))
        });

        $("#brand tbody").html(str2);
    } else {
        $("#brand tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
    }
}
var thispage = 1;
function pageMarkadd(brands) {


    thispage++;
    if(thispage>Math.ceil(brands.length/6)){
        alert("这是最后一页！")
    }else {
        pageNext(thispage,brands)
    }


}
function pageMarkdel(brands) {
    thispage--;
    if(thispage==0){
        alert("这是第一页！")
    }else {
        pageNext(thispage,brands)
    }



}