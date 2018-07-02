package cn.yunxue.action;

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
public class StuRegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userPhone;
	private String userPwd;
	private String checkCode;
	/**
	 * 5:注册学生成功 6：注册失败 7:用户民和密码不能为空 8:验证码错误
	 */
	private String regMsg = "6";

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		if (userPhone == null || userPhone.equals("") || userPwd == null || userPwd.equals("")) {
			return ERROR;
		}
		String code = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		StudentMo studentMo = new StudentMo();
		studentMo.setStuPhone(userPhone);
		studentMo.setStuPwd(userPwd);
		if (!checkCode.equals(code)) {
			regMsg = "8";
			return ERROR;
		}
		if (studentService.checkPhone(userPhone) == 1) {
			regMsg = "5";
			studentService.register(studentMo);
			return SUCCESS;
		}
		return ERROR;
	}
}
