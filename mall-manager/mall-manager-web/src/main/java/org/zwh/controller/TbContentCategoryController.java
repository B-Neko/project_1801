package org.zwh.controller;

import java.util.List;

import org.zwh.service.TbContentCategoryService;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.FjnyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content/category")
public class TbContentCategoryController {
	
	@Autowired
	private TbContentCategoryService tbContentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNodeBean> getTbContentCategoryList(@RequestParam(value="id",defaultValue = "0")
	long parentId){
		List<EasyUITreeNodeBean> list = tbContentCategoryService.getTbContentCategoryList(parentId);
		return list;
		//15分
	}
	
	
	@RequestMapping("/create")
	@ResponseBody
	public FjnyResult createNode(@RequestParam(value="parentId") Long parentId, @RequestParam(value="name")String name) {
		return tbContentCategoryService.createNode(parentId,name);
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public FjnyResult updateNodeName(@RequestParam(value="id")Long id,@RequestParam(value="name")String name) {
		return tbContentCategoryService.updateNodeName(id,name);
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public FjnyResult deleteNode(@RequestParam(value="id")Long id) {
		return tbContentCategoryService.deleteNode(id);
	}
	
}
