package org.zwh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zwh.service.PictureUploadService;
import org.zwh.utils.JsonUtils;
import org.zwh.utils.PictureResult;
@Controller
public class PictureUploadController {
	@Autowired
	private PictureUploadService pictureUploadservice;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile) {	
		PictureResult result = pictureUploadservice.pictureUpload(uploadFile);
		return JsonUtils.objectToJson(result);	
	}
}
