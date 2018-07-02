package cn.yunxue.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.service.TeacherService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeaMessageAction extends ActionSupport {

	private static final long serialVersionUID = 8444938122802544821L;

	private int teacherNo;
	private TeaInfoView teacher1;
	private List<ClassPlanMo> classPlan;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() {
		TeaInfoView teaInfoView = new TeaInfoView();
		teaInfoView.setTeacherNo(teacherNo);
		this.teacher1 = teacherService.getTeaInfoView(teaInfoView);
		TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
		teaIdentityMo.setTeacherNo(teacherNo);
		this.classPlan = teacherService.getTeaClassPlan(teaIdentityMo);
		return SUCCESS;
	}

}
