package cn.yunxue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yunxue.dao.BuyClassDao;
import cn.yunxue.dao.ClassDao;
import cn.yunxue.dao.StudentDao;
import cn.yunxue.dao.TeacherDao;
import cn.yunxue.model.BuyClassMo;
import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;
import cn.yunxue.service.StudentService;

@Transactional
@Service
@Scope("prototype")
public class StudentServiceImpl implements StudentService {
	@Autowired
	@Qualifier("studentDaoImpl")
	private StudentDao studentDao;

	@Autowired
	@Qualifier("teacherDaoImpl")
	private TeacherDao teacherDao;

	@Autowired
	@Qualifier("buyClassDaoImpl")
	private BuyClassDao buyClassDao;

	@Autowired
	@Qualifier("classDaoImpl")
	private ClassDao classDao;

	@Override
	public int checkPhone(String phone) {
		// TODO Auto-generated method stub
		if (studentDao.QueryStu(phone)) {
			return 3;
		} else if (teacherDao.QueryTea(phone)) {
			return 2;
		}
		return 1;
	}

	@Override
	public int login(StudentMo studentMo) {
		// TODO Auto-generated method stub
		return studentDao.loginCheck(studentMo);
	}

	@Override
	public StudentMo getStuMsg(StudentMo studentMo) {
		// TODO Auto-generated method stub
		return studentDao.getStuAcPhone(studentMo.getStuPhone());
	}

	@Override
	public void register(StudentMo studentMo) {
		// TODO Auto-generated method stub
		studentDao.InsertStu(studentMo);
	}

	@Override
	public void insertOrder(BuyClassMo buyclassMo) {
		// TODO Auto-generated method stub
		// studentDao.InsertStu();
		buyClassDao.insertBuyClass(buyclassMo);
	}

	@Override
	public void buyClass(BuyClassMo buyClassMo, StudentMo studentMo) {
		// TODO Auto-generated method stub
		buyClassDao.updateBuyState(buyClassMo);
		int stuMoney = studentDao.getStuAcNo(studentMo.getStuNo()).getStuMoney() + studentMo.getStuMoney();
		studentMo.setStuMoney(stuMoney);
		studentDao.updateStuMoney(studentMo);
	}

	@Override
	public List<ClassResumeView> getFinishClass(StudentMo studentMo) {
		// TODO Auto-generated method stub
		ClassResumeView classResumeView = new ClassResumeView();
		classResumeView.setStuNo(studentMo.getStuNo());
		classResumeView.setCourseState2("2");
		return classDao.getFinishClass(classResumeView);
	}

	@Override
	public List<ClassResumeView> getTimeTable(StudentMo studentMo) {
		// TODO Auto-generated method stub
		return classDao.getTimeTable(studentMo);
	}

	@Override
	public void updateStu(StudentMo studentMo) {
		// TODO Auto-generated method stub
		studentDao.updateStu(studentMo);
	}

	@Override
	public void updateStu1(StudentMo studentMo) {
		// TODO Auto-generated method stub
		studentDao.updateStu1(studentMo);
	}

}
