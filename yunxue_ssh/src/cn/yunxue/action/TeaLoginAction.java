package cn.yunxue.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.StudentService;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeaLoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userPhone;
	private String userPwd;
	/**
	 * lost1：密码错误；lost2:账号不存在; lost3:用户使用学生账号登录; lost4:号码 密码不能为空
	 */
	private String logMsg = "lost4";

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherPhone(userPhone);
		teacherMo.setTeacherPwd(userPwd);
		HttpSession session = ServletActionContext.getRequest().getSession();
		switch (teacherService.login(teacherMo)) {
		case 1:
			if (session.getAttribute("stuLoginer") != null) {
				session.removeAttribute("stuLoginer");
			}
			session.setAttribute("teaLoginer", teacherService.getTeaMsg(teacherMo));
			return SUCCESS;
		case 2:
			logMsg = "lost1";
			return ERROR;
		case 3:
			if (studentService.checkPhone(teacherMo.getTeacherPhone()) == 3) {
				logMsg = "lost3";
				return ERROR;
			}
			logMsg = "lost2";
			return ERROR;
		default:
			return "exception";
		}
	}

}
