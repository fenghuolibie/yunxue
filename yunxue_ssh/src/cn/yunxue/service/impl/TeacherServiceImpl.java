package cn.yunxue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yunxue.dao.BindingTeacherDao;
import cn.yunxue.dao.ClassPlanDao;
import cn.yunxue.dao.StudentDao;
import cn.yunxue.dao.TeacherDao;
import cn.yunxue.model.BindingTeacherMo;
import cn.yunxue.model.ClassIntervalMo;
import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.TeacherService;
import cn.yunxue.utils.PageBean;
import cn.yunxue.utils.UploadUtil;

@Transactional
@Service
@Scope("prototype")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	@Qualifier("studentDaoImpl")
	private StudentDao studentDao;

	@Autowired
	@Qualifier("bindingTeacherDaoImpl")
	private BindingTeacherDao bindingTeacherDao;

	@Autowired
	@Qualifier("teacherDaoImpl")
	private TeacherDao teacherDao;

	@Autowired
	@Qualifier("classPlanDaoImpl")
	private ClassPlanDao classPlanDao;

	@Override
	public int login(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		return teacherDao.loginCheck(teacherMo);
	}

	@Override
	public TeacherMo getTeaMsg(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		return teacherDao.getTeaAcPhone(teacherMo.getTeacherPhone());
	}

	@Override
	public void register(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		teacherDao.InsertTea(teacherMo);
		this.initTeaState(teacherMo);
	}

	@Override
	public PageBean<TeaInfoView> getTeaList(String name, int pageSize, int currentPage) {
		// TODO Auto-generated method stub
		PageBean<TeaInfoView> pageBean = new PageBean<>();
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(teacherDao.getTeaCount(name));
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageList(teacherDao.getTeaList(currentPage, pageSize, name));
		return pageBean;
	}

	@Override
	public void initTeaState(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		// 获取教师编号
		TeacherMo teacherMo1 = teacherDao.getTeaAcPhone(teacherMo.getTeacherPhone());
		// 验证状态设为0
		teacherMo1.setTeacherState("0");
		teacherDao.updateTea(teacherMo1);
		// 初始化详细教师表，默认头像，
		int teacherNo = teacherMo1.getTeacherNo();
		TeaIdentityMo teaIdentityMo = new TeaIdentityMo();
		teaIdentityMo.setTeacherNo(teacherNo);
		teaIdentityMo.setTeaPicture(UploadUtil.BASEPATH + "IMG/teacherIMG/DEFAULT.jpg");
		teacherDao.InsertTeaIdentify(teaIdentityMo);
		// 生成默认课表
		int count = classPlanDao.getCount();
		ClassIntervalMo classIntervalMo = new ClassIntervalMo();
		for (int i = 1; i <= count; i++) {
			classIntervalMo = classPlanDao.get(i);
			ClassPlanMo classPlanMo = new ClassPlanMo();
			classPlanMo.setPlanClassDate(classIntervalMo.getIntervalDate());
			classPlanMo.setPlanClassTime(classIntervalMo.getIntervalTime());
			classPlanMo.setClassInterval(classIntervalMo.getIntervalNo());
			classPlanMo.setTeacherNo(teacherNo);
			classPlanMo.setPlanClassState("0");
			System.out.println("-----------------------------------");
			classPlanDao.insertClassPlan(classPlanMo);
			System.out.println("-----------------------------------");
		}

	}

	@Override
	public String getTeaState(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		return teacherDao.getTeaAcNo(teacherMo.getTeacherNo()).getTeacherState();
	}

	@Override
	public TeaIdentityMo getTeaIdentity(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		return teacherDao.getTeaIdentityMo(teaIdentityMo);
	}

	@Override
	public void updateTeaIdentity(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		// int a = 1 / 0;
		teacherDao.updateTeaIdentity(teaIdentityMo);
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherNo(teaIdentityMo.getTeacherNo());
		teacherDao.UpdateTeaState(teacherMo, "1");
	}

	@Override
	public void updateTeaIdentity1(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		teacherDao.updateTeaIdentity1(teaIdentityMo);
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherNo(teaIdentityMo.getTeacherNo());
		teacherDao.UpdateTeaState(teacherMo, "2");
	}

	@Override
	public List<ClassPlanMo> getTeaClassPlan(TeaIdentityMo teaIdentityMo) {
		// TODO Auto-generated method stub
		return classPlanDao.getTeaClassPlan(teaIdentityMo);
	}

	@Override
	public void updateTeaIdentity2(TeacherMo teacherMo, List<String> time) {
		// TODO Auto-generated method stub
		teacherDao.updateTeaIdentity2(teacherMo);
		this.updateTeaClassPlan(teacherMo, time);
		teacherDao.UpdateTeaState(teacherMo, "3");
	}

	@Override
	public void updateTeaClassPlan(TeacherMo teacherMo, List<String> time) {
		// TODO Auto-generated method stub
		int teacherNo = teacherMo.getTeacherNo();
		for (String classNo : time) {
			classPlanDao.updateClassPlan(teacherNo, Integer.parseInt(classNo));
		}
	}

	@Override
	public PageBean<TeaInfoView> getTeaList1(int currentPage, int pageSize, String name, String stage, String sex,
			String subject, String sort) {
		// TODO Auto-generated method stub
		PageBean<TeaInfoView> pageBean = new PageBean<>();
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(teacherDao.getTeaCount1(name, stage, sex, subject, sort));
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageList(teacherDao.getTeaList1(currentPage, pageSize, name, stage, sex, subject, sort));
		return pageBean;
	}

	@Override
	public TeaInfoView getTeaInfoView(TeaInfoView teaInfoView) {
		// TODO Auto-generated method stub
		return teacherDao.getTeaInfoView(teaInfoView);
	}

	@Override
	public void updateclassname(int stuNo, String[] planClassNo, String[] s, int money) {
		// TODO Auto-generated method stub
		for (int i = 0; i < planClassNo.length; i++) {
			int classNo = Integer.parseInt(planClassNo[i]);
			// 更新课程计划表
			classPlanDao.updateClassPlan1(classNo, s[i]);
			BindingTeacherMo bindingTeacherMo = new BindingTeacherMo();
			bindingTeacherMo.setStuNo(stuNo);
			bindingTeacherMo.setBindMoney(money);
			bindingTeacherMo.setPlanClassNo(classNo);
			// 插入学生订单表
			bindingTeacherDao.insertBinding(bindingTeacherMo);
		}
	}

	@Override
	public TeacherMo getTeaMsg1(TeacherMo teacherMo) {
		// TODO Auto-generated method stub
		return teacherDao.getTeaAcNo(teacherMo.getTeacherNo());
	}
}
