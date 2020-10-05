package org.zwh.service;

import java.util.List;

import org.springframework.beans.factory.parsing.AliasDefinition;
import org.zwh.pojo.TbOrderItem;
import org.zwh.pojo.TbOrderShipping;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbOrderService {

	EasyUIDataGridResult getTbOrderList(Integer page, Integer rows);
	
	List<TbOrderItem> getOrderItemList(String orderID);
	
	TbOrderShipping getOrderShipping(String orderID);
	

	FjnyResult tbOrderStatus1(List<String> ids);

	FjnyResult tbOrderStatus2(List<String> ids);

	FjnyResult tbOrderStatus3(List<String> ids);

	FjnyResult tbOrderStatus4(List<String> ids);

	FjnyResult tbOrderStatus5(List<String> ids);

	FjnyResult tbOrderStatus6(List<String> ids);

	FjnyResult tbOrderStatus7(List<String> ids);

	FjnyResult tbOrderStatus8(List<String> ids);

}
