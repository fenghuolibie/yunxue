package cn.yunxue.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.TeaInfoView;
import cn.yunxue.service.TeacherService;
import cn.yunxue.utils.PageBean;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryTeacherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 查询关键字
	 */
	private String name = "";
	/**
	 * 当前页面
	 */
	private int curPage = 1;
	private PageBean<TeaInfoView> pageBean;
	private List<TeaInfoView> teacherList;
	private String stage;
	private String sex;
	private String subject;
	private String sort;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	public String execute() throws UnsupportedEncodingException {
		int pageSize = 4;
		System.out.println(sex);
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		if (stage == null && sex == null && subject == null && sort == null) {
			pageBean = teacherService.getTeaList(name, pageSize, curPage);
		} else {
			stage = stage == null ? "" : stage;
			sex = sex == null ? "" : sex;
			subject = subject == null ? "" : subject;
			sort = sort == null ? "" : sort;
			System.out.println(stage + sex + subject + sort);
			System.out.println(sex.equals(""));
			pageBean = teacherService.getTeaList1(curPage, pageSize, name, stage, sex, subject, sort);
		}
		return SUCCESS;
	}
}
