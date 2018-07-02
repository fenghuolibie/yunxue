package cn.yunxue.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.ClassDao;
import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;

@Repository
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ClassDaoImpl implements ClassDao {
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<ClassResumeView> getFinishClass(ClassResumeView classResumeView) {
		// TODO Auto-generated method stub
		return hibernateTemplate.findByExample(classResumeView);
	}

	@Override
	public List<ClassResumeView> getTimeTable(StudentMo studentMo) {
		// TODO Auto-generated method stub
		String sql = "select * from class_resume where" + "(classDate between now() and date_add(now(),interval 7 day))"
				+ " and stuNo=" + studentMo.getStuNo() + " and courseState2='" + 1 + "'";
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.addEntity(ClassResumeView.class);
		return query.list();
	}

}
