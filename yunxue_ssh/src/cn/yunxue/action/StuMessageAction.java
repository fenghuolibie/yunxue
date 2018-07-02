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

/**
 * @author m1827
 * 更新学生信息
 */
@Getter
@Setter
public class StuMessageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String imgurl;
	private String personName;
	private String sex;
	private String year;
	private String month;
	private String stage;
	private String personSchool;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		StudentMo studentMo = (StudentMo) session.getAttribute("stuLoginer");
		String stuBirth = year + "-" + month;

		studentMo.setStuName(personName);
		studentMo.setStuSex(sex);
		studentMo.setStuBirth(stuBirth);
		studentMo.setStuStage(stage);
		studentMo.setStuSchool(personSchool);
		studentService.updateStu(studentMo);
		return SUCCESS;
	}

}
