package cn.yunxue.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeaIdentityThridAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> stage; // 教育阶段
	private ArrayList<String> subject; // 教育科目
	private ArrayList<String> time;
	private List<ClassPlanMo> classList;
	/**
	 * fillok:认证成功；fillfail：认证失败
	 */
	private String identityMsg = "fillfail";

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TeacherMo teacherMo = (TeacherMo) session.getAttribute("teaLoginer");
		String teacherClasses = "";
		String teacherStage = "";
		classList = new ArrayList<ClassPlanMo>();
		// 将教育阶段和教育科目整合成一个字段
		for (int i = 0; i < subject.size(); i++) {
			teacherClasses += subject.get(i) + "&nbsp;&nbsp;";
		}
		for (int i = 0; i < stage.size(); i++) {
			teacherStage += stage.get(i) + "&nbsp;&nbsp;";
		}
		teacherMo.setTeacherStage(teacherStage);
		teacherMo.setTeacherClasses(teacherClasses);
		// 插入教育阶段数据
		teacherService.updateTeaIdentity2(teacherMo, time);
		this.identityMsg = "fillok";
		return SUCCESS;
	}

}