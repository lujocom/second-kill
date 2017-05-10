$(function () {


    switch (seckonKillStatus){
        case 1 :
            $('.countdown-container').removeClass('hidden')
                .siblings('div.second-kill-option').addClass('hidden');
            initCountDown(startTime);
            break;
        case 0:
            executeSecondKill();
            break;
        case -1:
            $('.second-kill-tip').removeClass('hidden')
                .siblings('div.second-kill-option').addClass('hidden');
            break;
    }

});

function executeSecondKill() {
    $('.second-kill').removeClass('hidden')
        .siblings('div.second-kill-option').addClass('hidden');
    $('#secondKill').on('click', function () {
        exposeSecondKill().then(function (data) {
            console.log(data);
            if(data.code === '000' && !!data.md5){
                doSecondKill({md5:data.md5});
            }else{
                $('.countdown-container').removeClass('hidden')
                    .siblings('div.second-kill-option').addClass('hidden');
                initCountDown(startTime);
            }
        });
    });
}

function initCountDown(startTime) {
    var labels = ['days', 'hours', 'minutes', 'seconds'],
        timeUnit = ['天','小时','分钟','秒'],
        // nextYear = (new Date().getFullYear() + 1) + '/01/01',
        nextYear = startTime,
        template = _.template($('#main-example-template').html()),
        currDate = '00:00:00:00:00',
        nextDate = '00:00:00:00:00',
        parser = /([0-9]{2})/gi,
        $example = $('#countDown');
    // Parse countdown string to an object
    function strfobj(str) {
        var parsed = str.match(parser),
            obj = {};
        labels.forEach(function(label, i) {
            obj[label] = parsed[i]
        });
        return obj;
    }
    // Return the time components that diffs
    function diff(obj1, obj2) {
        var diff = [];
        labels.forEach(function(key) {
            if (obj1[key] !== obj2[key]) {
                diff.push(key);
            }
        });
        return diff;
    }
    // Build the layout
    var initData = strfobj(currDate);
    labels.forEach(function(label, i) {
        $example.append(template({
            curr: initData[label],
            next: initData[label],
            label: label,
            timeUnit: timeUnit[i]
        }));
    });
    // Starts the countdown
    $example.countdown(nextYear, function(event) {
        var newDate = event.strftime('%D:%H:%M:%S'),
            data;

        if (newDate !== nextDate) {
            currDate = nextDate;
            nextDate = newDate;

            // Setup the data
            data = {
                'curr': strfobj(currDate),
                'next': strfobj(nextDate)
            };
            // Apply the new values to each node that changed
            diff(data.curr, data.next).forEach(function(label) {
                var selector = '.%s'.replace(/%s/, label),
                    $node = $example.find(selector);
                // Update the node
                $node.removeClass('flip');
                $node.find('.curr').text(data.curr[label]);
                $node.find('.next').text(data.next[label]);
                // Wait for a repaint to then flip
                _.delay(function($node) {
                    $node.addClass('flip');
                }, 50, $node);
            });
        }
    }).on('finish.countdown', function () {
        executeSecondKill();
    });
}




function exposeSecondKill() {
    var def = $.Deferred();
    $.post(getPath()+"/second-kill/api/expose/"+seconId,{}, function (data) {
        if(data.code === '000'){
            def.resolve({md5:data.data.md5});
        }else{
            def.resolve({md5:null});
            alert(data.msg)
        }
    });
    return def.promise();
}

function doSecondKill(data) {
    var parameter = $.extend({},data);
    parameter.phoneNumber = '18767896754';
    $.post(getPath()+"/second-kill/api/execute/"+seconId, parameter, function (data) {
        console.log(data);
        alert(data.msg);
        window.location.reload();
    });
}

