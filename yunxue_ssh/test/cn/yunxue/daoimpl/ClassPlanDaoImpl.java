package cn.yunxue.daoimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yunxue.dao.ClassPlanDao;
import cn.yunxue.model.ClassPlanMo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ClassPlanDaoImpl {
	@Autowired
	@Qualifier("classPlanDaoImpl")
	private ClassPlanDao classPlanDao;

	@Test
	public void test1() {
		ClassPlanMo classPlanMo = new ClassPlanMo();
		classPlanMo.setPlanClassDate("1");
		classPlanMo.setPlanClassState("0");
		classPlanMo.setTeacherNo(2);
		classPlanMo.setPlanClassTime("1");
		classPlanDao.insertClassPlan(classPlanMo);
	}

	@Test
	public void updateClassPlan() {
		classPlanDao.updateClassPlan(22, 1);
	}

	@Test
	public void insertClassPlan() {
		ClassPlanMo classPlanMo = new ClassPlanMo();
		classPlanMo.setTeacherNo(21);
		classPlanDao.insertClassPlan(classPlanMo);
	}
}
