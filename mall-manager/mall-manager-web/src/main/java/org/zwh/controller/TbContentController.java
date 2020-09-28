package org.zwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.pojo.TbContent;
import org.zwh.service.TbContentService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api(tags = "内容接口")
@Controller
@RequestMapping("/content/query")
public class TbContentController {

	@Autowired
	private TbContentService tbContentService;
	//显示内容分类列表
	@ApiOperation(value = "显示内容列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "categoryId",value = "分类Id",dataType = "Long",paramType = "query"),
		@ApiImplicitParam(name = "page",value = "内容列表当前页",dataType = "Integer",defaultValue = "1",paramType = "query"),
		@ApiImplicitParam(name = "rows",value = "内容列表显示个数",dataType = "Integer",defaultValue = "10",paramType = "query")
	})
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getTbContentList(Long categoryId,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "10")Integer rows){
		return tbContentService.getTbContentList(categoryId,page,rows);
	}
	//根据id删除分类
	@ApiOperation(value = "根据id删除内容")
	@ApiImplicitParam(name = "ids",value = "内容ID",dataType = "Long",paramType = "query")
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult getTbContentDelete(@RequestParam(value="ids")Long ids){
		return tbContentService.getTbContentdelete(ids);
	}
	//保存内容
	@ApiOperation(value = "保存内容")
	@ApiImplicitParam(name = "contentAddForm",value = "内容实体类")
	@RequestMapping(value = "/save",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult getTbContentSave(TbContent contentAddForm){
		return tbContentService.getTbContentSave(contentAddForm);
	}
	//编辑内容
	@ApiOperation(value = "编辑内容")
	@ApiImplicitParam(name = "contentEditForm",value = "内容实体类")
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult getTbContentEdit(TbContent contentEditForm){
		return tbContentService.getTbContentEdit(contentEditForm);
	}
}
