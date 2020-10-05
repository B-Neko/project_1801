package org.zwh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbUserService {

//	List<TbUser> getTbUSerList(Long roleId);

	FjnyResult putDownTbUser(List<Long> ids);

	EasyUIDataGridResult getTbUserList(Integer page, Integer rows);

	FjnyResult updateTbUser(List<Long> ids);
	
	FjnyResult checkLogin(HttpServletRequest request,String username,String password);
	
}
