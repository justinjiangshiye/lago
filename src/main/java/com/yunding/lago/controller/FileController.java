package com.yunding.lago.controller;

import java.io.File;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yunding.lago.util.MyConstants;
import com.yunding.lago.util.WebConfig;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController extends BaseController {


	@RequestMapping(value = "/admin/uploadFile", method = RequestMethod.GET)
	public String uploadFile(Locale locale, Model model) {
		return "admin/uploadFile";
	}
	
	@RequestMapping(value = "/admin/saveUploadFile", method = RequestMethod.POST)
	public String saveUploadFile(Locale locale, Model model,
			@RequestParam("file") CommonsMultipartFile file) {
		logger.info("welcome to saveUploadFile.");
		String url = "";
		if (!file.isEmpty()) {
			logger.info("上传文件的名字：" + file.getOriginalFilename());
			String newFileName = UUID.randomUUID().toString() + "."
					+ getFileExtension(file.getOriginalFilename());
			File localFile = new File(
					WebConfig.getValue(MyConstants.configWebsiteUploadFolder)
							+ "/" + newFileName);
			try {
				file.getFileItem().write(localFile); // 将上传的文件写入新建的文件中
				logger.info("文件上传成功");
				url = WebConfig.getValue(MyConstants.configWebsiteUrl)
						+ WebConfig
						.getValue(MyConstants.configWebsiteDownloadUrlPrefix)
				+ newFileName;
				model.addAttribute("uploadStatus", true);
				model.addAttribute("url", url);
				
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("uploadStatus", false);
			}
		}
		return "admin/uploadFile";
	}
	
	@RequestMapping(value = "/admin/uploadImage", method = RequestMethod.GET)
	public String uploadImage(Locale locale, Model model) {
		return "admin/uploadImage";
	}
	
	@RequestMapping(value = "/admin/saveUploadImage", method = RequestMethod.POST)
	public String saveuploadImage(Locale locale, Model model,
			@RequestParam("file") CommonsMultipartFile file) {
		logger.info("welcome to saveUploadImage.");
		String url = "";
		if (!file.isEmpty()) {
			logger.info("上传文件的名字：" + file.getOriginalFilename());
			String newFileName = UUID.randomUUID().toString() + "."
					+ getFileExtension(file.getOriginalFilename());
			File localFile = new File(
					WebConfig.getValue(MyConstants.configWebsiteUploadFolder)
							+ "/" + newFileName);
			try {
				file.getFileItem().write(localFile); // 将上传的文件写入新建的文件中
				logger.info("文件上传成功");
				url = WebConfig.getValue(MyConstants.configWebsiteUrl)
						+ WebConfig
						.getValue(MyConstants.configWebsiteDownloadUrlPrefix)
				+ newFileName;
				model.addAttribute("uploadStatus", true);
				model.addAttribute("url", url);
				
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("uploadStatus", false);
			}
		}
		return "admin/uploadImage";
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
