package org.zwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbOrderItemMapper;
import org.zwh.mapper.TbOrderMapper;
import org.zwh.mapper.TbOrderShippingMapper;
import org.zwh.mapper.TbUserMapper;
import org.zwh.pojo.TbOrder;
import org.zwh.pojo.TbOrderExample;
import org.zwh.pojo.TbOrderItem;
import org.zwh.pojo.TbOrderItemExample;
import org.zwh.pojo.TbOrderShipping;
import org.zwh.pojo.TbUser;
import org.zwh.pojo.TbUserExample;
import org.zwh.service.TbOrderService;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class TbOrderServiceImpl implements TbOrderService {
	@Autowired
	private TbOrderMapper tbOrderMapper;
	@Autowired
	private TbOrderItemMapper  tbOrderItemMapper ;
	@Autowired
	private TbOrderShippingMapper  tbOrderShippingMapper ;
	
	@Override
	public EasyUIDataGridResult getTbOrderList(Integer page, Integer rows) {
		//分页插件
		PageHelper.startPage(page, rows);
		TbOrderExample example = new TbOrderExample();
		example.createCriteria();
		List<TbOrder> list = tbOrderMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		PageInfo<TbOrder> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
		return easyUIDataGridResult;
	}
	
	@Override
	public List<TbOrderItem> getOrderItemList(String orderID) {
		TbOrderItemExample tbOrderItemExample = new TbOrderItemExample();
		tbOrderItemExample.createCriteria().andOrderIdEqualTo(orderID);
		return tbOrderItemMapper.selectByExample(tbOrderItemExample);
	}

	@Override
	public TbOrderShipping getOrderShipping(String orderID) {
		TbOrderShipping shipping = tbOrderShippingMapper.selectByPrimaryKey(orderID);
		return shipping;
	}
	
	@Override
	public FjnyResult tbOrderStatus1(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(1);;
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus2(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(2);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus3(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(3);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus4(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(4);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus5(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(5);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus6(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(6);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus7(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(7);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult tbOrderStatus8(List<String> ids) {
		try {
			TbOrder record = new TbOrder();
			record.setStatus(8);
			TbOrderExample example = new TbOrderExample();
			example.createCriteria().andOrderIdIn(ids);
			tbOrderMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			return FjnyResult.build(500, "订单更新失败");
		}
	
		return FjnyResult.ok();
	}

}
