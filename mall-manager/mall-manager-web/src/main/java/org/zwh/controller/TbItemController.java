package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.pojo.TbItem;
import org.zwh.service.TbItemCatService;
import org.zwh.service.TbItemDescService;
import org.zwh.service.TbItemService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "商品接口")
@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	public TbItemService tbItemService;
	@Autowired
	public TbItemCatService tbItemCatService;
	@Autowired
	private TbItemDescService tbItemDescService;

	@ApiOperation(value = "显示商品列表")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer",defaultValue = "1",paramType="query"),
          @ApiImplicitParam(name = "rows",value = "显示个数",dataType = "Integer",defaultValue = "10",paramType="query")
	})
	@RequestMapping(value = "/getItem",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getTbItemList(@RequestParam(defaultValue = "1") 
	Integer page
			,@RequestParam(defaultValue = "10") Integer rows){
		return tbItemService.getTbItemList(page,rows);
	}

	@ApiOperation(value = "保存商品信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tbItem",value = "商品实体类",paramType="query"),
        @ApiImplicitParam(name = "desc",value = "商品描述",dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "itemParams",value = "商品规格",dataType = "String",paramType="query")
	})
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult saveItem(TbItem tbItem,String desc,String itemParams){
		tbItemService.saveItem(tbItem,desc,itemParams);
		return FjnyResult.ok();
	}
	
	@ApiIgnore()
	@RequestMapping("/cat/list")
	@ResponseBody
	public List<EasyUITreeNodeBean> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentId) {
		System.out.println("parentId:" + parentId);
		return tbItemCatService.getTbItemCatList(parentId);
	}
	
	@ApiOperation(value = "根据id查看商品描述")
	@ApiImplicitParam(name = "id",value = "商品id",dataType = "Long",paramType = "path")
	@RequestMapping(value = "/query/item-desc/{id}",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult getTbItemDesc(@PathVariable Long id) {
		return tbItemDescService.getTbResultDesc(id);
	}
	
	@ApiOperation(value = "编辑修改商品信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tbItem",value = "商品实体类",paramType = "query"),
		@ApiImplicitParam(name = "desc",value = "商品描述",dataType = "String",paramType = "query")
	})
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult updateTbItem(TbItem tbItem,String desc) {
		return tbItemService.updateItem(tbItem, desc);
	}
	
	@ApiOperation(value = "根据id删除商品")
	@ApiImplicitParam(name = "ids",value = "商品id集合",dataType = "List",paramType = "query")
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult deleteTbItem(@RequestParam("ids") List<Long> ids) {
		return tbItemService.deleteTbItem(ids);
	}
	
	@ApiOperation(value = "根据id上架商品")
	@ApiImplicitParam(name = "ids",value = "商品id集合",dataType = "List",paramType = "query")
	@RequestMapping(value = "/putUp",method=RequestMethod.GET)
	@ResponseBody
	public FjnyResult putUpTbItem(@RequestParam("ids") List<Long> ids) {
		return tbItemService.putUpTbItem(ids);
	}
	
	@ApiOperation(value = "根据id下架商品")
	@ApiImplicitParam(name = "ids",value = "商品id集合",dataType = "List",paramType = "query")
	@RequestMapping(value = "/putDown",method=RequestMethod.GET)
	@ResponseBody
	public FjnyResult putDownTbItem(@RequestParam("ids") List<Long> ids) {
		return tbItemService.putDownTbItem(ids);
	}

}
