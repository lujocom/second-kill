<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${request.contextPath}/lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${request.contextPath}/templates/css/index.css" rel="stylesheet" type="text/css">


</head>
<body style="text-align: center">

<div style="font-size: 20px">
    评论:
</div>
<textarea id="comment" style="height: 400px;width: 500px" data-csrf="${csrf!''}"><p>这是一个简单的评论</p><img src="null" onerror="alert('加载图片失败')"></textarea>
<div>
    <button id="submitData">提交</button>
    <button id="getData">获取</button>
</div>


<script src="${request.contextPath}/lib/jquery-1.11/jquery-1.11.1.min.js"></script>
<script src="${request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/lib/encode/encode.js"></script>
<script src="${request.contextPath}/lib/htmlparser/htmlparser.js"></script>
<script>
    var parse = function (str) {
        var tagName = 'script,style,link,iframe,frame,';
        tagName     = tagName.split(",");
        var html    = '';
        try {
            HTMLParser(he.unescape(str), {
                start: function (tag, attrs, unary) {
                    if ($.inArray(tag, tagName) >= 0) {
                        return;
                    }
                    html += "<" + tag;
                    //页面转义时要讲标签中的属性去除
                    /*for (var i = 0; i < attrs.length; i++)
                        html += " " + attrs[i].name + '="' + attrs[i].escaped + '"';*/
                    html += ">";
                },
                end: function (tag) {
                    html += "</" + tag + ">";
                },
                chars: function (text) {
                    html += text;
                },
                comment: function (text) {
                    html += text;
                }
            });
            return html;
        } catch (e) {
            console.log(e)
        }
        return html;
    };

    $(function () {
        initEvent();
    });

    function initEvent() {
        $("#submitData").on('click', function () {
            var $comment  = $('#comment');
            var parameter = {
                html: $comment.val(),
                CSRFToken: $comment.data('csrf')
            };
            $.post("/xss/submit-data", parameter, function (data) {
                console.log(data);
            });
        });
        $("#getData").on('click', function () {
            $.post("/xss/get-data", {}, function (data) {
                console.log(data.data.testHtml);
                var html = parse(data.data.testHtml);
                console.log(html);
                var $span = $(html);
                $('body').append($span);
            });
        });
    }


</script>
</body>
</html>