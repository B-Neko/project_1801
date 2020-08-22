package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbItemParamService;
import org.zwh.utils.FjnyResult;

@Controller
@RequestMapping("/item")
public class TbItemParamDeleteController {

	@Autowired
	private TbItemParamService TbItemParamService;
	
	@RequestMapping("/delete2")
	@ResponseBody
	public FjnyResult deleteTbItem(@RequestParam("ids") List<Long> ids) {
		
		System.out.println(ids);
		return TbItemParamService.deleteItemParam(ids);
	}
}
