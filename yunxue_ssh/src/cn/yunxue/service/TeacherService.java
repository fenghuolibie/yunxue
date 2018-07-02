package cn.yunxue.service;

import java.util.List;

import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.utils.PageBean;

public interface TeacherService {
	/**
	 * 教师登录业务
	 * @return 1:允许登录；2：密码错误；3：账号不存在；4：登录失败
	 */
	public abstract int login(TeacherMo teacherMo);

	/**
	 * 根据电话号码获得登录用户的所有信息
	 * @param teacherMo
	 * @return
	 */
	public abstract TeacherMo getTeaMsg(TeacherMo teacherMo);

	/**
	 * 根据id获得登录用户的所有信息
	 * @param teacherMo
	 * @return
	 */
	public abstract TeacherMo getTeaMsg1(TeacherMo teacherMo);

	/**
	 * 注册账号业务
	 * @param  teacherMo
	 */
	public abstract void register(TeacherMo teacherMo);

	/**
	 * 根据name字段和当前页相应数据
	 * @param name
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public abstract PageBean<TeaInfoView> getTeaList(String name, int pageSize, int currentPage);

	/**
	 * 根据具体信息进行更复杂的查询
	 * @param currentPage
	 * @param pageSize
	 * @param name 姓名
	 * @param stage 阶段
	 * @param sex 性别
	 * @param subject 科目
	 * @param sort 排序
	 * @return
	 */
	public PageBean<TeaInfoView> getTeaList1(int currentPage, int pageSize, String name, String stage, String sex,
			String subject, String sort);

	/**
	 * 初始化教师状态 1:在teaidentify中生成默认记录 2:在ClassPlan生成默认课表记录 3、在teachert中初始化教师数据
	 * @param teacherMo
	 */
	public abstract void initTeaState(TeacherMo teacherMo);

	/**
	 * 获取教师通过了几层验证 0:通过0层；1：通过1层；2：通过两层；3通过三层（完成认证）
	 * @param teacherMo
	 */
	public abstract String getTeaState(TeacherMo teacherMo);

	/**
	 * 根据教师对象信息获得教师详细信息
	 * @param teaIdentityMo
	 * @return
	 */
	public abstract TeaIdentityMo getTeaIdentity(TeaIdentityMo teaIdentityMo);

	/**
	 * 更新一阶段教师详细信息表数据,把教师状态改为1
	 * @param teaIdentityMo
	 */
	public abstract void updateTeaIdentity(TeaIdentityMo teaIdentityMo);

	/**
	 * 更新二阶段教师详细信息表数据
	 * @param teaIdentityMo
	 */
	public abstract void updateTeaIdentity1(TeaIdentityMo teaIdentityMo);

	/**
	 * 更新三阶段教师详细信息表数据
	 * @param teaIdentityMo
	 */
	public abstract void updateTeaIdentity2(TeacherMo teacherMo, List<String> time);

	/**
	 * 获取教师计划课表
	 * @param teaIdentityMo
	 * @return 
	 */
	public abstract List<ClassPlanMo> getTeaClassPlan(TeaIdentityMo teaIdentityMo);

	/**
	 * 更新教师课程计划表
	 * @param teacherMo
	 * @param list
	 */
	public abstract void updateTeaClassPlan(TeacherMo teacherMo, List<String> list);

	/**
	 * 根据教师详细视图bean获取教师对象
	 * @param teaInfoView
	 * @return 
	 */
	public abstract TeaInfoView getTeaInfoView(TeaInfoView teaInfoView);

	/**
	 * 更新课程信息；1、教师端课表状态更新，2、学生课时表更新
	 * @param stuNo
	 * @param planNo
	 * @param s
	 * @param money
	 */
	public void updateclassname(int stuNo, String[] planNo, String[] s, int money);

}
