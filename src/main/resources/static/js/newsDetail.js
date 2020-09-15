var detailId = sessionStorage.getItem("detailId");
var newsDetail = JSON.parse(sessionStorage.getItem("new"));
$(function () {
    getNews();
    $("#spok").hide()
    $("#spno").hide()


})
// //定义一个方法获取资讯
function getNews() {
    $.ajax({
        url: "../news/getById/"+detailId,
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success:function (reqData) {
            console.log(reqData)
            sessionStorage.setItem("new",JSON.stringify(reqData.data))
            var newsDetail = JSON.parse(sessionStorage.getItem("new"));
            console.log(newsDetail);
            console.log(newsDetail.newsdetail);
            $("#detail_time").text(newsDetail.newstime)
            $("#detail_from").text(newsDetail.newsfrom)
            $("#detail_content").text(newsDetail.newsdetail)
            $("#detail_title").text(newsDetail.newstitle)
            $("#number1").text(newsDetail.newsup)
            $("#number2").text(newsDetail.newsdown)
        }
    })
}
function oka() {
    $("#noa").hide()
    $("#spok").show()
    var newsup = newsDetail.newsup;
    var data = {
        "newsid":newsDetail.newsid,
        "newstitle":newsDetail.newstitle,
        "newscontent":newsDetail.newscontent,
        "newsfrom":newsDetail.newsfrom,
        "newstime":newsDetail.newstime,
        "newsdetail":newsDetail.newsdetail,
        "newsup":parseInt(newsup)+parseInt(1),
        "newsdown":newsDetail.newsdown
    }
    $.ajax({
        url: "../news/update",
        type: "PUT",
        data:JSON.stringify(data),
        contentType: "application/json;charset=utf-8",
        dataType:"json",
        success:function (reqData) {

        }
    })

}

function noa() {
    $("#oka").hide()
    $("#spno").show()
    var newsdown = newsDetail.newsdown
    var data = {
        "newsid":newsDetail.newsid,
        "newstitle":newsDetail.newstitle,
        "newscontent":newsDetail.newscontent,
        "newsfrom":newsDetail.newsfrom,
        "newstime":newsDetail.newstime,
        "newsdetail":newsDetail.newsdetail,
        "newsup":newsDetail.newsup,
        "newsdown":parseInt(newsdown)+parseInt(1)
    }
    $.ajax({
        url: "../news/update",
        type: "PUT",
        data:JSON.stringify(data),
        contentType: "application/json;charset=utf-8",
        dataType:"json",
        success:function (reqData) {

        }
    })

}