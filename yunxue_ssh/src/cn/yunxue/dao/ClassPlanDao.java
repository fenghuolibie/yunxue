package cn.yunxue.dao;

import java.util.List;

import cn.yunxue.model.ClassIntervalMo;
import cn.yunxue.model.ClassPlanMo;
import cn.yunxue.model.TeaIdentityMo;

public interface ClassPlanDao {
	/**
	 * 插入数据到课程计划表
	 */
	public abstract void insertClassPlan(ClassPlanMo classPlanMo);

	/**
	 * 根据id获取查询ClassInterval表数据
	 * @param id
	 * @return
	 */
	public abstract ClassIntervalMo get(int id);

	/**
	 * 获取ClassInterval表数据总量
	 * @return
	 */
	public abstract int getCount();

	/**
	 * 获取教师的课程计划表（42)
	 * @param teaIdentityMo
	 * @return
	 */
	public abstract List<ClassPlanMo> getTeaClassPlan(TeaIdentityMo teaIdentityMo);

	/**
	 * 根据课时号和教师号更新课表状态为1（0:不上课 1：上课 2：被预约)
	 * @param teacherNo
	 * @param ClassInterval
	 */
	public abstract void updateClassPlan(int teacherNo, int ClassInterval);

	/**
	 * 根据课时号和教师号更新课表状态为2（0:不上课 1：上课 2：被预约) 和更新课程计划学科名
	 * @param planClassNo
	 */
	public abstract void updateClassPlan1(int planClassNo, String className);
}
