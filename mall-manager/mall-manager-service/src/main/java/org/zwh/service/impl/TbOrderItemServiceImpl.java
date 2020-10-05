package org.zwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbOrderItemMapper;
import org.zwh.mapper.TbOrderMapper;
import org.zwh.mapper.TbUserMapper;
import org.zwh.pojo.TbOrder;
import org.zwh.pojo.TbOrderExample;
import org.zwh.pojo.TbOrderItem;
import org.zwh.pojo.TbOrderItemExample;
import org.zwh.pojo.TbUser;
import org.zwh.pojo.TbUserExample;
import org.zwh.service.TbOrderItemService;
import org.zwh.service.TbOrderService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class TbOrderItemServiceImpl implements TbOrderItemService {
	@Autowired
	private TbOrderItemMapper tbOrderItemMapper;
	
	@Override
	public EasyUIDataGridResult getTbOrderList(Integer page, Integer rows) {
		//分页插件
		PageHelper.startPage(page, rows);
		TbOrderItemExample example = new TbOrderItemExample();
		example.createCriteria();
		List<TbOrderItem> list = tbOrderItemMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		PageInfo<TbOrderItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
		return easyUIDataGridResult;
	}

	@Override
	public FjnyResult tbOrderItemStatus1(List<String> ids) {
		try {
			TbOrderItem record = new TbOrderItem();
			record.setStatus(0);;
			TbOrderItemExample example = new TbOrderItemExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderItemMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderItemStatus2(List<String> ids) {
		try {
			TbOrderItem record = new TbOrderItem();
			record.setStatus(1);;
			TbOrderItemExample example = new TbOrderItemExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderItemMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderItemStatus3(List<String> ids) {
		try {
			TbOrderItem record = new TbOrderItem();
			record.setStatus(2);;
			TbOrderItemExample example = new TbOrderItemExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderItemMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderItemStatus4(List<String> ids) {
		try {
			TbOrderItem record = new TbOrderItem();
			record.setStatus(3);;
			TbOrderItemExample example = new TbOrderItemExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderItemMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

}
