package org.zwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbContentMapper;
import org.zwh.pojo.TbContent;
import org.zwh.pojo.TbContentExample;
import org.zwh.pojo.TbContentExample.Criteria;
import org.zwh.service.TbContentService;
import org.zwh.utils.EasyUIDataGridResult;

import org.zwh.utils.ExceptionUtil;
import org.zwh.utils.FjnyResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbContentServiceImpl implements TbContentService {
	
	@Autowired
	TbContentMapper tbcontentmapper;

	@Override
	public EasyUIDataGridResult getTbContentList(Long categoryId,Integer page, Integer rows) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbContent> list = tbcontentmapper.selectByExampleWithBLOBs(example);
		
	   PageInfo<TbContent> pageinfo	= new PageInfo<>(list);
		
		
		EasyUIDataGridResult easyUITreeNodeBean = new EasyUIDataGridResult(pageinfo.getTotal(),list);
		return easyUITreeNodeBean;
				
	}

	@Override
	public FjnyResult getTbContentdelete(Long ids) {
		try {
			tbcontentmapper.deleteByPrimaryKey(ids);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult getTbContentSave(TbContent contentAddForm) {
		try {
			tbcontentmapper.insert(contentAddForm);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult getTbContentEdit(TbContent contentEditForm) {
		try {
			tbcontentmapper.updateByPrimaryKeySelective(contentEditForm);
			return FjnyResult.ok();
		} catch (Exception e) {
			return FjnyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}


}
