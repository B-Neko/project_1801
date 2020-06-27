package org.zwh.service;

import java.util.List;

import org.zwh.pojo.TbItem;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbItemService {

	public EasyUIDataGridResult getTbItemList(Integer page,Integer rows);

	public FjnyResult saveItem(TbItem tbItem,String desc,String itemParams);

	public FjnyResult updateItem(TbItem tbItem,String desc);

	public FjnyResult deleteTbItem(List<Long> ids);

	public FjnyResult putUpTbItem(List<Long> ids);

	public FjnyResult putDownTbItem(List<Long> ids);
}
