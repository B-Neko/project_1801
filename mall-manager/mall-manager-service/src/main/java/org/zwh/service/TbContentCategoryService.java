package org.zwh.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zwh.utils.EasyUITreeNodeBean;
import org.zwh.utils.FjnyResult;

public interface TbContentCategoryService {

	public List<EasyUITreeNodeBean> getTbContentCategoryList(long parentId);

	public FjnyResult createNode(Long parentId, String name);

	public FjnyResult updateNodeName(Long id, String name);

	public FjnyResult deleteNode(Long id);

}
