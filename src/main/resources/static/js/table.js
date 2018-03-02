$(document).ready(function () {

    creatTable();

    $("#add-button").click(function () {
        addItem();
    });

    $("#fix-button").click(function () {
        fixItem();
    });

    $("#delete-button").click(function () {
        deleteItem();
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
            checkbox: true
        }, {
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

function addItem() {

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

}

function fixItem() {

    var arr = $("#itemTable").bootstrapTable("getSelections");
    if (arr.length === 1) {
        swal({
            title: "您想将商品名修改为...",
            text: "请输入新的商品名",
            type: "input",
            showCancelButton: true,
            closeOnConfirm: false,
            showLoaderOnConfirm: true,
            animation: "slide-from-top",
            inputPlaceholder: "母猪锤"
        },
        function (cmdName) {

            if(cmdName === false) {
                return false;
            }

            if (cmdName === "") {
                swal.showInputError("请输入新的商品名！");
                return false;
            }

            $.ajax({

                url: "/pig/index/list",
                type: "put",
                data: {
                    cmdNumber: arr[0].cmdnumber,
                    cmdName: cmdName
                },
                success: function (data) {
                    if (data === "ok") {
                        swal("成功", "操作成功", "success");
                        destroyTable();
                        creatTable();
                    } else if (data === "name") {
                        swal("失败", "商品名重复","error");
                    } else {
                        swal("失败", "未知错误", "error");
                    }
                },
                error: function () {
                    console.log("ajax error!");
                }

            });

        });
    } else if (arr.length === 0) {
        swal("失败了...", "请选择至少一件商品进行修改", "error");
    } else {
        swal("失败了...", "请选择至多一件商品进行修改", "error");
    }

}

function deleteItem() {

    var arr = $("#itemTable").bootstrapTable("getSelections");
    if (arr.length === 1) {

        swal({
            title: "确定删除吗？",
            text: "你将无法恢复相关数据(其实可以)！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定删除！",
            animation: "slide-from-top",
            closeOnConfirm: false
        },
        function(){


            swal("删除！", arr[0].cmdname + "已经被删除。", "success");

        });

    } else if (arr.length === 0) {
        swal("失败了...", "请选择至少一件商品进行修改", "error");
    } else {
        swal("失败了...", "请选择至多一件商品进行修改", "error");
    }

}
