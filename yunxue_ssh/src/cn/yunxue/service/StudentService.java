package cn.yunxue.service;

import java.util.List;

import cn.yunxue.model.BuyClassMo;
import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;

public interface StudentService {
	/**
	 * 验证注册账号
	 * @param Phone
	 * @return 1:该账号未注册; 2:已注册为教师; 3：已注册为学生; 4:后端异常
	 */
	public abstract int checkPhone(String Phone);

	/**
	 * 学生登录业务
	 * @return 1:允许登录；2：密码错误；3：账号不存在；4：登录失败
	 */
	public abstract int login(StudentMo studentMo);

	/**
	 * 获得登录用户的所有信息
	 * @param studentMo
	 * @return
	 */
	public abstract StudentMo getStuMsg(StudentMo studentMo);

	/**
	 * 注册账号业务
	 * @param studentMo
	 */
	public abstract void register(StudentMo studentMo);

	/**
	 * 插入订单
	 * @param classPlanMo
	 */
	public abstract void insertOrder(BuyClassMo buyclassMo);

	/**
	 * 购买课时 1、将未支付状态改为支付  2、存入学生购买本金记录
	 * @param buyclassMo
	 */
	public abstract void buyClass(BuyClassMo buyClassMo, StudentMo studentMo);

	/**
	 * 获得学生未完成的课程
	 * @param studentMo
	 * @return
	 */
	public abstract List<ClassResumeView> getFinishClass(StudentMo studentMo);

	/**
	 * 获得学生将来7天之内的安排
	 * @param studentMo
	 * @return
	 */
	public abstract List<ClassResumeView> getTimeTable(StudentMo studentMo);

	/**
	 * 更改学生基本信息
	 * @param studentMo
	 */
	public abstract void updateStu(StudentMo studentMo);

	/**
	 * 更改学生照片
	 * @param studentMo
	 */
	public abstract void updateStu1(StudentMo studentMo);

}
