package org.zwh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbContentCategoryMapper;
import org.zwh.pojo.TbContentCategory;
import org.zwh.pojo.TbContentCategoryExample;
import org.zwh.pojo.TbContentCategoryExample.Criteria;
import org.zwh.service.TbContentCategoryService;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.ExceptionUtil;
import org.zwh.utils.FjnyResult;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	
	@Override
	public List<EasyUITreeNodeBean> getTbContentCategoryList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> tbContentCategoryList= tbContentCategoryMapper.selectByExample(example);
		//重新拼成对应格式
		List<EasyUITreeNodeBean> lists = new ArrayList<EasyUITreeNodeBean>();
		
		for (TbContentCategory tbContentCat : tbContentCategoryList) {
			EasyUITreeNodeBean e = new EasyUITreeNodeBean(tbContentCat.getId(),
					tbContentCat.getName(),
					tbContentCat.getIsParent() ? "closed":"open");
					lists.add(e);	 
		}
		return lists;
	}

	@Override
	public FjnyResult createNode(Long parentId, String name) {
		try {
			TbContentCategory t = new TbContentCategory();
			t.setParentId(parentId);
			t.setName(name);
			t.setSortOrder(1);
			t.setIsParent(false);
			t.setCreated(new Date());
			t.setUpdated(new Date());
			tbContentCategoryMapper.insertSelective(t);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult updateNodeName(Long id, String name) {
		try {
			TbContentCategory record = new TbContentCategory();
			record.setId(id);
			record.setName(name);
			record.setUpdated(new Date());
			tbContentCategoryMapper.updateByPrimaryKeySelective(record);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult deleteNode(Long id) {
		try {
			tbContentCategoryMapper.deleteByPrimaryKey(id);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	


	

}
