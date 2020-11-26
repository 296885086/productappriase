$.fn.bMap = function (option) {
    option = $.extend({
        "name": "map"
    }, option);

    var _this = $(this),
        name = option["name"],
        point,
        location_lng = 116.331398,
        location_lat = 39.897445,
        ac,
        map,
        $map = $("<div class='map-warp' id='Map_" + name + "'></div"),
        $input = $("<input type='text' name='" + name + "' id='Map_input_" + name + "'/>"),
        $location = $("<input type='hidden' name='location_" + name + "' id='Map_location_" + name + "'/>"),
        svg = $('<svg t="1495288306982" class="icon" style="position: absolute;top:33%;margin-top: -10px;" viewBox="0 0 1000 1000" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2378" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20"><defs><style type="text/css"></style></defs></svg>');


    _this.append($input).append($location).append($map).append(svg);

    //判断是否有默认值
    if (option.location || option.address) {
        if (option.location) //如果有默认坐标
        {
            point = new BMap.Point(option.location[0], option.location[1]);
            location_lng = option.location[0];
            location_lat = option.location[1];
            $location.val(location_lng + "," + location_lat);
            //如果有默认地址则直接使用默认地址，
            //如没有默认地址则通过坐标解析地址
            if (!option.address)
                getLocation(point, null, false);
            else
                $input.val(option.address);
        } else {
            //如果没有坐标则通过地址解析坐标
            $input.val(option.address);
            var geoctemp = new BMap.Geocoder();
            geoctemp.getPoint(option.address, function (po) {
                point = po;
                location_lng = po.lng;
                location_lat = po.lat;
                $location.val(location_lng + "," + location_lat);
            })
        }

    } else {
        //根据浏览器定位
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function (r) {
            if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                point = r.point;
                location_lng = r.point.lng;
                location_lat = r.point.lat;
            }
        }, {
            enableHighAccuracy: true
        })
    }
    $map.show().css("zIndex", 999);
    setMap();
    //创建地图，并绑定输入框
    function setMap() {
        if (map) return false;
        map = new BMap.Map("Map_" + name, {
            enableMapClick: false
        });
        map.centerAndZoom(new BMap.Point(location_lng, location_lat), 15);
        map.enableScrollWheelZoom();
        map.enableContinuousZoom();
        marker(point);
        map.addEventListener("click", function (e) {
            marker(e.point);
            getLocation(e.point)
        });
        var valtemp = $input.val();
        ac = new BMap.Autocomplete({
            "input": "Map_input_" + name,
            "location": map
        });
        ac.setInputValue(valtemp);
        ac.addEventListener("onconfirm", function (e) { //鼠标点击下拉列表后的事件
            var _value = e.item.value;
            myValue = _value.province + _value.city + _value.district + _value.street + _value.business;

            function myFun() {
                var pp = local.getResults().getPoi(0).point; //获取智能搜索的结果
                map.centerAndZoom(pp, 15);
                getLocation(pp, _value);
                marker(pp);
            }

            var local = new BMap.LocalSearch(map, { //智能搜索
                onSearchComplete: myFun
            });
            local.search(myValue);
        });
        console.log(map)
    };

    //获取最终的地址
    function getLocation(point, _value, nocallback) {
        var geoc = new BMap.Geocoder();
        $location.val(point.lng + "," + point.lat);
        geoc.getLocation(point, function (rs) {
            var val = rs['addressComponents'];
            if (_value) val = $.extend(_value, val);
            val['business'] = val['business'] ? val['business'] : "";
            if (ac)
                ac.setInputValue(val.province + val.city + val.district + val.street + val.streetNumber + val.business);
            else
                geoc.getLocation(point, function (rs) {
                    $input.val(rs.address);
                });

            if (option.callback && !nocallback) option.callback(val, point);
        });


    }

    function marker(point) {
        map.clearOverlays();
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
        marker.enableDragging();
        marker.addEventListener("dragend", function (e) {
            getLocation(e.point)
        })
    }
};