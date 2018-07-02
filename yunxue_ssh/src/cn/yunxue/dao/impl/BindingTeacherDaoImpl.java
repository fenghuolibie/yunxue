package cn.yunxue.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.BindingTeacherDao;
import cn.yunxue.model.BindingTeacherMo;

@Repository
@Scope("prototype")
// @SuppressWarnings("unchecked")
public class BindingTeacherDaoImpl implements BindingTeacherDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertBinding(BindingTeacherMo bindingTeacherMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(bindingTeacherMo);
	}

}
