package org.zwh.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zwh.service.PictureUploadService;
import org.zwh.utils.FtpUtil;
import org.zwh.utils.IDUtils;
import org.zwh.utils.PictureResult;

@Service
public class PictureUploadServiceImpl implements PictureUploadService {
	String host="127.0.0.1";
	int port =21;
	String username = "zwh";
	String password = "123456";
	
	@Override
	public PictureResult pictureUpload(MultipartFile uploadfile) {
		PictureResult result = new PictureResult();
		try {
			//判断是否为空
			if(null == uploadfile || uploadfile.isEmpty()) {
				result.setError(500);
				result.setMessage("上传图片为空");
				return  result;
			}
			//获取文件名
			String orginalFilename =uploadfile.getOriginalFilename();
			String ext = orginalFilename.substring(orginalFilename.lastIndexOf("."));			
			DateTime datetime = new DateTime();
			String filePath = datetime.toString("yyyy/MM/dd");	
			String filename = IDUtils.genImageName()+ext;		
			InputStream input = uploadfile.getInputStream();
			FtpUtil.uploadFile(host,port,username,password,"/",filePath,filename,input);
			String url = "http://localhost:8383"+filePath+"/"+filename;
			result.setError(0);
			result.setUrl(url);		

		} catch (IOException e) {
			result.setError(500);
			result.setMessage(ExceptionUtil.unwrapThrowable(e).toString());
		}	
		return  result;
	}

}
