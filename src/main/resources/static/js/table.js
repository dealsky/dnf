$(document).ready(function () {

    creatTable();

    $("#add-button").click(function () {

        swal({
            title: "添加一件新的商品",
            text: "商品名称",
            type: "input",
            showCancelButton: true,
            closeOnConfirm: false,
            animation: "slide-from-top",
            inputPlaceholder: "输入商品名称"
        },
        function(cmdName){

            if (cmdName === false) {
                return false;
            }

            if (cmdName === "") {
                swal.showInputError("您需要输入商品名称！");
                return false
            }

            swal({
                title: "添加一件新的商品",
                text: "商品价格",
                type: "input",
                showCancelButton: true,
                closeOnConfirm: false,
                showLoaderOnConfirm: true,
                animation: "slide-from-top",
                inputPlaceholder: "输入商品当前价格"
            },
            function (cmdPrice) {

                if (cmdPrice === false) {
                    return false;
                }

                if (cmdPrice === "" || isNaN(cmdPrice)) {
                    swal.showInputError("您需要输入商品价格！");
                    return false
                }

                $.ajax({
                    url: "/pig/index/list",
                    type: "post",
                    data: {
                        cmdName: cmdName,
                        cmdPrice: cmdPrice
                    },
                    success: function (data) {
                        if (data === "ok") {
                            swal("成功", "新增商品成功","success");
                            destroyTable();
                            creatTable();
                        } else if (data === "name") {
                            swal("失败", "商品名重复","error");
                        } else {
                            swal("失败", "未知错误","error");
                        }
                    },
                    error: function (xhr) {
                        console.log("ajax error");
                    }
                });

            });

        });

    });

});

window.infoEvent = {
    "click .btn": function (e, value, row, index) {
        window.open("details/" + row.cmdnumber);
    }
};

function creatTable() {

    $("#itemTable").bootstrapTable({
        columns: [{
            field: "cmdnumber",
            title: "商品编号"
        }, {
            field: "cmdname",
            title: "商品名称"
        }, {
            field: "cmdprice",
            title: "商品价格",
            sortable: true
        }, {
            field: "cmdtime",
            title: "最近修改时间",
            sortable: true,
            formatter: function (value) {
                return moment(value).format("YYYY-MM-DD HH:mm:ss");
            }
        }, {
            formatter: function () {
                return "<button type='btn' class='btn btn-info'>详情</button>";
            },
            events: infoEvent
        }],
        url: "index/list",
        striped: false,
        cache: false,
        pagination: true,
        search: true,
        showRefresh: true,
        sortable: true,
        sortName: "cmdtime",
        sortOrder: "desc",
        pageNumber: 1,
        pageSize: 10,
        sidePagination: 'client',
        pageList: [10],
        clickToSelect: true,
        paginationLoop: false,
        paginationPreText: "前一页",
        paginationNextText: "后一页",
        height: 475
    });

}

function destroyTable() {

    $("#itemTable").bootstrapTable("destroy");

}
