package org.zwh.service;

import java.util.List;

import org.zwh.utils.EasyUITreeNodeBean;

public interface TbItemCatService {
	List<EasyUITreeNodeBean> getTbItemCatList(Long parentId);
}
