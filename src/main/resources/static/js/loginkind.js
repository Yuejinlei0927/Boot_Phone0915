$(function () {

        var a = '';
        var b = '';
        var c = '';
        var d = '';
        var arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q'
            , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
        yanzheng();
        $("span").on("click", function () {
            yanzheng();
        });


        function yanzheng() {
            a = arr[getRandom(0, arr.length - 1)];
            b = arr[getRandom(0, arr.length - 1)];
            c = arr[getRandom(0, arr.length - 1)];
            d = arr[getRandom(0, arr.length - 1)];

            $("li:nth-child(1)").html(a);
            $("li:nth-child(2)").html(b);
            $("li:nth-child(3)").html(c);
            $("li:nth-child(4)").html(d);

        }
        $("#btnloginkind").on("click", function () {
            if ($("#yanzhengma").val() == a + b + c + d) {
                var kind = $("#sltkind").val();
                var formData = {sysname:$("#loginname").val(),syspass:$("#loginpass").val()};
                console.log(JSON.stringify(formData));
                if(kind == 1){
                    $.ajax({
                        url:"../sys/login",
                        type:"POST",
                        data:JSON.stringify(formData),
                        dataType:"json",
                        contentType:"application/json;charset=utf-8" ,
                        success:function (reqData) {
                            alert(reqData.msg);
                            if("001"==reqData.status){//成功
                                sessionStorage.setItem("login",JSON.stringify(reqData.data));
                                location.href="./bpus_dashboard/index.html";

                            }else {
                                //其他错误信息
                            }
                        }

                    });}
                else if (kind == 2) {
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
                                location.href="index.html";
                            }else {
                                //其他错误信息
                            }
                        }

                    });
                }
                else {
                    alert("请选择身份")
                }

            } else {
                alert("验证码错误")
            }
        });
        function getRandom(min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }


})