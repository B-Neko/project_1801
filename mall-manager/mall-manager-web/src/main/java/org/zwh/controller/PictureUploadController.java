package org.zwh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zwh.service.PictureUploadService;
import org.zwh.utils.JsonUtils;
import org.zwh.utils.PictureResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "图片更新接口")
@Controller
public class PictureUploadController {
	@Autowired
	private PictureUploadService pictureUploadservice;
	
	@ApiOperation(value = "图片更新")
	@ApiImplicitParam(name = "uploadFile",value = "图片文件")
	@RequestMapping(value = "/pic/upload",method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile uploadFile) {
		System.out.println("图片请求到这了 ");
		PictureResult result = pictureUploadservice.pictureUpload(uploadFile);
		return JsonUtils.objectToJson(result);	
	}
}
