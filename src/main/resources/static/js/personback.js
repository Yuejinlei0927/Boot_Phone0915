var basket = JSON.parse(sessionStorage.getItem("backbasket"))
$(function () {
    console.log(basket)
   $("#back").click(function () {
       var back = $("#backtext").val()
       console.log(back)
       var basketids = basket.basketids;
       var partids = basketids.partids;

       var data = {"basketids":basketids,"backids":back}
       // console.log(data);
       $.ajax({
           url: "../basket/update",
           type: "PUT",
           data:JSON.stringify(data),
           contentType: "application/json;charset=utf-8",
           dataType:"json",
           success: function (reqData) {
               console.log(reqData);
               if (reqData) {
                   alert("评价成功")
                   window.open('person.html','_self')
               } else {
                   alert("评价失败！")
               }
           }
       });

   })

})