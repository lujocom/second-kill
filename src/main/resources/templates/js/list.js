$(function () {
    console.log("首页");
    initPageData();
    initEvent();
});

var tpl = '<tr><td>${name}</td><td>${number}</td><td>${startTime}</td><td>${endTime}</td><td>' +
    '<a class="btn btn-info" href="/second-kill/detail/${id}" target="_blank">详情</a></td></tr>';

function initPageData() {
    $.post("/second-kill/api/list", {}, function (data) {
        console.log(data);
        var html = [];
        if (data.code === '000') {
            for(var i = 0, len = data.data.length; i < len; i ++)
            html.push(
                tpl.replace('${name}',data.data[i].name)
                    .replace('${number}',data.data[i].number)
                    .replace('${startTime}',data.data[i].startTimeStr)
                    .replace('${endTime}',data.data[i].endTimeStr)
                    .replace('${id}',data.data[i].seckillId)
            )
            $('#goodList').empty().html(html.join(''));
        }
    });
}
