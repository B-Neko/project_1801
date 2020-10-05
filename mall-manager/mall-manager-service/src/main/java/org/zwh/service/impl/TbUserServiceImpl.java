package org.zwh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.FjnyResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbUserServiceImpl implements TbUserService {
	@Autowired
	private TbUserMapper tbUserMapper;

//	@Override
//	public List<TbUser> getTbUSerList(Long roleId) {
//		TbUserExample example = new TbUserExample();
//		Criteria criteria=example.createCriteria();
//		criteria.andRoleIdEqualTo(roleId);
//		List<TbUser> tbUserList = tbUserMapper.selectByExample(example);
//		List<TbUser> list=new ArrayList<TbUser>();
//		for (TbUser TbUser : tbUserList) {
//			TbUser tbUser=new TbUser();
//			tbUser.setId(TbUser.getId());
//			tbUser.setUsername(tbUser.getUsername());
//			tbUser.setStatus(TbUser.getStatus());;
//			list.add(tbUser);
//		}
//		return list;
//	}


	@Override
	public EasyUIDataGridResult getTbUserList(Integer page, Integer rows) {
				//分页插件
				PageHelper.startPage(page, rows);
				TbUserExample example = new TbUserExample();
				example.createCriteria();
				List<TbUser> list = tbUserMapper.selectByExample(example);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				PageInfo<TbUser> pageInfo = new PageInfo<>(list);
				long total = pageInfo.getTotal();
				EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
				return easyUIDataGridResult;
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
	
	@Override
	public FjnyResult updateTbUser(List<Long> ids) {
		try {
			TbUser record = new TbUser();
			record.setStatus(1);
			TbUserExample example = new TbUserExample();
			example.createCriteria().andIdIn(ids);
			tbUserMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "用户更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult checkLogin(HttpServletRequest request,String username, String password) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		//criteria.andUserType
		List<TbUser> list = tbUserMapper.selectByExample(example);
		System.out.println(list);
		if (list.isEmpty()) {
			return FjnyResult.build(500, "账号密码错误");
		}
		request.getSession().setAttribute("USER_INFO", list.get(0));
		return FjnyResult.ok(list.get(0));
	}

}
