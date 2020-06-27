package org.zwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbItemParamItemService;
import org.zwh.service.TbItemParamService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

@Controller
@RequestMapping("/item/param")
public class TbItemParamItemController {
	@Autowired
	private TbItemParamItemService tbItemParamItemService;
	
	@RequestMapping("/showParam/{itemId}")
	public String showparam(@PathVariable Long itemId,Model model) {
		String html = tbItemParamItemService.getTbItemParamByItemId(itemId);
		model.addAttribute("html",html);
		return "item-param";
	}
	
}
