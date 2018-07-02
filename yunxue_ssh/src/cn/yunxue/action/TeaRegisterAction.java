package cn.yunxue.action;

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
public class TeaRegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userPhone;
	private String userPwd;
	private String checkCode;
	/**
	 * 5:注册教师成功 6：注册失败 7:用户民和密码不能为空 8:验证码错误
	 */
	private String regMsg = "6";

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		System.out.println("------------------");
		String code = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		System.out.println(code);
		System.out.println(checkCode);
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherPhone(userPhone);
		teacherMo.setTeacherPwd(userPwd);
		System.out.println("------------------");
		if (!checkCode.toUpperCase().equals(code.toUpperCase())) {
			regMsg = "8";
			return ERROR;
		}
		if (studentService.checkPhone(userPhone) == 1) {
			teacherService.register(teacherMo);
			// teacherService.initTeaState(teacherMo);
			regMsg = "5";
			return SUCCESS;
		}
		return ERROR;
	}

}