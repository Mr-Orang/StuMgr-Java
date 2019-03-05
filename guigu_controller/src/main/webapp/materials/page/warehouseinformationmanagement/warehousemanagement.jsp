<!-- 采购入库 入库不等于验收 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		//加载数据框
		//合同编号，采购编号，供货状态（0 未入库，1已部分物资入库，2入库完毕）
		$('#procurementdatadisplay').datagrid({
			title : '采购合同物资入库明细',
			url : '${pageContext.request.contextPath}/inboundInfo/queryInboundInfo',
			pagination : true,
			pageList : [ 5, 10 ],
			pageSize : 5,
			pageNumber : 1,
			singleSelect : true,
			fitColumns : true,
			fit : true,
			columns : [ [
				{
					field : 'contractN',
					title : '合同编号',
					width : 100
				},
				{
					field : 'pceId',
					title : '采购编号',
					width : 100
				},
				{
					field : 'status',
					title : '入库状态',
					width : 100,
					formatter : function(value, row, index) {
						return value == 0 ? "<span style='color:red'>未入库</span>" : (value == 1 ? "<span style='color:blue'>部分物资入库</span>" : (value == 2 ? "<span style='color:green'>入库完毕</span>" : ""));
					}
				},
			] ],
			view : detailview,
			//函数返回函的详细内容
			detailFormatter : function(index, row) {
				return "<div style='height:150px;'><table id='storage_" + row.contractN + "'></table></div>";
			},
			//在展开行的时候触发
			onExpandRow : function(index, row) {
				var tableId = "#storage_" + row.contractN;
				$(tableId).treegrid({
					url : '${pageContext.request.contextPath}/inboundInfo/materialAvailability',
					idField : 'supplierIdOrGoodsId',
					treeField : 'supplierIdOrGoodsId',
					fitColumns : true,
					columns : [ [
						{
							field : 'supplierIdOrGoodsId',
							title : '供应商编号/物资编号',
							width : 100
						},
						{
							field : 'suppliersNameOrgoodsName',
							title : '供应商名称/物资名称',
							width : 100
						},
						{
							field : 'shouldSendTheNumber',
							title : '应送数量',
							width : 100
						},
						{
							field : 'realNumberSend',
							title : '实送数量',
							width : 100
						},
						{
							field : 'missingToSend',
							title : '缺送数量',
							width : 100,
							formatter : function(value, row, index) {
								return row.shouldSendTheNumber - row.realNumberSend;
							}
						}
					] ],
					queryParams : {
						id : row.contractN,
						pceId : row.pceId
					}
				});
			}
		});
	});
</script>
<!-- 数据展示窗口 -->
<div style="display:block;height:100%" id="mainprocurementdatadisplay">
	<div id="procurementdatadisplay"></div>
</div>

