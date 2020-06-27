package org.zwh.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zwh.mapper.TbItemParamItemMapper;
import org.zwh.pojo.TbItemParamItem;
import org.zwh.pojo.TbItemParamItemExample;
import org.zwh.service.TbItemParamItemService;
import org.zwh.utils.JsonUtils;


@Service
public class TbItemParamItemServiceImpl implements TbItemParamItemService {
	@Resource
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public String getTbItemParamByItemId(Long itemId) {
		TbItemParamItemExample example = new TbItemParamItemExample();
		example.createCriteria().andIdEqualTo(itemId);
		List<TbItemParamItem> list = tbItemParamItemMapper.selectByExampleWithBLOBs(example);	
		String objectToJson = JsonUtils.objectToJson(list.get(0).getParamData());
		if (list == null ||list.isEmpty()) {
			return "";
		}
		List<Map> groups = JsonUtils.jsonToList(objectToJson, Map.class);
		StringBuffer sb = new StringBuffer();
		sb.append("<ul>");
		for(int i =0;i<groups.size();i++){
			Map map = groups.get(i);
			String group =(String)map.get("groups");
			//显示组别
			sb.append("<li><table border=\"1\"><tbody><tr><td colspan=\"2\" class=\"gourps\">");
			sb.append(group);
			sb.append("</td></tr>");
			List<Map> params = (List<Map>)map.get("params");
			//遍历
			for (int j = 0; j < params.size(); j++) {
				Map paraMap = params.get(j);
				String key = (String)paraMap.get("k");
				sb.append("<tr><td class=\"param\"><span>");
				sb.append(key);
				sb.append("<span>:</td>");
				String value = (String) paraMap.get("v");
				sb.append("<td>");
				sb.append(value);
				sb.append("</td>");
			}
			sb.append("</tbody></table></li>");
		}
		return sb.toString();
	}
	
	
}
