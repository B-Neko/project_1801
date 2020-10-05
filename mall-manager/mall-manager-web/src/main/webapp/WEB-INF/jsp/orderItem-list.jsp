<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 350px;">
		<table id="TbOrderItem"></table>
	</div>
	<br/>
	<br/>
</div>
	<script type="text/javascript">
		$('#TbOrderItem').datagrid({
				url: 'orderItem/list',
				fit: true,
				pagination: true,
				fitColumns: true,
				toolbar: [{
					text:'1.正常交易',
					iconCls : 'fa fa-edit',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个订单");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要修改ID为'+ids+'订单吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var up = {"ids":ids,"status":0};
								$.post("${pageContext.request.contextPath}/orderItem/status1",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrderItem").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'2.申请退款',
					iconCls : 'fa fa-edit',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个订单");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要修改ID为'+ids+'订单吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var up = {"ids":ids,"status":1};
								$.post("${pageContext.request.contextPath}/orderItem/status2",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrderItem").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'3.退款成功',
					iconCls : 'fa fa-edit',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个订单");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要修改ID为'+ids+'订单吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var up = {"ids":ids,"status":2};
								$.post("${pageContext.request.contextPath}/orderItem/status3",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrderItem").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'4.撤销退款记录',
					iconCls : 'fa fa-edit',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个订单");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要修改ID为'+ids+'订单吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var up = {"ids":ids,"status":3};
								$.post("${pageContext.request.contextPath}/orderItem/status4",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrderItem").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				}],

				height: 400,
				columns: [
					[{
						field: 'id',
						title: 'Id',
						width: 60,
						align:'center'
					},{
						field: 'itemId',
						title: '商品id',
						width: 100,
						align:'center'
					},{
						field: 'orderId',
						title: '订单id',
						width: 100,
						align:'center'
					},{
						field: 'num',
						title: '商品购买数量',
						width: 70,
						align:'center'
					},{
						field: 'title',
						title: '商品标题',
						width: 100,
						align:'center'
					},{
						field: 'price',
						title: '商品单价',
						width: 120,
						align:'center'
					}, {
						field: 'totalFee',
						title: '商品总金额',
						width: 120,
						align:'center'
					},{
						field:'picPath',
						title:'商品图片地址',
						width:120,
						align:'center'
					},{
						field:'status',
						title:'状态',
						width:100,
						align:'center'
					}]
				]
			});
		function getSelections(){
			var itemList = $("#TbOrderItem");
			var sels = itemList.datagrid("getSelections");
			var ids =[];
			for(var i in sels){
				ids.push(sels[i].orderId);
			}
			ids = ids.join(",");
			return ids;
		}
</script>