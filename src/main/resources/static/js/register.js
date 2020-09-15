$(function () {
    $("#btn_sub").click(function () {
        var name = $("#username").val();
        var pass = $("#password").val();
        var email = $("#email").val();
        var tel = $("#tel").val();
        if(tel){
            var user = {"username":name,"userpass":pass,"useremail":email,"usertel":tel}
            $.ajax({

                url:"../user/add",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=utf-8",
                dataType:"json",
                success:function (reqData) {
                    console.log(reqData);
                    if(reqData.data){
                        alert("注册成功！");
                        window.open("userlogin.html","_blank")
                    }
                }

            })
        }

    })
})