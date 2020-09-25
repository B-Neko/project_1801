package org.zwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.pojo.TbContent;
import org.zwh.service.TbContentService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

@Controller
@RequestMapping("/content/query")
public class TbContentController {

	@Autowired
	private TbContentService tbContentService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getTbContentList(Long categoryId,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "10")Integer rows){
		return tbContentService.getTbContentList(categoryId,page,rows);
	}
	
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public FjnyResult getTbContentDelete(@RequestParam(value="ids")Long ids){
		return tbContentService.getTbContentdelete(ids);
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public FjnyResult getTbContentSave(TbContent contentAddForm){
		return tbContentService.getTbContentSave(contentAddForm);
	}
	
	
	@RequestMapping("/edit")
	@ResponseBody
	public FjnyResult getTbContentEdit(TbContent contentEditForm){
		return tbContentService.getTbContentEdit(contentEditForm);
	}
	
}
