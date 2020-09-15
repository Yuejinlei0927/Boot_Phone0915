var login = sessionStorage.getItem("login");
$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
    getSys();

    //根据用户名搜索用户
    $("#sousuo").click(function () {
        var brandKey = $("#brand").val();
        // console.log(brandKey);
        var data = {sysname: brandKey};
        $.ajax({
            url: "../sys/getMore",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("sys1", JSON.stringify(reqData.data));
                var sys = reqData.data;
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str1 = "";
                $("#page+").click(function () {
                    pageMarkadd(sys)
                })
                $("#page-").click(function () {
                    pageMarkdel(sys)
                })

                for(var i= 0;i<Math.ceil(sys.length/6);i++){
                    let x = i+1;
                    str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(sys)+")'>"+x+"</span>"
                    $("#page").html(str1)

                };
                if (sys.length > 0) {
                    var str = "";
                    $.each(sys.slice(0,6), function (index, item) {
                        str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.id + "</td>"+ "<td>" + item.sysname + "</td>" + "<td>" + item.syspass + "</td>" + "<td>" + item.sysrole + "</td>" + "<td>" + "<button class='btn btn-info' type='button'" +
                            " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" + "</td>" + "<td>" + "<button" +
                            " class='btn btn-danger' type='button'" +
                            " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" + "</td>" + "</tr>";

                    });

                    $("#user tbody").html(str);
                } else {
                    $("#user tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                }
            }
        })
    })
//更新用户
    $("#save").click(function () {

        var upuser = JSON.parse(sessionStorage.getItem("upsys"));
        var id = upuser.id;
        var sysname = $("#typeName").val();
        var syspass = $("#typeprice").val();
        var sysrole = $("#brandName").val();
        ;
        var data = {
            "id":id,
            "sysname": sysname,
            "syspass": syspass,
            "sysrole": sysrole,

        };
        $.ajax({
            url: "../sys/update",
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
    });
    $("#close").click(function () {
        $("#updateType").modal("hide");
    })
    //新增管理员
    $("#addsys").click(function () {
        $("#addType").modal("show");

    })
    $("#save1").click(function () {
        var sysname = $("#typeName1").val();
        var syspass = $("#typeprice1").val();
        var sysrole = $("#brandName1").val();

        var data = {
            "sysname": sysname,
            "syspass": syspass,
            "sysrole": sysrole,

        };
        $.ajax({
            url: "../sys/add",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                console.log(reqData);
                alert("新增管理员成功");
                $("#addType").modal("hide");
                location.reload();
            }

        })


    });
    $("#close1").click(function () {
        $("#addType").modal("hide");
    })
})

//定一个方法，获取所有的用户
function getSys() {


    $.ajax({
        url: "../sys/getAll",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (reqData) {
            // console.log(brandKey+"：多条记录");
            // console.log(reqData);
            sessionStorage.setItem("syss", JSON.stringify(reqData.data));
            var sys = reqData.data;

            // console.log(phones);
            // console.log(phones[0].brandname);
            var str1 = "";
            $("#page+").click(function () {
                pageMarkadd(sys)
            })
            $("#page-").click(function () {
                pageMarkdel(sys)
            })

            for(var i= 0;i<Math.ceil(sys.length/6);i++){
                let x = i+1;
                str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(sys)+")'>"+x+"</span>"
                $("#page").html(str1)

            };
            if (sys.length > 0) {
                var str = "";
                $.each(sys.slice(0,6), function (index, item) {
                    str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.id + "</td>"+ "<td>" + item.sysname + "</td>" + "<td>" + item.syspass + "</td>" + "<td>" + item.sysrole + "</td>" +  "<td>" + "<button class='btn btn-info' type='button'" +
                        " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" + "</td>" + "<td>" + "<button" +
                        " class='btn btn-danger' type='button'" +
                        " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" + "</td>" + "</tr>";

                });

                $("#user tbody").html(str);
            } else {
                $("#user tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
            }
        }

    })
}


/**/
function update(sys) {

    // console.log(phones);
    $("#updateType").modal("show");
    // $("#brandName1").val(users.id);
    $("#typeName").val(sys.sysname);
    $("#typeprice").val(sys.syspass);
    $("#brandName").val(sys.sysrole);
    sessionStorage.setItem("upsys",JSON.stringify(sys));
}
//删除手机
function del(sys) {
    var r = confirm("确认删除？")
    if (r) {
        var id = sys.id;
        console.log(id);
        $.ajax({
            url: "../sys/delById/" + id,
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
function pageNext(x,users) {
    // alert(x)
    // console.log(baskets)
    if (users.length > 0) {
        var str = "";
        $.each(users.slice((x-1)*6,x*6), function (index, item) {
            str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.userid + "</td>"+ "<td>" + item.username + "</td>" + "<td>" + item.userpass + "</td>" + "<td>" + item.useremail + "</td>" + "<td>" + item.adddatetime + "</td>" + "<td>" + item.usertel + "</td>" + "<td>" + "<button class='btn btn-info' type='button'" +
                " onclick='update(" + JSON.stringify(item) + ")'>" + "修改" + "</button>" + "</td>" + "<td>" + "<button" +
                " class='btn btn-danger' type='button'" +
                " onclick='del(" + JSON.stringify(item) + ")'>" + "删除" + "</button>" + "</td>" + "</tr>";

        });

        $("#user tbody").html(str);
    } else {
        $("#user tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
    }

}
var thispage = 1;
function pageMarkadd(users) {


    thispage++;
    if(thispage>Math.ceil(users.length/6)){
        alert("这是最后一页！")
    }else {
        pageNext(thispage,users)
    }


}
function pageMarkdel(users) {
    thispage--;
    if (thispage == 0) {
        alert("这是第一页！")
    } else {
        pageNext(thispage, users)
    }
}









