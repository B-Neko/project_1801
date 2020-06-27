package org.zwh.service;

import org.springframework.web.multipart.MultipartFile;
import org.zwh.utils.PictureResult;

public interface PictureUploadService {
	public PictureResult pictureUpload(MultipartFile uploadfile);
}
