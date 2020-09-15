var login = sessionStorage.getItem("login");
$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
    getPhone();
//新增手机
    $("#add").click(function () {
        $("#addType").modal("show");
        var brands = sessionStorage.getItem("brands");
        console.log(JSON.parse(brands))
        var str3 = "";
            $.each(JSON.parse(brands),function (index,item) {
                str3 +="<option>"+item.brandName+"</option>";
                $("#brandName").html(str3)
                console.log(item.brandName);
            })
    })
    $("#save").click(function () {
        var brandname = $("#brandName").val();
        var phonename = $("#typeName").val();
        var phoneprice = $("#typeprice").val();
        var phonecount = $("#typecount").val();
        var phonesales = $("#typesales").val();
        var phoneviews = $("#typeviews").val();
        console.log(phonename);
        var data = {
            "brandname": brandname,
            "hwname": phonename,
            "hwprice": phoneprice,
            "hwcount": phonecount,
            "hwsales": phonesales,
            "hwviews": phoneviews
        };
        $.ajax({
            url: "../phone/add",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                console.log(reqData);
                alert("入库成功");
                $("#addType").modal("hide");
                location.reload();
            }

        })


    });
    $("#close").click(function () {
        $("#addType").modal("hide");
    })
    $("#close1").click(function () {
        $("#updateType").modal("hide");
    })
    //更新手机
    $("#save1").click(function () {
        var uphw = JSON.parse(sessionStorage.getItem("uphw"));
        var hwid = uphw.hwid;
        console.log(hwid)
      var brandname = $("#brandName1").val();
      var hwname = $("#typeName1").val();
      var hwprice = $("#typeprice1").val();
      var hwcount = $("#typecount1").val();
       var hwsales = $("#typesales1").val();
       var hwviews = $("#typeviews1").val();
        var data = {"hwid":hwid,"brandname":brandname,"hwname":hwname,"hwprice":hwprice,"hwcount":hwcount,"hwsales":hwsales,"hwviews":hwviews}
        console.log(data);
        $.ajax({
            url: "../phone/update",
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

    //根据品牌搜索手机
    $("#sousuo").click(function () {
        var brandKey = $("#brand").val();
        var data = {brandname: brandKey};
        $.ajax({
            url: "../phone/getMore",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("phones", JSON.stringify(reqData.data));
                var phones = reqData.data;
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str1 = "";
                $("#page+").click(function () {
                    pageMarkadd(phones)
                })
                $("#page-").click(function () {
                    pageMarkdel(phones)
                })

                for(var i= 0;i<Math.ceil(phones.length/6);i++){
                    let x = i+1;
                    str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(phones)+")'>"+x+"</span>"
                    $("#page").html(str1)

                };
                if (phones.length > 0) {
                    var str = "";
                    $.each(phones.slice(0,6), function (index, item) {
                        str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.hwname + "</td>" + "<td>" + item.brandname + "</td>"+ "<td>" + item.hwprice + "</td>" + "<td>" + item.hwcount + "</td>" + "<td>" + item.hwsales + "</td>" + "<td>" + item.hwviews + "</td>" + "<td>" + "<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "更新" + "</button>" + "</td>" + "<td>" + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "下架" + "</button>" + "</td>" + "</tr>";

                    });

                    $("#apple6 tbody").html(str);
                } else {
                    $("#apple6 tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                }
            }
        })
    })
})

//定一个方法，获取所有的手机
    function getPhone() {


        $.ajax({
            url: "../phone/getAll",
            type: "GET",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("phones", JSON.stringify(reqData.data));
                var phones = reqData.data;
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str1 = "";
                $("#page+").click(function () {
                    pageMarkadd(phones)
                })
                $("#page-").click(function () {
                    pageMarkdel(phones)
                })

                for(var i= 0;i<Math.ceil(phones.length/6);i++){
                    let x = i+1;
                    str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(phones)+")'>"+x+"</span>"
                    $("#page").html(str1)

                };
                if (phones.length > 0) {
                    var str = "";
                    $.each(phones.slice(0,6), function (index, item) {
                        str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.hwname + "</td>"+ "<td>" + item.brandname + "</td>" + "<td>" + item.hwprice + "</td>" + "<td>" + item.hwcount + "</td>" + "<td>" + item.hwsales + "</td>" + "<td>" + item.hwviews + "</td>" + "<td>" + "<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "更新" + "</button>" + "</td>" + "<td>" + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "下架" + "</button>" + "</td>" + "</tr>";

                    });

                    $("#apple6 tbody").html(str);
                } else {
                    $("#apple6 tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                }
            }

        })
    }
    /**/
    function update(phones) {

        // console.log(phones);
        $("#updateType").modal("show");
        var brands = sessionStorage.getItem("brands");
        console.log(JSON.parse(brands))
        var str4 = "";
        $.each(JSON.parse(brands),function (index,item) {
            str4 +="<option>"+item.brandName+"</option>";
            $("#brandName1").html(str4)
            console.log(item.brandName);
        })
        $("#brandName1").val(phones.brandname);
        $("#typeName1").val(phones.hwname);
        $("#typeprice1").val(phones.hwprice);
        $("#typecount1").val(phones.hwcount);
        $("#typesales1").val(phones.hwsales);
        $("#typeviews1").val(phones.hwviews);
        sessionStorage.setItem("uphw",JSON.stringify(phones));

    }
//删除手机
    function del(phones) {
        var r = confirm("确认下架？")
        if (r) {
            var id = phones.hwid;
            console.log(id);
            $.ajax({
                url: "../phone/delById/" + id,
                type: "DELETE",
                success: function (reqData) {
                    console.log(reqData);
                    if (reqData.data) {
                        alert("下架成功！")
                        location.reload();
                    } else {
                        alert("下架失败！")
                        location.reload();
                    }
                }
            })
        }
    }
function pageNext(x,phones) {
    // alert(x)
    // console.log(baskets)
    if (phones.length > 0) {
        var str = "";
        $.each(phones.slice((x-1)*6,x*6), function (index, item) {
            str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.hwname + "</td>"+ "<td>" + item.brandname + "</td>" + "<td>" + item.hwprice + "</td>" + "<td>" + item.hwcount + "</td>" + "<td>" + item.hwsales + "</td>" + "<td>" + item.hwviews + "</td>" + "<td>" + "<button class='btn btn-info' type='button'" +
                " onclick='update(" + JSON.stringify(item) + ")'>" + "更新" + "</button>" + "</td>" + "<td>" + "<button" +
                " class='btn btn-danger' type='button'" +
                " onclick='del(" + JSON.stringify(item) + ")'>" + "下架" + "</button>" + "</td>" + "</tr>";

        });

        $("#apple6 tbody").html(str);
    } else {
        $("#apple6 tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
    }

}
var thispage = 1;
function pageMarkadd(phones) {


    thispage++;
    if(thispage>Math.ceil(phones.length/6)){
        alert("这是最后一页！")
    }else {
        pageNext(thispage,phones)
    }


}
function pageMarkdel(phones) {
    thispage--;
    if (thispage == 0) {
        alert("这是第一页！")
    } else {
        pageNext(thispage, phones)
    }
}









