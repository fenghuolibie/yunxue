package cn.yunxue.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.StudentService;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

/**
 * 课程预约action
 * @author m1827
 *
 */
@Getter
@Setter
public class ClassAppointAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer teacherNo;
	private List<ClassPlanMo> classno;
	private TeacherMo teamo;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
		teaIdentityMo.setTeacherNo(teacherNo);
		this.classno = teacherService.getTeaClassPlan(teaIdentityMo);
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherNo(teacherNo);
		this.teamo = teacherService.getTeaMsg1(teacherMo);
		return SUCCESS;
	}

}