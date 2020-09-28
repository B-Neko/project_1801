package org.zwh.controller;

import java.util.List;

import org.zwh.service.TbContentCategoryService;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Api(tags = "内容分类接口")
@Controller
@RequestMapping("/content/category")
public class TbContentCategoryController {
	
	@Autowired
	private TbContentCategoryService tbContentCategoryService;
	//分类列表
	@ApiOperation(value = "分类列表")
	@ApiImplicitParam(name = "parentId",value = "分类父Id",dataType = "Long",defaultValue = "0",paramType = "query")
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNodeBean> getTbContentCategoryList(@RequestParam(value="id",defaultValue = "0")
	long parentId){
		List<EasyUITreeNodeBean> list = tbContentCategoryService.getTbContentCategoryList(parentId);
		return list;
		//15分
	}
	//创建分类
	@ApiOperation(value = "创建分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name="parenId",value = "分类父id",dataType = "Long",paramType = "query"),
		@ApiImplicitParam(name="name",value = "分类名称",dataType = "String",paramType = "query")
	})
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult createNode(@RequestParam(value="parentId") Long parentId, @RequestParam(value="name")String name) {
		return tbContentCategoryService.createNode(parentId,name);
	}
	//更新分类
	@ApiImplicitParams({
		@ApiImplicitParam(name="parenId",value = "分类id",dataType = "Long",paramType = "query"),
		@ApiImplicitParam(name="name",value = "分类名称",dataType = "String",paramType = "query")
	})
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult updateNodeName(@RequestParam(value="id")Long id,@RequestParam(value="name")String name) {
		return tbContentCategoryService.updateNodeName(id,name);
	}
	//删除个别分类
	@ApiOperation(value = "删除个别分类")
	@ApiImplicitParam(name = "id",value = "分类id",dataType = "Long",paramType = "query")
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult deleteNode(@RequestParam(value="id")Long id) {
		return tbContentCategoryService.deleteNode(id);
	}	
}
