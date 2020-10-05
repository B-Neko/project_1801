<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
			<div style="height: 250px;">
				<table id="TbOrder"></table>
			</div>
<div id="orderShowWindow" class="easyui-window" title="订单详情展示" style="width:70%;height:80%;"
    data-options="iconCls:'icon-save',modal:true,closed:'true',href:'${pageContext.request.contextPath}/order-show'"></div>
</div>
	<script type="text/javascript">
	
		$('#TbOrder').datagrid({
			url: '${pageContext.request.contextPath}/order/list',
			fit: true,
			pagination: true,
			fitColumns: true,
			onDblClickCell: function(index,field,value){
				if (field == "orderId") {
					//打开window
					$('#orderShowWindow').window({
		        		onLoad:function(){
		        			$('#orderItemList').datagrid({    
		        			    url:'${pageContext.request.contextPath}/order/item/list/' + value,    
		        			    columns:[[    
		        			        {field:'id',title:'订单商品ID',width:100},    
		        			        {field:'itemId',title:'商品ID',width:100},    
		        			        {field:'title',title:'商品标题',width:100},    
		        			        {field:'num',title:'数量',width:50},    
		        			        {field:'price',title:'价格',width:50,align:'right'},
		        			        {field:'pic_path',title:'图片',width:120},
		        			        {field:'status',title:'状态',width:50}
		        			    ]]    
		        			});  
		        			
		        			$('#ffOrderShipping').form('load','${pageContext.request.contextPath}/order/shipping/' + value);

		        		}
		        	}).window('open');
				}
			},toolbar: [{
					text:'1.未付款',
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
								$.post("${pageContext.request.contextPath}/order/status1",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'2.已付款',
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
								$.post("${pageContext.request.contextPath}/order/status2",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'3.未发货',
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
								$.post("${pageContext.request.contextPath}/order/status3",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'4.已发货',
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
								var up = {"ids":ids,"status":4};
								$.post("${pageContext.request.contextPath}/order/status4",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'5.交易成功',
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
								var up = {"ids":ids,"status":5};
								$.post("${pageContext.request.contextPath}/order/status5",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'6.交易关闭',
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
								var up = {"ids":ids,"status":6};
								$.post("${pageContext.request.contextPath}/order/status6",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'7.待退款',
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
								var up = {"ids":ids,"status":7};
								$.post("${pageContext.request.contextPath}/order/status7",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
										});									
									}else{
										alert("修改失败");
									}
								});
							}
						});
					}
				},{
					text:'8.退款成功',
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
								var up = {"ids":ids,"status":8};
								$.post("${pageContext.request.contextPath}/order/status8",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','修改成功!',undefined,function(){
											$("#TbOrder").datagrid("reload");
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
						field: 'orderId',
						title: '订单ID',
						width: 100,
						sortable: true
					}, {
						field: 'payment',
						title: '实付金额',
						width: 100,
						sortable: true
					}, {
						field: 'status',
						title: '状态',
						width: 100,
						formatter:TT.formatOrderStatus,
						sortable: true
					}]
				]
			});
		function getSelections(){
			var itemList = $("#TbOrder");
			var sels = itemList.datagrid("getSelections");
			var ids =[];
			for(var i in sels){
				ids.push(sels[i].orderId);
			}
			ids = ids.join(",");
			return ids;
		}
</script>