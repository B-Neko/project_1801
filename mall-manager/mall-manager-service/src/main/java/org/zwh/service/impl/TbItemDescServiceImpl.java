package org.zwh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbItemDescMapper;
import org.zwh.pojo.TbItemDesc;
import org.zwh.service.TbItemDescService;
import org.zwh.utils.FjnyResult;
@Service
public class TbItemDescServiceImpl implements TbItemDescService {
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Override
	public FjnyResult getTbResultDesc(Long itemId) {
		TbItemDesc itemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
		return FjnyResult.ok(itemDesc);
	}

}
