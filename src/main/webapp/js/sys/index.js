
var index_list = {
    init:function(){
        $("#tableData").datagrid({
            url:ctx+"/login.do?method=getUserList",
            columns:[[
                {field:'id',title:'ID',width:100},
                {field:'code',title:'编码',width:100},
                {field:'phone',title:'电话',width:100},
                {field:'name',title:'姓名',width:100},
                {field:'age',title:'age',width:100}
            ]],
            pagination : true,
            rownumbers : true,
            pageSize:20,
            pageList : [ 20, 30, 50, 100 ]
        })
    }
}

//初始化表格
index_list.init();