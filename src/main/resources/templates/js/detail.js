$(function () {

    $.post(getPath()+"/second-kill/api/now",{},function (data) {
        if(data.code === '000'){

        }
    });

    initCountDown();

    $('#secondKill').on('click', function () {
        exposeSecondKill().then(function (data) {
            console.log(data);
            if(!!data.md5){
                doSecondKill({md5:data.md5});
            }
        });
    });

});

function initCountDown(startTime, currentTime) {
    var labels = ['weeks', 'days', 'hours', 'minutes', 'seconds'],
        nextYear = new Date(startTime),
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
            label: label
        }));
    });
    // Starts the countdown
    $example.countdown(nextYear, function(event) {
        var newDate = event.strftime('%w:%d:%H:%M:%S'),
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

