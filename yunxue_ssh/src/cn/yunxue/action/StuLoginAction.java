package cn.yunxue.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.StudentMo;
import cn.yunxue.service.StudentService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StuLoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private StudentMo studentMo;
	/**
	 * lost1：密码错误；lost2:账号不存在; lost3:教师账号登录; lost4:号码 密码不能为空
	 */
	private String logMsg = "lost4";

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {

		HttpSession session = ServletActionContext.getRequest().getSession();
		switch (studentService.login(studentMo)) {
		case 1:
			if (session.getAttribute("teaLoginer") != null) {
				session.removeAttribute("teaLoginer");
			}
			session.setAttribute("stuLoginer", studentService.getStuMsg(studentMo));
			return SUCCESS;
		case 2:
			logMsg = "lost1";
			return ERROR;
		case 3:
			if (studentService.checkPhone(studentMo.getStuPhone()) == 2) {
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
