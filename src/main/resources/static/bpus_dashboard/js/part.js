var login = sessionStorage.getItem("login");
$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
    getPart();
    //新增配件
        $("#add").click(function () {
            $("#addType").modal("show");
        })
        $("#save").click(function () {
            var partname = $("#typeName").val();
            var partprice = $("#typeprice").val();
            var partcount = $("#typecount").val();
            var partsales = $("#typesales").val();
            var partdesc = $("#typeviews").val();
            console.log(partname);
            var data = {
                "partname": partname,
                "partprice": partprice,
                "partcount": partcount,
                "partsales": partsales,
                "partdesc": partdesc,
            };

            $.ajax({
                url: "../part/add",
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
        //更新配件
        $("#save1").click(function () {
            var uppart = JSON.parse(sessionStorage.getItem("uphw"));
            var partid = uppart.partid;
            console.log(partid)
          var partname = $("#typeName1").val();
          var partprice = $("#typeprice1").val();
          var partcount = $("#typecount1").val();
           var partsales = $("#typesales1").val();
           var partdesc = $("#typeviews1").val();
           var parthw = $("#typhone1").val();
            var data = {"partid":partid,"partname":partname,"partprice":partprice,"partcount":partcount,"partsales":partsales,"partdesc":partdesc,}
            console.log(data);
            $.ajax({
                url: "../part/update",
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
            var data = {partname: brandKey};
            $.ajax({
                url: "../part/getMore",
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (reqData) {
                    // console.log(brandKey+"：多条记录");
                    // console.log(reqData);
                    sessionStorage.setItem("parts", JSON.stringify(reqData.data));
                    var parts = reqData.data;
                    // console.log(phones);
                    // console.log(phones[0].brandname);
                    var str1 = "";
                    $("#page+").click(function () {
                        pageMarkadd(parts)
                    })
                    $("#page-").click(function () {
                        pageMarkdel(parts)
                    })

                    for(var i= 0;i<Math.ceil(parts.length/6);i++){
                        let x = i+1;
                        str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(parts)+")'>"+x+"</span>"
                        $("#page").html(str1)

                    };
                    if (parts.length > 0) {
                        var str = "";
                        $.each(parts.slice(0,6), function (index, item) {
                            str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.partname + "</td>" + "<td>" + item.partprice + "</td>" + "<td>" + item.partcount + "</td>" + "<td>" + item.partsales + "</td>" + "<td>" + item.partdesc + "</td>"+ "<td>" + "<button class='btn btn-info' type='button'" +
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

//定一个方法，获取所有的配件
    function getPart() {


        $.ajax({
            url: "../part/getAll",
            type: "GET",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("parts", JSON.stringify(reqData.data));
                var parts = reqData.data;
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str1 = "";
                $("#page+").click(function () {
                    pageMarkadd(parts)
                })
                $("#page-").click(function () {
                    pageMarkdel(parts)
                })

                for(var i= 0;i<Math.ceil(parts.length/6);i++){
                    let x = i+1;
                    str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(parts)+")'>"+x+"</span>"
                    $("#page").html(str1)

                };
                if (parts.length > 0) {
                    var str = "";
                    $.each(parts.slice(0,6), function (index, item) {
                        str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.partname + "</td>" + "<td>" + item.partprice + "</td>" + "<td>" + item.partcount + "</td>" + "<td>" + item.partsales + "</td>" + "<td>" + item.partdesc + "</td>" + "<td>" + "<button class='btn btn-info' type='button'" +
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
    function update(parts) {

        // console.log(phones);
        $("#updateType").modal("show");
        $("#typeName1").val(parts.partname);
        $("#typeprice1").val(parts.partprice);
        $("#typecount1").val(parts.partcount);
        $("#typesales1").val(parts.partsales);
        $("#typeviews1").val(parts.partdesc);
        $("#typephone1").val(parts.parthw);
        sessionStorage.setItem("uphw",JSON.stringify(parts));

    }
//删除手机
    function del(parts) {
        var r = confirm("确认下架？")
        if (r) {
            var id = parts.partid;
            console.log(id);
            $.ajax({
                url: "../part/delById/" + id,
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
function pageNext(x,parts) {
    // alert(x)
    // console.log(baskets)
    if (parts.length > 0) {
        var str = "";
        $.each(parts.slice((x-1)*6,x*6), function (index, item) {
            str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.partname + "</td>" + "<td>" + item.partprice + "</td>" + "<td>" + item.partcount + "</td>" + "<td>" + item.partsales + "</td>" + "<td>" + item.partdesc + "</td>"+ "<td>" + "<button class='btn btn-info' type='button'" +
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
function pageMarkadd(parts) {


    thispage++;
    if(thispage>Math.ceil(parts.length/6)){
        alert("这是最后一页！")
    }else {
        pageNext(thispage,parts)
    }


}
function pageMarkdel(parts) {
    thispage--;
    if (thispage == 0) {
        alert("这是第一页！")
    } else {
        pageNext(thispage, parts)
    }
}








