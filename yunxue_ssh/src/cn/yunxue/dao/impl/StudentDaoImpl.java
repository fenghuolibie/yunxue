package cn.yunxue.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.StudentDao;
import cn.yunxue.model.StudentMo;

@Repository
@Scope("prototype")
@SuppressWarnings("unchecked")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public Boolean QueryStu(String stuPhone) {
		// TODO Auto-generated method stub
		String sql = "from StudentMo s where s.stuPhone = " + stuPhone;
		List<StudentMo> list = hibernateTemplate.find(sql);
		return (list.size() == 1) ? true : false;
	}

	@Override
	public void InsertStu(StudentMo studentMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(studentMo);
	}

	@Override
	public Boolean checkStu(StudentMo studentMo) {
		String sql = "from StudentMo s where s.stuPhone =" + studentMo.getStuPhone();
		List<StudentMo> list = hibernateTemplate.find(sql);
		return (list.get(0).getStuPwd().equals(studentMo.getStuPwd())) ? true : false;
	}

	@Override
	public StudentMo getStuAcNo(int id) {
		// TODO Auto-generated method stub
		StudentMo studentMo = hibernateTemplate.get(StudentMo.class, id);
		return studentMo;
	}

	@Override
	public void updateStuMoney(StudentMo studentMo) {
		// TODO Auto-generated method stub
		String hql = "update StudentMo s set s.stuMoney = ? where s.stuNo = ?";
		hibernateTemplate.bulkUpdate(hql, studentMo.getStuMoney(), studentMo.getStuNo());
	}

	@Override
	public StudentMo getStuAcPhone(String stuPhone) {
		// TODO Auto-generated method stub
		String sql = "from StudentMo s where s.stuPhone = " + stuPhone;
		List<StudentMo> list = hibernateTemplate.find(sql);
		return list.get(0);
	}

	@Override
	public int loginCheck(StudentMo studentMo) {
		// TODO Auto-generated method stub
		String sql = "from StudentMo s where s.stuPhone =" + studentMo.getStuPhone();
		List<StudentMo> list = hibernateTemplate.find(sql);
		if (list.size() == 0) {
			return 3;
		} else if (list.get(0).getStuPwd().equals(studentMo.getStuPwd())) {
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public void updateStu(StudentMo stu) {
		// TODO Auto-generated method stub
		String sql = "update studentT set stuName='" + stu.getStuName() + "', stuSex='" + stu.getStuSex()
				+ "', stuBirth='" + stu.getStuBirth() + "', stuStage='" + stu.getStuStage() + "', stuSchool='"
				+ stu.getStuSchool() + "' where stuNo='" + stu.getStuNo() + "'";
		hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public void updateStu1(StudentMo studentMo) {
		// TODO Auto-generated method stub
		String sql = "update studentt set stuImg = ? where stuNo = ?";
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setString(0, studentMo.getStuImg());
		query.setLong(1, studentMo.getStuNo());
		query.executeUpdate();
	}

}
