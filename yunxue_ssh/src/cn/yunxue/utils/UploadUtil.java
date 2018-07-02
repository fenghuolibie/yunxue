package cn.yunxue.utils;

import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class UploadUtil {
	// 项目真实路径常量
	public static final String BASEPATH = ServletActionContext.getServletContext().getRealPath("/");

	// 简单的uuid生成文件名
	public static String getUUIDfileName(String fileName) {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase()
				+ fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}
}
