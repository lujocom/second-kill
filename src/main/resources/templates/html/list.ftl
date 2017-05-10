<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${request.contextPath}/lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${request.contextPath}/templates/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center">商品列表</h1>
    <div class="table-responsive ">
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <td>商品名称</td>
                    <td>商品数量</td>
                    <td>开始时间</td>
                    <td>结束时间</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody id="goodList">
            </tbody>
        </table>
    </div>
</div>


<script  src="${request.contextPath}/lib/jquery-1.11/jquery-1.11.1.min.js"></script>
<script  src="${request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
<script  src="${request.contextPath}/templates/js/util.js"></script>
<script  src="${request.contextPath}/templates/js/list.js"></script>
</body>
</html>