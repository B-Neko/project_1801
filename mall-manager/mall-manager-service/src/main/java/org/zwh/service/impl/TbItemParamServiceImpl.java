package org.zwh.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbItemCatMapper;
import org.zwh.mapper.TbItemParamMapper;
import org.zwh.pojo.TbItem;
import org.zwh.pojo.TbItemCat;
import org.zwh.pojo.TbItemDesc;
import org.zwh.pojo.TbItemParam;
import org.zwh.pojo.TbItemParamExample;
import org.zwh.pojo.TbItemParamExample.Criteria;
import org.zwh.pojo.TbItemParamItem;
import org.zwh.service.TbItemParamService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.ExceptionUtil;
import org.zwh.utils.FjnyResult;
import org.zwh.utils.JsonUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class TbItemParamServiceImpl implements TbItemParamService {
	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) {
		TbItemParamExample example = new TbItemParamExample();
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		for (TbItemParam tbItemParam : list) {
			if(null!= tbItemParam.getItemCatId()) {
				String tbItemCatName = getItemCatName(tbItemParam.getItemCatId());
				tbItemParam.setItemCatName(tbItemCatName);
			}
		}
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult(total,list);
		return dataGrid;
	}
	public String getItemCatName(Long cid) {
		
		TbItemCat tbItemCat = tbItemCatMapper.selectByPrimaryKey(cid);
		return tbItemCat.getName();
	}
	@Override
	public FjnyResult checkParam(Long itemCatId) {
		try {
			TbItemParamExample example = new TbItemParamExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andItemCatIdEqualTo(itemCatId);
			List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
			if(null == list || list.isEmpty()) {
				return FjnyResult.ok();
			}
			return FjnyResult.ok(list.get(0));
		}catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	@Override
	public FjnyResult addItemParam(Long itemCatId, String paramData) {
		try {
			TbItemParam record = new TbItemParam();
			record.setItemCatId(itemCatId);
			record.setParamData(paramData);
			record.setCreated(new Date());
			record.setUpdated(new Date());
			tbItemParamMapper.insert(record);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}

	@Override
	public FjnyResult deleteItemParam(List<Long> ids) {
		try {
			TbItemParamExample example = new TbItemParamExample();
			example.createCriteria().andIdIn(ids);
			tbItemParamMapper.deleteByExample(example);
		} catch (Exception e) {
			return FjnyResult.build(500, "删除失败");
		}
		return FjnyResult.ok();
	}
	
	
	@Override
	public FjnyResult editItemParam(Long id) {
		// TODO Auto-generated method stub
		TbItemParam selectByPrimaryKey = tbItemParamMapper.selectByPrimaryKey(id);
		return FjnyResult.ok(selectByPrimaryKey);
	}
	@Override
	public FjnyResult updateParamItem(long cid) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
