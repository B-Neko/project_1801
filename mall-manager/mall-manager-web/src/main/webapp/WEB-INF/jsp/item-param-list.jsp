<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 350px;">
		<table id="itemParamList"></table>
	</div>
	<br/>
	<br/>
	<div id="itemEditWindow" class="easyui-window" title="商品编辑"
		style="width: 80%; height: 80%;"
		data-options="iconCls:'icon-save',modal:true,closed:'true',href:'/item-param-edit'">
	</div>
</div>
	<script type="text/javascript">
		$('#itemParamList').datagrid({
				url: 'item/param/list',
				fit: true,
				pagination: true,
				fitColumns: true,
				toolbar: [
					{
						text: '添加',
						iconCls: 'fa fa-plus',
						handler: function(){
							TT.createWindow({url:'item-param-add'});
						}
					
					},{
						text: '编辑',
						iconCls: 'fa fa-edit',
						handler: function(){
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
									var data = $("#itemParamList").datagrid("getSelections")[0];
									$('#itemParamEditTable').form('load',data); 
									
									//将商品描述进行显示
									$.getJSON("item/param/query/itemparam-desc/"+data.id,function(result){
										if(result.status == 200){
											//itemEditEditor.html(result.data.itemDesc);
											itemParamEdit.html(result.data)
										}
									});
									
									
									TT.init({
										"itemCatId" : data.itemCatId,
										"paramData" : data.paramData,
										fun:function(node){}
									});
								} 
							}).window('open');
						}
					
					},{
						text: '删除',
						iconCls: 'fa fa-remove',
						handler: function(){
							var ids = getSelections();
							if(ids.length == 0){
								$.messager.alert('提示',"必须选择一个或多个商品规格");
								return;
							}
							//提示是否删除数据
							$.messager.confirm('确认', '您确认想要删除ID为'+ids+'商品规格吗?', function(r) {
								if(r) {
									//进行post跟服务端交互
									var params = {"ids":ids};
									$.post("/item/delete2",params,function(data){
										if(data.status == 200){
											$.messager.alert('提示','删除商品规格成功!',undefined,function(){
												$("#itemParamList").datagrid("reload");
											});									
										}else{
											alert("删除失败");
										}
									});
								}
							});
						}
					}
				],
				height: 400,
				columns: [
					[
						{
							field: 'id',
							title: 'ID',
							width: 60
						},{
							field: 'itemCatId',
							title: '类目ID',
							width: 60
						},{
							field: 'itemCatName',
							title: '类目名称',
							width: 100
						},{
							field: 'paramData',
							title: '规格',
							width: 300,
							formatter:formatItemParamData
						},{
							field: 'created',
							title: '创建时间',
							width: 130,
							formatter:TT.formateDateTime
						},{
							field: 'updated',
							title: '更新时间',
							width: 130,
							formatter:TT.formateDateTime
						}
					]
				]
			});
	function formatItemParamData(val,index){
		var json = JSON.parse(val);
		var array = [];
		$.each(json,function(i,e){
			array.push(e.group);
		})
		return array.join(",");
		
	}
	function getSelections(){
		var itemList = $("#itemParamList");
		var sels = itemList.datagrid("getSelections");
		var ids =[];
		for(var i in sels){
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}
</script>