package org.zwh.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
	
	
	static String host;
	static int port;
	static String username;
	static String password;
	
	public void readProperties() {
		Properties properties=new Properties();
		InputStream in = PictureUploadServiceImpl.class.getClassLoader().getResourceAsStream("ftp.properties");
		try {
			properties.load(in);
			host = properties.getProperty("FTP_ADDRESS");
			port = Integer.parseInt(properties.getProperty("FTP_PORT"));
			username = properties.getProperty("FTP_USER_NAME");
			password = properties.getProperty("westos321");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public PictureResult pictureUpload(MultipartFile uploadfile) {
		readProperties();
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
			String url = "http://60.205.152.139:8088"+filePath+"/"+filename;
			result.setError(0);
			result.setUrl(url);		

		} catch (IOException e) {
			result.setError(500);
			result.setMessage(ExceptionUtil.unwrapThrowable(e).toString());
		}	
		return  result;
	}

}
