package org.zwh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbItemCatMapper;
import org.zwh.pojo.TbItemCat;
import org.zwh.pojo.TbItemCatExample;
import org.zwh.pojo.TbItemCatExample.Criteria;

import org.zwh.service.TbItemCatService;
import org.zwh.utils.EasyUITreeNodeBean;


@Service
public class TbItemCatServiceImpl implements TbItemCatService {

	@Autowired
	TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EasyUITreeNodeBean> getTbItemCatList(Long parentId) {
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> tbItemCatList=tbItemCatMapper.selectByExample(example);
		List<EasyUITreeNodeBean> list=new ArrayList<EasyUITreeNodeBean>();
		for (TbItemCat tbItemCat : tbItemCatList) {
			EasyUITreeNodeBean node=new EasyUITreeNodeBean();
			node.setId(tbItemCat.getId());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			node.setText(tbItemCat.getName());
			list.add(node);
		}
		return list;
	}

}
