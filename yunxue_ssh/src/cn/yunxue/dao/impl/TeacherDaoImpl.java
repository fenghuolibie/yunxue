package cn.yunxue.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.yunxue.dao.TeacherDao;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;

@Repository
@Scope("prototype")
@SuppressWarnings("unchecked")
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public Boolean QueryTea(String teaPhone) {
		// TODO Auto-generated method stub
		String sql = "from TeacherMo t where t.teacherPhone =" + teaPhone;
		List<TeacherMo> list = hibernateTemplate.find(sql);
		return (list.size() == 1) ? true : false;
	}

	@Override
	public void InsertTea(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(teacherMo);
	}

	@Override
	public Boolean checkTea(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		// String sql = "from TeacherMo t where t.teacherPhone = ?";
		// List<TeacherMo> list = hibernateTemplate.find(sql,
		// teacherMo.getTeacherPhone());
		List<TeacherMo> list = hibernateTemplate.findByExample(teacherMo);
		return (list.get(0).getTeacherPwd().equals(teacherMo.getTeacherPwd())) ? true : false;
	}

	@Override
	public TeacherMo getTeaAcNo(int teaNo) {
		// TODO Auto-generated method stub
		TeacherMo teacherMo = hibernateTemplate.get(TeacherMo.class, teaNo);
		return teacherMo;
	}

	@Override
	public void updateTea(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(teacherMo);
	}

	@Override
	public int loginCheck(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		String sql = "from TeacherMo t where t.teacherPhone =" + teacherMo.getTeacherPhone();
		List<TeacherMo> list = hibernateTemplate.find(sql);
		if (list.size() == 0) {
			return 3;
		} else if (list.get(0).getTeacherPwd().equals(teacherMo.getTeacherPwd())) {
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public List<TeaInfoView> getTeaList(int currentPage, int pagesize, String name) {
		// TODO Auto-generated method stub
		String sql = "from TeaInfoView t where t.teaName like '%" + name + "%'";
		// List<TeacherMo> list = hibernateTemplate.find(sql);
		// int fromindex = (currentPage - 1) * pagesize + 1;
		// return list.subList(fromindex, fromindex + pagesize);
		// Query query = sessionFactory.getCurrentSession().createQuery(sql);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(sql);
		query.setFirstResult((currentPage - 1) * pagesize);
		query.setMaxResults(pagesize);
		return query.list();
	}

	@Override
	public int getTeaCount(String name) {
		// TODO Auto-generated method stub
		String hql = "select count(*)  from TeaInfoView t where t.teaName like '%" + name + "%'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return ((Long) query.iterate().next()).intValue();
	}

	@Override
	public TeacherMo getTeaAcPhone(String Phone) {
		// TODO Auto-generated method stub
		String sql = "from TeacherMo t where t.teacherPhone =" + Phone;
		List<TeacherMo> list = hibernateTemplate.find(sql);
		return list.get(0);
	}

	@Override
	public void InsertTeaIdentify(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(teaIdentityMo);
	}

	@Override
	public TeaIdentityMo getTeaIdentityMo(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		List<TeaIdentityMo> list = hibernateTemplate.findByExample(teaIdentityMo);
		return list.get(0);
	}

	@Override
	public void updateTeaIdentity(TeaIdentityMo tea) {
		// TODO Auto-generated method stub
		String sql = "update teaidentify set teaEducation=?,teaPicture=?,teaName=?,teaAge=?,teaArea=?,teaSchool=?,"
				+ "teaExperience=?,teaSex=?,teaDescription=?,teaMajor=?,teaIdCard=? where teacherNo = '"
				+ tea.getTeacherNo() + "'";
		Query pstmt = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		pstmt.setString(0, tea.getTeaEducation());
		pstmt.setString(1, tea.getTeaPicture().trim());
		pstmt.setString(2, tea.getTeaName());
		pstmt.setInteger(3, tea.getTeaAge());
		pstmt.setString(4, tea.getTeaArea());
		pstmt.setString(5, tea.getTeaSchool());
		pstmt.setString(6, tea.getTeaExperience());
		pstmt.setString(7, tea.getTeaSex());
		pstmt.setString(8, tea.getTeaDescription());
		pstmt.setString(9, tea.getTeaMajor());
		pstmt.setString(10, tea.getTeaIdCard());
		pstmt.executeUpdate();
	}

	@Override
	public void updateTeaIdentity1(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		String sql = "update teaidentify set teaIdCardImg = ?,teaCardImg= ? where teacherNo=?";
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setString(0, teaIdentityMo.getTeaCardImg().trim());
		query.setString(1, teaIdentityMo.getTeaCardImg().trim());
		query.setInteger(2, teaIdentityMo.getTeacherNo());
		query.executeUpdate();
	}

	@Override
	public void updateTeaIdentity2(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		String sql = "update teachert set teacherStage = ?,teacherClasses = ? where teacherNo=?";
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setString(0, teacherMo.getTeacherStage());
		query.setString(1, teacherMo.getTeacherClasses());
		query.setInteger(2, teacherMo.getTeacherNo());
		query.executeUpdate();
	}

	@Override
	public List<TeaInfoView> getTeaList1(int currentPage, int pageSize, String name, String stage, String sex,
			String subject, String sort) {
		// TODO Auto-generated method stub
		String s1 = stage.equals("") ? "" : " and teacherStage like '%" + stage + "%' ";
		String s2 = sex.equals("") ? "" : " and teaSex like '" + sex + "' ";
		String s3 = subject.equals("") ? "" : " and teacherClasses like '%" + subject + "%' ";
		String s4 = sort.equals("") ? "" : " order by " + sort + " desc ";
		if (stage != "" && subject != "") {
			s3 = " and teacherClasses like '%" + stage + subject + "%' ";
			s1 = "";
		}
		String sql = "select * from teacher_info where teaName like " + "'%" + name + "%'" + s1 + s2 + s3 + s4
				+ " limit " + (currentPage - 1) * pageSize + "," + pageSize;
		return hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.addEntity(TeaInfoView.class).list();

	}

	@Override
	public int getTeaCount1(String name, String stage, String sex, String subject, String sort) {
		// TODO Auto-generated method stub
		String s1 = stage.equals("") ? "" : " and teacherStage like '%" + stage + "%' ";
		String s2 = sex.equals("") ? "" : " and teaSex like '" + sex + "' ";
		String s3 = subject.equals("") ? "" : " and teacherClasses like '%" + subject + "%' ";
		String s4 = sort.equals("") ? "" : " order by " + sort + " desc ";
		if (stage != "" && subject != "") {
			s1 = " and teacherClasses like '%" + stage + subject + "%' ";
			s3 = "";
		}
		System.out.println(s2);
		System.out.println(s1);
		String sql = "select count(*) from teacher_info " + " where teaName like '%" + name + "%'" + s1 + s2 + s3 + s4;
		Object object = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql).list().iterator()
				.next();
		return ((BigInteger) object).intValue();
	}

	@Override
	public TeaInfoView getTeaInfoView(TeaInfoView teaInfoView) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(TeaInfoView.class, teaInfoView.getTeacherNo());
	}

	@Override
	public void UpdateTeaState(TeacherMo teacherMo, String teacherState) {
		// TODO Auto-generated method stub
		String hql = "update TeacherMo t set t.teacherState = ? where t.teacherNo = ?";
		hibernateTemplate.bulkUpdate(hql, teacherState, teacherMo.getTeacherNo());
	}

}
