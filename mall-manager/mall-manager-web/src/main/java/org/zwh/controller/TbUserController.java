package org.zwh.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zwh.service.TbUserService;
import org.zwh.utils.FjnyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@RequestMapping("/User")
public class TbUserController {
	@Autowired TbUserService tbUserService;	
	
	@RequestMapping(value = "/dologin",method = RequestMethod.POST)
	@ResponseBody
	public FjnyResult checkLogin(HttpServletRequest request,String username,String password) {
		System.out.println("请求到着了" + username + password);
		FjnyResult result =tbUserService.checkLogin(request,username, password);
		return result;
	}
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("USER_INFO");
		request.getSession().setAttribute("USER_INFO", "null");
		//request.getSession().setAttribute("USR_INFO", null);
		return "/login";
	}
}
