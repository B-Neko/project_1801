package org.zwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbOrderService;
import org.zwh.service.TbOrderShippingService;
import org.zwh.utils.EasyUIDataGridResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/orderShipping")
public class TbOrderShippingController {
	@Autowired
	TbOrderShippingService tbOrderShippingService;
	
	@ApiOperation(value = "显示用户列表")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer",defaultValue = "1",paramType="query"),
          @ApiImplicitParam(name = "rows",value = "显示个数",dataType = "Integer",defaultValue = "10",paramType="query")
	})
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult getTbOrderShippingList(@RequestParam(defaultValue = "1") 
	Integer page
			,@RequestParam(defaultValue = "10") Integer rows){
		return tbOrderShippingService.getTbOrderShippingList(page,rows);
	}
}
