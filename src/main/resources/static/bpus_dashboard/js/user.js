var login = sessionStorage.getItem("login");
$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
    getUser();

    //根据用户名搜索用户
    $("#sousuo").click(function () {
        var brandKey = $("#brand").val();
        // console.log(brandKey);
        var data = {username: brandKey};
        $.ajax({
            url: "../user/getMore",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                // console.log(brandKey+"：多条记录");
                // console.log(reqData);
                sessionStorage.setItem("users", JSON.stringify(reqData.data));
                var users = reqData.data;
                // console.log(phones);
                // console.log(phones[0].brandname);
                var str1 = "";
                $("#page+").click(function () {
                    pageMarkadd(users)
                })
                $("#page-").click(function () {
                    pageMarkdel(users)
                })

                for(var i= 0;i<Math.ceil(users.length/6);i++){
                    let x = i+1;
                    str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(users)+")'>"+x+"</span>"
                    $("#page").html(str1)

                };
                if (users.length > 0) {
                    var str = "";
                    $.each(users.slice(0,6), function (index, item) {
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
        })
    })
//更新用户
    $("#save").click(function () {

        var upuser = JSON.parse(sessionStorage.getItem("upuser"));
        var id = upuser.userid;
        var username = $("#typeName").val();
        var userpass = $("#typeprice").val();
        var useremail = $("#typesales").val();
        var usertel = $("#typecount").val();
        ;
        var data = {
            "userid":id,
            "username": username,
            "userpass": userpass,
            "useremail": useremail,
            "usertel": usertel,

        };
        console.log(data)
        $.ajax({
            url: "../user/update",
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
    });
    $("#close").click(function () {
        $("#updateType").modal("hide");
    })
})

//定一个方法，获取所有的用户
function getUser() {


    $.ajax({
        url: "../user/getAll",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (reqData) {
            // console.log(brandKey+"：多条记录");
            // console.log(reqData);
            sessionStorage.setItem("users", JSON.stringify(reqData.data));
            var users = reqData.data;
            console.log(users);
            // console.log(phones);
            // console.log(phones[0].brandname);
            var str1 = "";
            $("#page+").click(function () {
                pageMarkadd(users)
            })
            $("#page-").click(function () {
                pageMarkdel(users)
            })

            for(var i= 0;i<Math.ceil(users.length/6);i++){
                let x = i+1;
                str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(users)+")'>"+x+"</span>"
                $("#page").html(str1)

            };
            if (users.length > 0) {
                var str = "";
                $.each(users.slice(0,6), function (index, item) {
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

    })
}
/**/
function update(users) {

    // console.log(phones);
    $("#updateType").modal("show");
    // $("#brandName1").val(users.id);
    $("#typeName").val(users.username);
    $("#typeprice").val(users.userpass);
    $("#typesales").val(users.useremail);
    $("#typecount").val(users.usertel);
    // $("#typeviews1").val(users.hwviews);
    sessionStorage.setItem("upuser",JSON.stringify(users));
}
//删除手机
function del(users) {
    var r = confirm("确认删除？")
    if (r) {
        var id = users.userid;
        console.log(id);
        $.ajax({
            url: "../user/delById/" + id,
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









