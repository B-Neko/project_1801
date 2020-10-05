<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<style type="text/css">
.form-item {
	margin-bottom: 15px;
	width: 100%;
	float: left;
}

.form-item>label {
	min-width: 72px;
	display: inline-block;
}

.form-item input, select {
	width: 170px;
}
</style>
<div class="super-theme-example">
	<table id="orderItemList">
	</table>  
	<div> 物流信息: </div>
	<form id="ffOrderShipping">   
    <div>   
        <label for="receiverName">收件人:</label>   
        <input  class="easyui-validatebox" type="text" name="receiverName" data-options="required:true" />   
    </div>   
    <div>   
        <label for="receiverMobile">移动电话:</label>   
        <input class="easyui-validatebox" type="text" name="receiverMobile" data-options="required:true" />   
    </div>  
     <div>   
        <label for="receiverCity">城市:</label>   
        <input  class="easyui-validatebox" type="text" name="receiverCity" data-options="required:true" />   
    </div>  
</form>  
	
</div>