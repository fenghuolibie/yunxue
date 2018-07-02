package cn.yunxue.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.ClassPlanDao;
import cn.yunxue.model.ClassIntervalMo;
import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;

@Repository
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ClassPlanDaoImpl implements ClassPlanDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertClassPlan(ClassPlanMo classPlanMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(classPlanMo);
	}

	@Override
	public ClassIntervalMo get(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(ClassIntervalMo.class, id);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ClassIntervalMo";
		return ((Long) hibernateTemplate.find(hql).get(0)).intValue();
	}

	@Override
	public List<ClassPlanMo> getTeaClassPlan(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		ClassPlanMo classPlanMo = new ClassPlanMo();
		classPlanMo.setTeacherNo(teaIdentityMo.getTeacherNo());
		return hibernateTemplate.findByExample(classPlanMo);
	}

	@Override
	public void updateClassPlan(int teacherNo, int classInterval) {
		// TODO Auto-generated method stub
		String hql = "update ClassPlanMo c set c.planClassState = 1 where c.teacherNo =" + teacherNo
				+ "and c.classInterval =" + classInterval;
		hibernateTemplate.bulkUpdate(hql);
	}

	@Override
	public void updateClassPlan1(int planClassNo, String className) {
		// TODO Auto-generated method stub
		String hql = "update ClassPlanMo c set c.planClassState = 2,c.planClassName = ? where c.planClassNo = ?";
		hibernateTemplate.bulkUpdate(hql, className, planClassNo);
	}

}
