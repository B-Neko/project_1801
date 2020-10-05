<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 350px;">
		<table id="TbOrderShipping"></table>
	</div>
	<br/>
	<br/>
</div>
	<script type="text/javascript">
	
		$('#TbOrderShipping').datagrid({
				url: 'orderShipping/list',
				fit: true,
				pagination: true,
				fitColumns: true,
				height: 400,
				columns: [
					[{
						field: 'orderId',
						title: '订单ID',
						width: 60,
						align:'center'
					},{
						field: 'receiverName',
						title: '收货人全名',
						width: 100,
						align:'center'
					},{
						field: 'receiverPhone',
						title: '固定电话',
						width: 100,
						align:'center'
					},{
						field: 'receiverMobile',
						title: '移动电话',
						width: 70,
						align:'center'
					},{
						field: 'receiverState',
						title: '省份',
						width: 100,
						align:'center'
					},{
						field: 'receiverCity',
						title: '城市',
						width: 120,
						align:'center'
					}, {
						field: 'receiverDistrict',
						title: '区/县',
						width: 120,
						align:'center'
					},{
						field:'receiverAddress',
						title:'收货地址',
						width:120,
						align:'center'
					},{
						field:'receiverZip',
						title:'邮政编码',
						width:100,						
						align:'center'
					}, {
						field:'created',
						title:'创建时间',
						width:130,
						formatter:TT.formatDateTime,
						align:'center'
					}, {
						field:'updated',
						title:'更新时间',
						width:100,
						formatter:TT.formatDateTime,
						align:'center'
					}]
				]
			});
		function getSelections(){
			var itemList = $("#TbOrderShipping");
			var sels = itemList.datagrid("getSelections");
			var ids =[];
			for(var i in sels){
				ids.push(sels[i].id);
			}
			ids = ids.join(",");
			return ids;
		}
</script>