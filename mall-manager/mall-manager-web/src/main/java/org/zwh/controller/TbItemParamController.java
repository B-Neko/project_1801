package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbItemParamService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "商品规格接口")
@Controller
@RequestMapping("/item/param")
public class TbItemParamController {
	@Autowired
	private TbItemParamService tbItemParamService;
	//查询规格
	@ApiOperation(value = "查询规格")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer",defaultValue = "1",paramType="query"),
          @ApiImplicitParam(name = "rows",value = "显示个数",dataType = "Integer",defaultValue = "10",paramType="query")
	})
	@RequestMapping(value = "/list",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return tbItemParamService.getItemParamList(page, rows);
		
	}	
	//查询类目是否存在规格模板
	@ApiOperation(value = "查询类目是否存在规格模板")
	@ApiImplicitParam(name = "itemCatId",value = "规格id",dataType = "Long",paramType = "path")
	@RequestMapping(value = "/query/itemcatid/{itemCatId}",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult checkParam(@PathVariable Long itemCatId) {		
		return tbItemParamService.checkParam(itemCatId);
	}
	//保存添加的类目规格模板
	@ApiOperation(value = "保存添加的类目规格模板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "itemCatId",value = "规格id",dataType = "Long",paramType = "path"),
		@ApiImplicitParam(name = "paramData",value="类目规格",dataType = "String")
	})
	@RequestMapping(value = "/save/{itemCatId}",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult addItemParam(@PathVariable Long itemCatId,String paramData) {
		return tbItemParamService.addItemParam(itemCatId,paramData);
	}
	//删除规格	
	@ApiOperation(value = "删除规格")
	@ApiImplicitParam(name = "ids",value = "规格id集合",dataType = "List",paramType = "query")
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult deleteItemParam(@RequestParam(value = "ids") List<Long> ids) {
		System.out.println("删除商品ids:"  + ids);
		return tbItemParamService.deleteItemParam(ids);
	}
	//查询编辑的信息
	@ApiOperation(value = "查询编辑的信息")
	@ApiImplicitParam(name = "id",value = "商品id",dataType = "Long",paramType = "path")
	@RequestMapping(value = "/query/itemparam-desc/{id}",method=RequestMethod.GET)
	@ResponseBody
	public FjnyResult editItemParam(@PathVariable Long id) {
		System.out.println("需要更改的商品的id"+ id);
		return tbItemParamService.editItemParam(id);
	}
	//更新商品规格
	@ApiOperation(value = "更新商品规格")
	@ApiImplicitParam(name = "id",value = "商品id",dataType = "Long",paramType = "path")
	@RequestMapping(value = "/update/{cid}",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult updateItemParam(@PathVariable Long cid) {
		System.out.println("需要更改商品规格的id"+ cid);
		return tbItemParamService.updateParamItem(cid);
	}
	
}
