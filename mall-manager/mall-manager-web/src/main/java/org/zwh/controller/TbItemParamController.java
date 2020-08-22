package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.pojo.TbItem;
import org.zwh.service.TbItemParamService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

@Controller
@RequestMapping("/item/param")
public class TbItemParamController {
	@Autowired
	private TbItemParamService tbItemParamService;
	//查询规格
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return tbItemParamService.getItemParamList(page, rows);
		
	}	
	//查询类目是否存在规格模板
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public FjnyResult checkParam(@PathVariable Long itemCatId) {		
		return tbItemParamService.checkParam(itemCatId);
	}
	//保存添加的类目规格模板
	@RequestMapping("/save/{itemCatId}")
	@ResponseBody
	public FjnyResult addItemParam(@PathVariable Long itemCatId,String paramData) {
		return tbItemParamService.addItemParam(itemCatId,paramData);
	}
		
	//删除规格
	@RequestMapping("/delete")
	@ResponseBody
	public FjnyResult deleteItemParam(@RequestParam(value = "ids") List<Long> ids) {
		System.out.println("删除商品ids:"  + ids);
		return tbItemParamService.deleteItemParam(ids);
	}
	
	//查询编辑的信息
	@RequestMapping("/query/itemparam-desc/{id}")
	@ResponseBody
	public FjnyResult editItemParam(@PathVariable Long id) {
		System.out.println("需要更改的商品的id"+ id);
		return tbItemParamService.editItemParam(id);
	}
	
	//更新商品规格
	@RequestMapping("/update/{cid}")
	@ResponseBody
	public FjnyResult updateItemParam(@PathVariable Long cid) {
		System.out.println("需要更改商品规格的id"+ cid);
		return tbItemParamService.updateParamItem(cid);
	}
	
}
