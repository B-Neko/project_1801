package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbOrderItemService;
import org.zwh.service.TbOrderService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/orderItem")
public class TbOrderItemController {
	@Autowired
	TbOrderItemService tbOrderItemService;
	
	@ApiOperation(value = "显示用户列表")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer",defaultValue = "1",paramType="query"),
          @ApiImplicitParam(name = "rows",value = "显示个数",dataType = "Integer",defaultValue = "10",paramType="query")
	})
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult getTbOrderItemList(@RequestParam(defaultValue = "1") 
	Integer page
			,@RequestParam(defaultValue = "10") Integer rows){
		return tbOrderItemService.getTbOrderList(page,rows);
	}
	
	//状态
		//1
		@ApiOperation(value = "根据订单id修改为状态1")
		@ApiImplicitParam(name = "ids",value = "订单id",dataType = "String",paramType = "query")
		@RequestMapping(value = "/status1",method=RequestMethod.POST)
		@ResponseBody
		public FjnyResult tbOrderStatus1(@RequestParam("ids") List<String> ids) {
			return tbOrderItemService.tbOrderItemStatus1(ids);
		}
		//2
		@ApiOperation(value = "根据订单id修改为状态2")
		@ApiImplicitParam(name = "ids",value = "订单id",dataType = "String",paramType = "query")
		@RequestMapping(value = "/status2",method=RequestMethod.POST)
		@ResponseBody
		public FjnyResult tbOrderStatus2(@RequestParam("ids") List<String> ids) {
			return tbOrderItemService.tbOrderItemStatus2(ids);
		}
		//3
		@ApiOperation(value = "根据订单id修改为状态3")
		@ApiImplicitParam(name = "ids",value = "订单id",dataType = "String",paramType = "query")
		@RequestMapping(value = "/status3",method=RequestMethod.POST)
		@ResponseBody
		public FjnyResult tbOrderStatus3(@RequestParam("ids") List<String> ids) {
			return tbOrderItemService.tbOrderItemStatus3(ids);
		}
		//4
		@ApiOperation(value = "根据订单id修改为状态4")
		@ApiImplicitParam(name = "ids",value = "订单id",dataType = "String",paramType = "query")
		@RequestMapping(value = "/status4",method=RequestMethod.POST)
		@ResponseBody
		public FjnyResult tbOrderStatus4(@RequestParam("ids") List<String> ids) {
			return tbOrderItemService.tbOrderItemStatus4(ids);
		}
}
