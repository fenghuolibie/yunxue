package cn.yunxue.action;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeaIdentityFirstAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String imgurl;
	private String teaName;
	private String year;
	private String sex;
	private String teaEducation;
	private String teaSchool;
	private String teaMajor;
	private String teaArea;
	private String teaDescription;
	private String teaExperience;
	private String teaIdCard;
	/**
	 * fillok:插入成功；fillfail：插入失败
	 */
	private String markMsg;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TeacherMo teacherMo = (TeacherMo) session.getAttribute("teaLoginer");
		int teacherNo = teacherMo.getTeacherNo();
		int teaAge = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(year); // 根据出生年月获得岁数
		TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
		teaIdentityMo.setTeacherNo(teacherNo);
		teaIdentityMo.setTeaPicture(imgurl);
		teaIdentityMo.setTeaName(teaName);
		teaIdentityMo.setTeaAge(teaAge);
		teaIdentityMo.setTeaSex(sex);
		teaIdentityMo.setTeaEducation(teaEducation);
		teaIdentityMo.setTeaSchool(getTeaSchool());
		teaIdentityMo.setTeaMajor(getTeaMajor());
		teaIdentityMo.setTeaArea(teaArea);
		teaIdentityMo.setTeaDescription(teaDescription);
		teaIdentityMo.setTeaExperience(teaExperience);
		teaIdentityMo.setTeaIdCard(teaIdCard);
		teacherService.updateTeaIdentity(teaIdentityMo);
		markMsg = "fillok";
		return SUCCESS;
	}

}