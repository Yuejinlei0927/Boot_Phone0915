
$(function () {
    getNews();
    //新增资讯
    $("#add").click(function () {
        $("#addType").modal("show");
    })
    $("#save1").click(function () {
        var newstitle = $("#typeName1").val();
        var newscontent = $("#typeprice1").val();
        var newsfrom = $("#typesales1").val();
        var data = {
            "newstitle":newstitle,
            "newscontent":newscontent,
            "newsfrom":newsfrom
        };
        $.ajax({
            url: "../news/add",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                console.log(reqData);
                alert("添加成功");
                $("#addType").modal("hide");
                location.reload();
            }

        })


    });
    $("#close1").click(function () {
        $("#addType").modal("hide");
    })
    $("#close").click(function () {
        $("#updateType").modal("hide");
    })
    //更新手机
    $("#save").click(function () {
        var upnews = JSON.parse(sessionStorage.getItem("upnews"));
        var newsid = upnews.newsid;
        var newstitle = $("#typeName").val();
        var newscontent = $("#typeprice").val();
        var newsfrom = $("#typesales").val();
        var data = {
            "newsid":newsid,
            "newstitle":newstitle,
            "newscontent":newscontent,
            "newsfrom":newsfrom}
        console.log(data);
        $.ajax({
            url: "../news/update",
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
    //根据资讯名称搜索资讯
    $("#sousuo").click(function () {
        var brandKey = $("#brand").val();
        var data = {newstitle: brandKey};
        $.ajax({
            url: "../news/getMore",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (reqData) {
                sessionStorage.setItem("brands", JSON.stringify(reqData.data));
                var news = reqData.data;
                var str1 = "";
                $("#page+").click(function () {
                    pageMarkadd(news)
                })
                $("#page-").click(function () {
                    pageMarkdel(news)
                })

                for(var i= 0;i<Math.ceil(news.length/6);i++){
                    var x = i+1;
                    str1+="<li><span onclick='pageNext(" + x + ","+JSON.stringify(news)+")'>"+x+"</span></li>"
                    $("#page").html(str1)

                };
                if (news.length > 0) {
                    var str = "";
                    $.each(news.slice(0,6), function (index, item) {
                        str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.newstitle + "</td>"+ "<td>" + item.newscontent + "</td>" + "<td>" + item.newsfrom + "</td>" + "<td>" + item.newstime + "</td>"
                            + "<td>" + "<button class='btn btn-info' type='button'" +
                            " onclick='detail("+item.newsid+")'>" + "查看" + "</button>" +"</td>" + "</tr>";

                    });

                    $("#news tbody").html(str);
                } else {
                    $("#news tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
                }
            }
        })
    })
})


//定一个方法，获取所有的新闻
function getNews() {


    $.ajax({
        url: "../news/getAll",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (reqData) {
            // console.log(brandKey+"：多条记录");
            // console.log(reqData);
            sessionStorage.setItem("news", JSON.stringify(reqData.data));
            var news = reqData.data;
            // console.log(phones);
            // console.log(phones[0].brandname);
            var str1 = "";
            $("#page+").click(function () {
                pageMarkadd(news)
            })
            $("#page-").click(function () {
                pageMarkdel(news)
            })

            for(var i= 0;i<Math.ceil(news.length/6);i++){
                var x = i+1;
                str1+="<span onclick='pageNext(" + x + ","+JSON.stringify(news)+")'>"+x+"</span>"
                $("#page").html(str1)

            };
            if (news.length > 0) {
                var str = "";
                $.each(news.slice(0,6), function (index, item) {
                    str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>" + "<td>" + item.newstitle + "</td>"+ "<td>" + item.newscontent + "</td>" + "<td>" + item.newsfrom + "</td>" + "<td>" + item.newstime + "</td>"
                        + "<td>" + "<button class='btn btn-info' type='button'" +
                        " onclick='detail("+item.newsid+")'>" + "查看" + "</button>" +"</td>" + "</tr>";

                });

                $("#news tbody").html(str);
            } else {
                $("#news tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
            }
        }

    })
}
//删除手机
function del(news) {
    var r = confirm("确认下架？")
    if (r) {
        var id = news.newsid;
        console.log(id);
        $.ajax({
            url: "../news/delById/" + id,
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
function detail(id) {
    sessionStorage.setItem("detailId",id)
    window.open("newsDetail.html","_blank")


}
function pageNext(x,news) {
    // alert(x)
    // console.log(baskets)
    if (news.length > 0) {
        var str = "";
        $.each(news.slice((x-1)*6,x*6), function (index, item) {
            str += "<tr>" + "<th scope='row'>" + (index+1) + "</th>"+ "<td>" + item.newstitle + "</td>"+ "<td>" + item.newscontent + "</td>" + "<td>" + item.newsfrom + "</td>" + "<td>" + item.newstime + "</td>"
                + "<td>" + "<button class='btn btn-info' type='button'" +
                " onclick='open(" + JSON.stringify(item) + ")'>" + "查看" + "</button>"  + "</tr>";


        });

        $("#news tbody").html(str);
    } else {
        $("#news tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>");
    }

}
var thispage = 1;
function pageMarkadd(news) {


    thispage++;
    if(thispage>Math.ceil(news.length/6)){
        alert("这是最后一页！")
    }else {
        pageNext(thispage,news)
    }


}
function pageMarkdel(news) {
    thispage--;
    if (thispage == 0) {
        alert("这是第一页！")
    } else {
        pageNext(thispage, news)
    }
}