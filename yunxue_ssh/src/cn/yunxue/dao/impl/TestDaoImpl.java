package cn.yunxue.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.TestDao;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.utils.PageHibernateCallback;

@Repository
@SuppressWarnings("unchecked")
public class TestDaoImpl implements TestDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public TeaInfoView get(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(TeaInfoView.class, id);
	}

	@Override
	public Iterator<?> update(TeaInfoView teaInfoView) {
		// TODO Auto-generated method stub
		String hql = "from TeaInfoView";
		Iterator<?> iterator = hibernateTemplate.iterate(hql);
		System.out.println(iterator);
		System.out.println(iterator.next());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		return iterator;
	}

	@Override
	public List<TeaInfoView> getList(String name) {
		// TODO HQL里面的like如果有中文模糊匹配，是不能够直接拼字符串的哈，用参数代替
		String hql = "from TeaInfoView t where t.teaName like '%" + name + "%'";
		return hibernateTemplate.executeFind(new PageHibernateCallback<TeaInfoView>(hql, new Object[] {}, 0, 2));
	}

}
