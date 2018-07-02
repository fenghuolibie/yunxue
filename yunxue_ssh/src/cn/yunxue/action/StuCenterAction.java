package cn.yunxue.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;
import cn.yunxue.service.StudentService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StuCenterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// private int userNo; //得到登学生录对象//作废
	private StudentMo student; // 传入个人中心页面的学生对象
	private List<ClassResumeView> classItem; // 学生对于的课程记录表classmo1
	private List<ClassResumeView> timeTable; // 学生的课程表classmo2

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@Override
	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		StudentMo studentMo = (StudentMo) session.getAttribute("stuLoginer");
		this.classItem = studentService.getFinishClass(studentMo);
		this.timeTable = studentService.getTimeTable(studentMo);
		this.student = studentService.getStuMsg(studentMo);
		return SUCCESS;
	}

}
