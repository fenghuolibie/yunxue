package cn.yunxue.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.service.StudentService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author m1827
 * 学生注册号码是否可用
 */
@Setter
@Getter
public class StuCheckPhoneAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String stuPhone;
	/**
	 * 1:允许注册; 2:已注册为教师; 3：已注册为学生; 4:注册失败; 5:用户名能不为空
	 */
	private String regMsg;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		/*
		 * if (stuPhone == null || stuPhone.equals("")) {
		 * 
		 * }
		 */
		switch (studentService.checkPhone(stuPhone)) {
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