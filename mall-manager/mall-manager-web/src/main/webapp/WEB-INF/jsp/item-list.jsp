<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 350px;">
		<table id="dgTbItem"></table>
	</div>
	<br /> <br />
	<!-- <table id="pg" style="width: 300px"></table> -->
	<div id="itemEditWindow" class="easyui-window" title="商品编辑"
		style="width: 80%; height: 80%;"
		data-options="iconCls:'icon-save',modal:true,closed:'true',href:'/item-edit'">
	</div>
</div>
	<script type="text/javascript">
	
		$('#dgTbItem').datagrid({
				url: 'item/getItem',
				fit: true,
				pagination: true,
				fitColumns: true,
				toolbar: [{
					text: '新增',
					iconCls: 'fa fa-plus',
					handler: function() {
						$("#item-add").click();
					}
				}, {
					text: '编辑',
					iconCls: 'fa fa-edit',
					handler: function() {
						var ids = getSelections();
						//判断如果未选定,不执行,提示
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个商品");
							return;
						}
						//如果选的多行数据,提示,只能选择一个商品
						if(ids.indexOf(',') > 0){
							$.messager.alert('提示',"只能选择一个商品");
							return;
						}
						//进行数据回显
						$('#itemEditWindow').window({
							onLoad:function(){ 
								var data = $("#dgTbItem").datagrid("getSelections")[0];
								$('#itemEditForm').form('load',data); 
								//将商品描述进行显示
								$.getJSON("item/query/item-desc/"+data.id,function(result){
									if(result.status == 200){
										itemEditEditor.html(result.data.itemDesc);
									}
								});
								TT.init({
									"pics" : data.image,
									"cid" : data.cid,
									fun:function(node){}
								});
							} 
						}).window('open');
					}
				}, {
					text: '保存',
					iconCls: 'fa fa-save',
					handler: function() {}
				},{
					text: '删除',
					iconCls: 'fa fa-remove',
					handler: function() {
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个商品");
							return;
						}
						//提示是否删除数据
						$.messager.confirm('确认', '您确认想要删除ID为'+ids+'商品吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var items = {"ids":ids};
								$.post("/item/delete",items,function(data){
									if(data.status == 200){
										$.messager.alert('提示','删除商品成功!',undefined,function(){
											$("#dgTbItem").datagrid("reload");
										});									
									}else{
										alert("删除失败");
									}
								});
							}
						});
					}
				},"-",{
					text:'上架',
					iconCls : 'fa fa-hand-o-up',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个商品");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要上架ID为'+ids+'商品吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var up = {"ids":ids,"status":1};
								$.post("/item/putUp",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','上架成功!',undefined,function(){
											$("#dgTbItem").datagrid("reload");
										});									
									}else{
										alert("上架失败");
									}
								});
							}
						});
					}
				},{
					text:'下架',
					iconCls : 'fa fa-hand-o-down',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个商品");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要下架ID为'+ids+'商品吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var down = {"ids":ids,"status":2};
								$.post("/item/putDown",down,function(data){
									if(data.status == 200){
										$.messager.alert('提示','下架成功!',undefined,function(){
											$("#dgTbItem").datagrid("reload");
										});									
									}else{
										alert("下架失败");
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
						title: '商品ID',
						width: 60,
						align:'center'
					}, {
						field: 'title',
						title: '商品标题',
						width: 200,
						align:'center'
					}, {
						field: 'cid',
						title: '类目',
						width: 100,
						align:'center'
					}, {
						field: 'sellPoint',
						title: '卖点',
						width: 100,
						align:'center'
					}, {
						field: 'price',
						title: '价格',
						width: 70,
						align:'center'
					}, {
						field: 'num',
						title: '库存数量',
						width: 70,
						align:'center'
					}, {
						field: 'barcode',
						title: '条形码',
						width: 100,
						align:'center'
					},{
						field:'status',
						title:'状态',
						width:100,
						formatter:TT.formatItemStatus,
						align:'center'
					},  {
						field: 'image',
						title: '图片',
						width: 100,
						formatter:TT.formatImg,
						align:'center'
					}, {
						field: 'created',
						title: '创建日期',
						width: 130,
						formatter:TT.formatDateTime,
						align:'center'
					}, {
						field: 'updated',
						title: '更新日期',
						width: 130,
						formatter:TT.formatDateTime,
						align:'center'
					}
					]
				]
			});
		function getSelections(){
			var itemList = $("#dgTbItem");
			var sels = itemList.datagrid("getSelections");
			var ids =[];
			for(var i in sels){
				ids.push(sels[i].id);
			}
			ids = ids.join(",");
			return ids;
		}
</script>