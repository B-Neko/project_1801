<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 350px;">
		<table id="dgTbUser"></table>
	</div>
	<br/>
	<br/>
</div>
	<script type="text/javascript">
	
		$('#dgTbUser').datagrid({
				url: 'TbUser/list',
				fit: true,
				pagination: true,
				fitColumns: true,
				toolbar: [{
					text:'解除封号',
					iconCls : 'fa fa-hand-o-up',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个用户");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要解除ID为'+ids+'用户吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var up = {"ids":ids,"status":1};
								$.post("${pageContext.request.contextPath}/TbUser/update",up,function(data){
									if(data.status == 200){
										$.messager.alert('提示','解除成功!',undefined,function(){
											$("#dgTbUser").datagrid("reload");
										});									
									}else{
										alert("解除失败");
									}
								});
							}
						});
					}
				},{
					text:'封号',
					iconCls : 'fa fa-hand-o-down',
					handler:function(){
						var ids = getSelections();
						if(ids.length == 0){
							$.messager.alert('提示',"必须选择一个或多个用户");
							return;
						}
						//提示是否修改状态
						$.messager.confirm('确认', '您确认想要禁用ID为'+ids+'用户吗?', function(r) {
							if(r) {
								//进行post跟服务端交互
								var down = {"ids":ids,"status":2};
								$.post("${pageContext.request.contextPath}/TbUser/putdown",down,function(data){
									if(data.status == 200){
										$.messager.alert('提示','禁用成功!',undefined,function(){
											$("#dgTbUser").datagrid("reload");
										});									
									}else{
										alert("禁用失败");
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
						title: '用户ID',
						width: 60,
						align:'center'
					}, {
						field: 'username',
						title: '用户名',
						width: 100,
						align:'center'
					}, {
						field: 'phone',
						title: '手机号',
						width: 100,
						align:'center'
					}, {
						field: 'email',
						title: '邮箱',
						width: 100,
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
					, {
						field:'sex',
						title:'性别',
						width:100,
						formatter:TT.formatUserSex,
						align:'center'
					}, {
						field:'status',
						title:'状态(1.正常,2.禁用)',
						width:100,
						formatter:TT.formatUserStatus,
						align:'center'
					}]
				]
			});
		function getSelections(){
			var itemList = $("#dgTbUser");
			var sels = itemList.datagrid("getSelections");
			var ids =[];
			for(var i in sels){
				ids.push(sels[i].id);
			}
			ids = ids.join(",");
			return ids;
		}
</script>