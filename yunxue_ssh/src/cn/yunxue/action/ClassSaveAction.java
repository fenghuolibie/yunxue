package cn.yunxue.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.StudentMo;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassSaveAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * 时段号
	 */
	private String[] no;
	/**
	 * 时段名称
	 */
	private String[] name;

	private String classname;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		System.out.println(no);
		System.out.println(name);
		HttpSession session = ServletActionContext.getRequest().getSession();
		StudentMo studentMo = (StudentMo) session.getAttribute("stuLoginer");
		teacherService.updateclassname(studentMo.getStuNo(), no, name, 150);
		this.classname = "0";
		return SUCCESS;
	}

}
