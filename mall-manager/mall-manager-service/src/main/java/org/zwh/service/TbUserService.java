package org.zwh.service;

import java.util.List;

import org.zwh.pojo.TbUser;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbUserService {

//	List<TbUser> getTbUSerList(Long roleId);

	FjnyResult putDownTbUser(List<Long> ids);

	EasyUIDataGridResult getTbUserList(Integer page, Integer rows);

	FjnyResult updateTbUser(List<Long> ids);
	
}
