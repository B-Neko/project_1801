<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<!--easyui-->
<script src="${pageContext.request.contextPath}/easyui/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript" charset="utf-8"></script>
<!--开发-->
<!--<link rel="stylesheet" href="../easyui/themes/gray/easyui.css">
		<link rel="stylesheet" href="css/font-awesome.min.css">
		<link rel="stylesheet" href="css/superBlue.css" id="themeCss">
		<script src="${pageContext.request.contextPath}/js/super.js" type="text/javascript" charset="utf-8"></script>-->
<!--测试dist-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fjny.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/superBlue.css" id="themeCss" />
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/easyui/themes/super/super.js"></script>
<script src="${pageContext.request.contextPath}/js/superDemo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名: <input name="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px"/>
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;&nbsp;码: <input name="password" class="easyui-textbox" type="password" style="width:200px;height:32px" data-options="" />
	            </div>
	        </div>
	        <div>
	         <!-- <input type='button' value='登录' id="login" class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 50px" >  -->
	            <a id="login" class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 50px">登录</a> 
	        </div>
       	</div>
    </div>
    
    <script type="text/javascript">
    /* var n = $("[name=username]").val();
    var p = $("[name=password]").val();
    console.log("n" + n);
    console.log("p" + p); */
    	$("#login").click(function(){
    		$.post("${pageContext.request.contextPath}/User/dologin",
    		{
    		 username:$("[name=username]").val(),
    		 password:$("[name=password]").val(),
    		},
    		function(data,status){
    			console.log(data);
    			console.log(status);
    			if(data.status == 200){
    				window.location.href="${pageContext.request.contextPath}/index";
    			}else{
    				$.messager.alert('错误',"用户名密码不正确！");
    			}
    		});	
    	});
    </script>
</body>
</html>