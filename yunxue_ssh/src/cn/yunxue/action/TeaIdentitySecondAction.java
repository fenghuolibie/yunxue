package cn.yunxue.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.TeacherService;
import cn.yunxue.utils.UploadUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeaIdentitySecondAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<File> teacherImg;
	private List<String> teacherImgContentType;
	private List<String> teacherImgFileName;
	private List<ClassPlanMo> classList;
	/**
	 * fillok:插入成功；fillfail：插入失败
	 */
	private String markMsg;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		String idCardPath = UploadUtil.BASEPATH + "IMG/teacherIdIMG/";
		String cerPath = UploadUtil.BASEPATH + "IMG/teacherIdIMG2/";
		File file1 = new File(idCardPath, UploadUtil.getUUIDfileName(teacherImgFileName.get(0))); // 身份证图片目标路径
		File file2 = new File(cerPath, UploadUtil.getUUIDfileName(teacherImgFileName.get(1))); // 教师证图片目标路径
		try {
			FileUtils.copyFile(teacherImg.get(0), file1);
			FileUtils.copyFile(teacherImg.get(1), file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 文件路径存入数据库
		HttpSession session = ServletActionContext.getRequest().getSession();
		TeacherMo teacherMo = (TeacherMo) session.getAttribute("teaLoginer");
		int teacherNo = teacherMo.getTeacherNo();
		TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
		teaIdentityMo.setTeacherNo(teacherNo);
		teaIdentityMo.setTeaIdCardImg(file1.getPath());
		teaIdentityMo.setTeaCardImg(file2.getPath());
		teacherService.updateTeaIdentity1(teaIdentityMo);
		markMsg = "fillok";
		// 传入默认课表
		this.classList = teacherService.getTeaClassPlan(teaIdentityMo);
		return SUCCESS;
	}

}
