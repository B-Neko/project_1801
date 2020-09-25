package org.zwh.service;

import org.zwh.pojo.TbContent;
import org.zwh.utils.EasyUIDataGridResult;
import org.zwh.utils.FjnyResult;

public interface TbContentService {

	EasyUIDataGridResult getTbContentList(Long categoryId,Integer page, Integer rows);

	FjnyResult getTbContentdelete(Long ids);

	FjnyResult getTbContentSave(TbContent contentAddForm);

	FjnyResult getTbContentEdit(TbContent contentEditForm);

}
