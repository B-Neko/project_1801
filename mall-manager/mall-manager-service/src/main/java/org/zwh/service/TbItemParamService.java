package org.zwh.service;

import java.util.List;

import org.zwh.pojo.TbItem;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbItemParamService {

	public EasyUIDataGridResult getItemParamList(Integer page,Integer rows);

	public FjnyResult checkParam(Long itemCatId);

	public FjnyResult addItemParam(Long itemCatId, String paramData);

		
	public FjnyResult deleteItemParam(List<Long> ids);


}
