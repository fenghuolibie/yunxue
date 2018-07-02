package cn.yunxue.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author m1827
 * 验证教师已通过几级验证的action
 */
@Getter
@Setter
public class TeaIdentityAction extends ActionSupport {
	private static final long serialVersionUID = 8915325861340019490L;
	/**
	 * 0:通过0层；1：通过1层；2：通过两层；3通过三层（完成认证）
	 */
	private String passMg = "0";
	private TeaIdentityMo teacher;
	private List<ClassPlanMo> classList;
	private TeaInfoView teacher1;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TeacherMo teacherMo = (TeacherMo) session.getAttribute("teaLoginer");
		switch (teacherService.getTeaState(teacherMo)) {
		case "0":
			passMg = "0";
			TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
			teaIdentityMo.setTeacherNo(teacherMo.getTeacherNo());
			teacher = teacherService.getTeaIdentity(teaIdentityMo);
			return ERROR;
		case "1":
			passMg = "1";
			return "error1";
		case "2":
			passMg = "2";
			TeaIdentityMo teaIdentityMo2 = new TeaIdentityMo();
			teaIdentityMo2.setTeacherNo(teacherMo.getTeacherNo());
			this.classList = teacherService.getTeaClassPlan(teaIdentityMo2);
			return "error2";
		case "3":
			TeaIdentityMo teaIdentityMo3 = new TeaIdentityMo();
			teaIdentityMo3.setTeacherNo(teacherMo.getTeacherNo());
			TeaInfoView teaInfoView = new TeaInfoView();
			teaInfoView.setTeacherNo(teacherMo.getTeacherNo());
			this.teacher1 = teacherService.getTeaInfoView(teaInfoView);
			this.classList = teacherService.getTeaClassPlan(teaIdentityMo3);
			return SUCCESS;
		default:
			return ERROR;
		}
	}

}
