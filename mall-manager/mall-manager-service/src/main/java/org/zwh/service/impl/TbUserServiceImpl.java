package org.zwh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbUserMapper;
import org.zwh.pojo.TbItem;
import org.zwh.pojo.TbItemCat;
import org.zwh.pojo.TbItemDesc;
import org.zwh.pojo.TbItemExample;
import org.zwh.pojo.TbUser;
import org.zwh.pojo.TbUserExample;
import org.zwh.pojo.TbUserExample.Criteria;
import org.zwh.service.TbUserService;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.FjnyResult;

@Service
public class TbUserServiceImpl implements TbUserService {
	@Autowired
	TbUserMapper tbUserMapper;

	@Override
	public List<TbUser> getTbUSerList(Long roleId) {
		TbUserExample example = new TbUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<TbUser> tbUserList = tbUserMapper.selectByExample(example);
		List<TbUser> list=new ArrayList<TbUser>();
		for (TbUser TbUser : tbUserList) {
			TbUser tbUser=new TbUser();
			tbUser.setId(TbUser.getId());
			tbUser.setUsername(tbUser.getUsername());
			tbUser.setStatus(TbUser.getStatus());;
			list.add(tbUser);
		}
		return list;
	}

	@Override
	public FjnyResult putDownTbUser(List<Long> ids) {
		try {
			TbUser record = new TbUser();
			record.setStatus(2);
			TbUserExample example = new TbUserExample();
			example.createCriteria().andIdIn(ids);
			tbUserMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "用户更新失败");
		}
	
		return FjnyResult.ok();
		
	}

}
