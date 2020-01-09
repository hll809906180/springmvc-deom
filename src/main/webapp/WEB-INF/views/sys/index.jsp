<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="../taglib-esayui.jsp"%>
</head>
<body>
<div class="easyui-layout" data-options="border:false,fit:true"
     id="interimAccountBalanceLis">
    <div data-options="region:'north',border:false"
         style="over-flow: auto; height: 50px;">
        <form id="queryForm" action="${ctx}/balance.do?method=exportPage&accountProp=interim" method="post">
            <table style="margin-top: 10px;">
                <tr style="height: 20px">
                    <td style="text-align: right">归属省份：</td>
                    <td>
                        <input id="provinceCode" name="provinceCode" style="width: 100px" />
                        <input id="cityCode" name="cityCode" style="width: 100px" />
                    </td>
                    <td style="text-align: right" width="80px;">手机号：</td>
                    <td>
                        <input id="cellNum" name="cellNum" style="width: 100px" />
                    </td>
                    <td style="text-align: right; width: 80px" >账户ID：</td>
                    <td>
                        <input id="accountId" name="accountId" style="width: 160px" />
                    </td>
                    <!-- <td style="text-align: right; width: 80px">UID：</td>
                    <td>
                        <input id="uid" name="uid" style="width: 160px" />
                    </td> -->
                    <td style="text-align: right; width: 80px">
                        <a id="queryBtnId" class="easyui-linkbutton"
                           data-options="iconCls:'icon-search'" href="javascript:queryBtn()">查询</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:false">
        <div id="toolBarDiv">
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td><a id="expBtn" class="easyui-linkbutton"
                           data-options="iconCls:'icon-exp',plain:true"
                           href="javascript:exportPage()">导出</a></td>
                    <td>
                </tr>
            </table>
        </div>
        <table id="tableData">
        </table>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${ctx}/js/sys/index.js"></script>