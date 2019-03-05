<!-- 选价审核 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		$('#SelectQuoteData').datagrid({
			title : '可审批的供应商报价情况',
			url : '${pageContext.request.contextPath}/priceSelectionAuditController/queryChoicePrice',
			height : 600,
			fitColumns : true,
			singleSelect : true,
			striped : true,
			rownumbers : true,
			columns : [ [
				{
					field : 'chPriceId',
					title : '选择报价编号',
					width : 100
				},
				{
					field : 'pceId',
					title : '采购单编号',
					width : 100
				},
				{
					field : 'status',
					title : '选价状态',
					width : 100,
					formatter : function(value, row, index) {
						if (value == 1) {
							return "已选价";
						}
					}
				},
				{
					field : 'totalAmount',
					title : '采购总额',
					width : 100
				},
			] ],
			toolbar : [ {
				iconCls : 'icon-main_approve',
				text : '审批选价',
				handler : function() {
					var getSelections = $('#SelectQuoteData').datagrid("getSelections");
					if (getSelections.length == 0) {
						$.messager.alert('提示', '您还未选中数据！', 'info');
						return;
					}
					$('#consentInfo').text(getSelections[0].pceId);
					var info = "<div id='infogostote'"
						+ "<h3>您是否同意采购编号为："
						+ "<span id='consentInfo'></span>"
						+ "的选价请求？"
						+ "</h3>"
						+ "<br/>"
						+ "<input type='radio' name='PriceSelectionRequest' value='0'/>同意"
						+ "<input type='radio' name='PriceSelectionRequest' value='1'/>不同意<br/>"
						+ "<div id='yesDisplay' style='display:none'>"
						+ "<br/><h4>不同意理由</h4><br/>"
						+ "<textarea style='width: 260px;height: 80px;' id='textInfoPriceSelectionRequest'></textarea>"
						+ "</div>"
						+ "<br/>"
						+ "<br/>"
						+ "<button onclick='methods.submitDataexamineAndVerify();'>确认提交</button>"
						+ "</div>";
					$(info).window({
						title : '请选择审批数据',
						width : 400,
						height : 300,
						modal : true,
						onClose : function() {
							$(this).window('destroy');
						}
					});
					/**
					 * 不同意审批，则追加文本框询问理由
					 */
					$('input[name=PriceSelectionRequest]').click(function() {
						if ($(this).val() == 0) {
							$('#yesDisplay').css('display', 'none');
						} else {
							$('#yesDisplay').css('display', 'block');
						}
					});
				}
			} ],
			view : detailview,
			detailFormatter : function(rowIndex, rowData) {
				return "<div style='height:170px;'><table id='goods_" + rowData.chPriceId + "'></table></div>";
			},
			onExpandRow : function(index, row) {
				var tableId = "#goods_" + row.chPriceId;
				$(tableId).treegrid({
					url : '${pageContext.request.contextPath}/priceSelectionAuditController/queryDataGrid',
					title : row.chPriceId + "的报价明细",
					iconCls : 'icon-main_Quotationdetails',
					singleSelect : true,
					//关键字段来标识树节点，不能重复
					idField : 'goodsId',
					//树节点字段，也就是树节点的名称
					treeField : 'goodsId',
					fitColumns : true,
					//显示一个行号列
					rownumbers : true,
					collapsible : true, //收起表格的内容
					loadMsg : '数据加载中...',
					//在节点展开或折叠的时候是否显示动画效果
					animate : true,
					//显示treegrid行
					lines : true,
					columns : [ [
						{
							field : 'goodsId',
							title : '物资编号',
							width : 100,
							align : 'left',
							formatter : function(value, row, index) {
								if (value.length > 40) {
									value = value.split(":");
									return value[0];
								}
								return value;
							}
						}, {
							field : 'chPriceID',
							title : '物资名称',
							width : 100,
							align : 'left'
						}, {
							field : 'amount',
							title : '采购数量',
							width : 100,
							align : 'center'
						}, {
							field : 'price',
							title : '采购小计',
							width : 100,
							align : 'center'
						}
					] ],
					queryParams : {
						id : row.chPriceId,
					},
				});
			}
		});
	});
	methods = {
		submitDataexamineAndVerify : function() {
			var text = "";
			if ($('input[name=PriceSelectionRequest]:checked').val() != "0") {
				//因为不同意需要理由
				text = $('#textInfoPriceSelectionRequest').val();
			}
			//去空格
			text = text.trim();
			//判断长度
			if (text.length == 0 && $('input[name=PriceSelectionRequest]:checked').val() == "1") {
				$.messager.alert('提示', '您还未输入理由！', 'info');
				return;
			}
			$.messager.confirm('确定？', '您确定要' + ("0" == $('input[name=PriceSelectionRequest]:checked').val() ? "同意" : "不同意") + '该审批？', function(choose) {
				if (choose) {
					//采购id
					var proId = $('#consentInfo').text().trim();
					//结果
					var excuseInfo = $('input[name=PriceSelectionRequest]:checked').val();
					//理由
					$.ajax({
						type : 'POST',
						url : '${pageContext.request.contextPath}/priceSelectionAuditController/processingApprovals',
						data : {
							proId : proId,
							excuseInfo : excuseInfo,
							text : text,
						},
						success : function(msg) {
							if (msg == "yes") {
								$.messager.show({
									title : '提示',
									msg : '审批处理成功',
									timeout : 3000,
									showType : 'slide'
								});
								$('#SelectQuoteData').datagrid("reload");
								return;
							} else {
								$.messager.alert('提示', '服务器繁忙，请稍后再试', 'info');
							}
						}
					});
				}
			});
		}
	};
</script>
<div>
	<table id="SelectQuoteData">
	</table>
</div>