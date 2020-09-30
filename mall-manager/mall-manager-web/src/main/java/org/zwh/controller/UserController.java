package org.zwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.pojo.TbUser;
import org.zwh.service.TbUserService;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "管理用户接口")
@Controller
@RequestMapping("/TbUser")
public class UserController {
	@Autowired TbUserService tbUserService;	
	
	@ApiOperation(value = "根据管理员id查询用户")
	@ApiImplicitParam(name = "roleId",value = "管理员id",dataType = "Long",paramType = "query")
	@RequestMapping(value = "/query",method=RequestMethod.POST)
	@ResponseBody
	public List<TbUser> queryUserList(
			@RequestParam(value="roleId",defaultValue = "0")Long roleId ) {
		List<TbUser> list = tbUserService.getTbUSerList(roleId);
		return list;
	}
	
	@ApiOperation(value = "根据用户id修改用户状态")
	@ApiImplicitParam(name = "ids",value = "用户id",dataType = "Long",paramType = "query")
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult updateTbUserStatus(@RequestParam("ids") List<Long> ids) {
		return tbUserService.putDownTbUser(ids);
	}
}
