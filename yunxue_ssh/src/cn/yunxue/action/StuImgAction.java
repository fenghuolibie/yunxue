package cn.yunxue.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.StudentMo;
import cn.yunxue.service.StudentService;
import cn.yunxue.utils.UploadUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StuImgAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private File userlogo;
	private String userlogoContentType;
	private String userlogoFileName;
	/**
	 * 1:上传成功
	 */
	private String msg;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		StudentMo studentMo = (StudentMo) session.getAttribute("stuLoginer");
		String stuImg = UploadUtil.BASEPATH + "IMG/studentIMG/";
		File file = new File(stuImg, UploadUtil.getUUIDfileName(userlogoFileName));
		System.out.println(file);
		try {
			FileUtils.copyFile(userlogo, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentMo.setStuImg(file.getPath());
		studentService.updateStu1(studentMo);
		msg = "1";
		return SUCCESS;
	}

}