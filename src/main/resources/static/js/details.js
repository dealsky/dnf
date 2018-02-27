var chart;

$(document).ready(function () {

    var pathName=window.document.location.pathname;
    var cmdNumber = pathName.substring(pathName.indexOf("/", pathName.indexOf("/") + 1) + 1);

    var theChart = createChart(cmdNumber);
    
    $("#priceBtn").click(function () {

        var cmdPrice = $("#cmdPrice").val();
        $("#cmdPrice").val("");

        if (cmdPrice !== "") {
            $.ajax({
                url: "/pig/" + cmdNumber,
                type: "post",
                data: {
                    cmdPrice: cmdPrice
                },
                success: function (data) {
                    if (data === "ok") {
                        swal("成功", "添加成功","success");
                        chart.destroy();
                        chart = createChart(cmdNumber);
                    } else {
                        swal("失败", "未知错误","error");
                    }
                },
                error: function () {
                    console.log("ajax error");
                }
            });
        } else {
            swal("失败", "请输入值","error");
        }

    });

});

function createChart(cmdNumber) {

    $.ajax({
        url:  "/pig/" + cmdNumber + "/info",
        type: "get",
        dataType: "json",
        success: function (data) {

            if (data.message === "ok") {

                var ctx = $("#lineChart").get(0).getContext("2d");

                var labels = [];
                for (var i in data.info) {
                    var str = moment(data.info[i].cmdDtTime).format("YYYY-MM-DD HH:mm:ss");
                    labels.push(str);
                }

                var theData = [];
                for (var i in data.info) {
                    theData.push(data.info[i].cmdPrice);
                }

                chart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: data.name,
                            backgroundColor: 'rgb(255, 99, 132)',
                            borderColor: 'rgb(255, 99, 132)',
                            data: theData
                        }]
                    },
                    options: {
                        scales: {
                            xAxes: [{
                                display: true
                            }]
                        }
                    }

                });

                $("#priceDiv").show();

            } else {

            }

        },
        error: function () {
            console.log("ajax error");
        }
    });

}

