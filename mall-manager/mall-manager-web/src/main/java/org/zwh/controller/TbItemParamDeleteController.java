package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbItemParamService;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Api(tags = "商品类目中删除方法接口")
@Controller
@RequestMapping("/item")
public class TbItemParamDeleteController {

	@Autowired
	private TbItemParamService TbItemParamService;
	
	@ApiOperation(value = "删除规格")
	@ApiImplicitParam(name = "ids",value = "规格id集合",dataType = "List",paramType = "query")
	@RequestMapping(value = "/delete2",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult deleteTbItem(@RequestParam("ids") List<Long> ids) {
		
		System.out.println(ids);
		return TbItemParamService.deleteItemParam(ids);
	}
}
