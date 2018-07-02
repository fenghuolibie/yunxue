package cn.yunxue.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.service.StudentService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeaCheckPhoneAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String teaPhone;
	/**
	 * 1:允许注册; 2:已注册为教师; 3：已注册为学生; 4:注册失败;
	 */
	private String regMsg;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		switch (studentService.checkPhone(teaPhone)) {
		case 1:
			regMsg = "1";
			return SUCCESS;
		case 2:
			regMsg = "2";
			return SUCCESS;
		case 3:
			regMsg = "3";
			return SUCCESS;
		default:
			return "exception";
		}
	}

}