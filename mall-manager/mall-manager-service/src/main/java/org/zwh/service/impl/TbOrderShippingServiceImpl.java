package org.zwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbOrderShippingMapper;
import org.zwh.pojo.TbOrderShipping;
import org.zwh.pojo.TbOrderShippingExample;
import org.zwh.service.TbOrderShippingService;
import org.zwh.utils.EasyUIDataGridResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class TbOrderShippingServiceImpl implements TbOrderShippingService {
	@Autowired
	private TbOrderShippingMapper tbOrderShippingMapper;
	
	@Override
	public EasyUIDataGridResult getTbOrderShippingList(Integer page, Integer rows) {
		//分页插件
		PageHelper.startPage(page, rows);
		TbOrderShippingExample example = new TbOrderShippingExample();
		example.createCriteria();
		List<TbOrderShipping> list = tbOrderShippingMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		PageInfo<TbOrderShipping> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
		return easyUIDataGridResult;
	}

}
