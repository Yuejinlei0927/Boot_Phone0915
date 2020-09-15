$(function () {
    $("#person1").hide();
        $("#btn_userlogin").click(function () {
            var formData = {username:$("#loginname").val(),userpass:$("#loginpass").val()};
            console.log(JSON.stringify(formData));
            $.ajax({
                url:"../user/login",
                type:"POST",
                data:JSON.stringify(formData),
                dataType:"json",
                contentType:"application/json;charset=utf-8" ,
                success:function (reqData) {
                    alert(reqData.msg);
                    if("001"==reqData.status){//成功
                        sessionStorage.setItem("user",JSON.stringify(reqData.data));
                        var user = sessionStorage.getItem("user")
                        console.log(user);
                        location.href="index.html";
                    }else {
                        //其他错误信息
                    }
                }

            });
        })


})
document.onreadystatechange = function () {
    if(sessionStorage.getItem("user")){
        var user = sessionStorage.getItem("user")
        console.log(user);
        $("#loin1").hide();
        $("#regist1").hide();
        $("#person1").show();
    }
}