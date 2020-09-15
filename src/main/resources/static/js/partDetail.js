var parts = sessionStorage.getItem("parts");
// sessionStorage.removeItem("phones")
console.log(parts);
$(function () {
    if(parts.length>0){
            var str = "";
            var part = JSON.parse(parts);
            console.log(part);
            console.log(part[0].partname);
            $.each(part, function (index,item) {
                str += "<tr>";
                str += "<td>" + part[index].partname + "</td>";
                str += "<td>" + part[index].partprice + "</td>";
                str += "<td>" +  part[index].partcount+ "</td>";
                str += "<td>" +  part[index].partsales+ "</td>";
                str += "<td>" +  part[index].partdesc+ "</td>";
                str += "<td>" +  part[index].parthw+ "</td>";
                str += "</tr>";

            });
            $("#tableShowDetail tbody").html(str);
        } else {
            $("#tableShowDetail tbody").html("<tr><td colspan='4'>没有找到数据</td></tr>")
        }

})

//获取