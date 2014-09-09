package com.yunding.lago.controller;

import java.io.File;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.bean.Comment;
import com.yunding.lago.bean.ReplyToComment;
import com.yunding.lago.bean.User;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.CommentService;
import com.yunding.lago.service.UserService;
import com.yunding.lago.util.MyConstants;
import com.yunding.lago.util.WebConfig;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController extends BaseController {

	@RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
	public String upload(Locale locale, Model model,
			@RequestParam("file") CommonsMultipartFile file) {
		String url = "";
		if (!file.isEmpty()) {
			logger.info("上传文件的名字：" + file.getOriginalFilename());
			String newFileName = UUID.randomUUID().toString()
					+ getFileExtension(file.getOriginalFilename());
			File localFile = new File(
					WebConfig.getValue(MyConstants.configWebsiteUploadFolder)
							+ File.pathSeparator + newFileName);
			if (!localFile.exists()) {
				localFile.mkdirs();
			}
			try {
				file.getFileItem().write(localFile); // 将上传的文件写入新建的文件中
				logger.info("文件上传成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
			url = WebConfig.getValue(MyConstants.configWebsiteUrl)
					+ WebConfig
					.getValue(MyConstants.configWebsiteDownloadUrlPrefix)
			+ newFileName;
		}
		return "{'url':'" + url + "'}";
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param file
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}
}
