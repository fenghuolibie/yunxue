package cn.yunxue.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.BuyClassDao;
import cn.yunxue.model.BuyClassMo;

@Repository
@Scope("prototype")
// @SuppressWarnings("unchecked")
public class BuyClassDaoImpl implements BuyClassDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertBuyClass(BuyClassMo buyClassMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(buyClassMo);
	}

	@Override
	public void updateBuyState(BuyClassMo buyclassMo) {
		// TODO Auto-generated method stub
		String hql = "update BuyClassMo b set b.buyState = '已支付' where b.buyClassOrderNo = ?";
		hibernateTemplate.bulkUpdate(hql, buyclassMo.getBuyClassOrderNo());
	}

}
