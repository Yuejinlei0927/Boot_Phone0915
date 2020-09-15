var login = sessionStorage.getItem("login");

$(function () {
    var user = JSON.parse(login);
    console.log(user.sysname)
    $("#index").text(user.sysname)
    $("#role").text(user.sysrole)
    console.log(user)
    console.log(login.sysimg)
    var str = "<img src="+user.sysimg+">";
    // var str = "<img src="+login.sysimg+">";
    $("#sys_img").html(str)
})
