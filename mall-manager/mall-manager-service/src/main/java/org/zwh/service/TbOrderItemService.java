package org.zwh.service;

import java.util.List;

import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbOrderItemService {

	EasyUIDataGridResult getTbOrderList(Integer page, Integer rows);

	FjnyResult tbOrderItemStatus1(List<String> ids);

	FjnyResult tbOrderItemStatus2(List<String> ids);

	FjnyResult tbOrderItemStatus3(List<String> ids);

	FjnyResult tbOrderItemStatus4(List<String> ids);

}
