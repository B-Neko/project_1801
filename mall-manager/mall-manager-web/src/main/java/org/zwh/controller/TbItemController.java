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

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	public TbItemService tbItemService;
	@Autowired
	public TbItemCatService tbItemCatService;
	@Autowired
	private TbItemDescService tbItemDescService;

	
	@RequestMapping("/getItem")
	@ResponseBody
	public EasyUIDataGridResult getTbItemList(@RequestParam(defaultValue = "1") 
	Integer page
			,@RequestParam(defaultValue = "10") Integer rows){
		return tbItemService.getTbItemList(page,rows);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult saveItem(TbItem tbItem,String desc,String itemParams){
		tbItemService.saveItem(tbItem,desc,itemParams);
		return FjnyResult.ok();
	}
	
	@RequestMapping("/cat/list")
	@ResponseBody
	public List<EasyUITreeNodeBean> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentId) {
		System.out.println("parentId:" + parentId);
		return tbItemCatService.getTbItemCatList(parentId);
	}
	
	@RequestMapping("/query/item-desc/{id}")
	@ResponseBody
	public FjnyResult getTbItemDesc(@PathVariable Long id) {
		return tbItemDescService.getTbResultDesc(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public FjnyResult updateTbItem(TbItem tbItem,String desc) {
		return tbItemService.updateItem(tbItem, desc);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public FjnyResult deleteTbItem(@RequestParam("ids") List<Long> ids) {
		return tbItemService.deleteTbItem(ids);
	}
	
	@RequestMapping("/putUp")
	@ResponseBody
	public FjnyResult putUpTbItem(@RequestParam("ids") List<Long> ids) {

		return tbItemService.putUpTbItem(ids);
	}
	
	@RequestMapping("/putDown")
	@ResponseBody
	public FjnyResult putDownTbItem(@RequestParam("ids") List<Long> ids) {

		return tbItemService.putDownTbItem(ids);
	}

}
