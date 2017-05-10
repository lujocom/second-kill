<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <#--<link href="${request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">-->
    <link href="${request.contextPath}/templates/css/detail.css" rel="stylesheet" type="text/css">
</head>
<script>
    var startTime = '${startTime!0}',
        endTime = '${endTime!0}',
        tody = '${today}',
        number = '${detail.number}',
        seconId = '${detail.seckillId}',
        canSecondKill = ${canSecondKill?c};
</script>
<body>
<div class="container-fluid">
    <div class="panel text-center bg">
        <div class="page-header">
            ${detail.name}
        </div>
        <div class="panel-body">
            <p >
                <span class="glyphicon glyphicon-time"></span>
                秒杀倒计时
            </p>
            <div class="countdown-container" id="countDown">

            </div>
            <div class="second-kill">
                <button id="secondKill" class="btn btn-primary">秒杀</button>
            </div>
        </div>

    </div>

</div>


<script  src="${request.contextPath}/lib/jquery-1.11/jquery-1.11.1.min.js"></script>
<script  src="${request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
<script  src="${request.contextPath}/lib/countdown/jquery.countdown.min.js"></script>
<script  src="${request.contextPath}/lib/underscore/underscore-min.js"></script>
<script  src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script  src="${request.contextPath}/templates/js/util.js"></script>
<script  src="${request.contextPath}/templates/js/detail.js"></script>
<script type="text/template" id="main-example-template">
    <div class="time <%= label %>">
        <span class="count curr top"><%= curr %></span>
        <span class="count next top"><%= next %></span>
        <span class="count next bottom"><%= next %></span>
        <span class="count curr bottom"><%= curr %></span>
        <span class="tip"><%= label.length < 6 ? label : label.substr(0, 3)  %></span>
    </div>
</script>
<script>
</script>
</body>
</html>