var phone = JSON.parse(sessionStorage.getItem("part"));
var hwid = phone.partid;
$(function () {
    var data = hwid;
    console.log(hwid)
    // var usernames = null;
    // var backidss = null;
    $.ajax({
        url: "../basket/getBack2/"+data,
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (reqData) {
            var baskets = reqData.data;
            console.log(baskets)
          $.each(baskets,function (index,item) {
              var id = item.userids
              var backidss = item.backids
              let i = index;
              $.ajax({
                  url:"../basket/getByUserId/"+id,
                  type: "GET",
                  contentType: "application/json;charset=utf-8",
                  dataType: "json",
                  success:function (reqData) {
                      var user = reqData.data;
                      baskets[i].username = user.username;
                  }
              })

          })
            setTimeout(function(){
                var str='';
                 baskets.forEach(function(item){
                     str +=  "<tr><th>"+item.username+"</th>"+"<th>"+item.backids+"</th></tr>";
                     if(str){
                         $("#tableback tbody").html(str)
                     }else{
                         $("#tableback tbody").html("无数据")
                     }
                 })
            },100)
            console.log(baskets)
        }
    })
})