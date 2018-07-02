package cn.yunxue.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TeacherServiceImpl {
	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	@Test
	public void updateTeaIdentity() {
		try {
			TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
			teaIdentityMo.setTeacherNo(3);
			teaIdentityMo.setTeaAge(123);
			teaIdentityMo.setTeaPicture("//");
			teacherService.updateTeaIdentity(teaIdentityMo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void updateTeaClassPlan() {
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherNo(22);
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("4");
		teacherService.updateTeaClassPlan(teacherMo, list);
	}

	@Test
	public void getTeaList1() {
		teacherService.getTeaList1(1, 4, "", "", "", "", "");
	}

	@Test
	public void getTeaClassPlan() {
		TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
		teaIdentityMo.setTeacherNo(23);
		List<ClassPlanMo> list = teacherService.getTeaClassPlan(teaIdentityMo);
		for (ClassPlanMo classPlanMo : list) {
			System.out.println(classPlanMo);
		}
	}

	@Test
	public void updateclassname() {
		String[] planNo = { "179", "180", "181" };
		int stuNo = 1;
		String[] s = { "数学", "yinyv", "asd" };
		int money = 1500;
		teacherService.updateclassname(stuNo, planNo, s, money);
	}

	@Test
	public void getTeaInfoView() {
		TeaInfoView teaInfoView = new TeaInfoView();
		teaInfoView.setTeacherNo(7);
		System.out.println(teacherService.getTeaInfoView(teaInfoView).getTeacherNo());
	}
}
