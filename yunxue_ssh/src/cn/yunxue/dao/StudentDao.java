package cn.yunxue.dao;

import cn.yunxue.model.StudentMo;

/**
 * @author m1827
 * 对student表的操作
 */
public interface StudentDao {

	/**
	 * 根据号码获得实体
	 * @param studentMo
	 * @return
	 */
	public abstract StudentMo getStuAcPhone(String stuPhone);

	/**
	 * 查询号码是否存在
	 * @return 
	 */
	public abstract Boolean QueryStu(String stuPhone);

	/**
	 * 插入学生信息
	 * @return 
	 */
	public abstract void InsertStu(StudentMo studentMo);

	/**
	 * 验证学生登录密码是否正确
	 * @return 
	 */
	public abstract Boolean checkStu(StudentMo studentMo);

	/**
	 * 根据stuNo获取学生实体
	 * @return 学生bean
	 */
	public abstract StudentMo getStuAcNo(int stuNo);

	/**
	 * 更新学生stuMoney信息
	 * @param studentMo
	 * @return
	 */
	public abstract void updateStuMoney(StudentMo studentMo);

	/**
	 * 登录验证
	 * @param studentMo
	 * @return 1:登录成功；2：密码错误；3：账号不存在；4：登录失败
	 */
	public abstract int loginCheck(StudentMo studentMo);

	/**
	 * 更改studentt表数据
	 * @param studentMo
	 * @return
	 */
	public abstract void updateStu(StudentMo studentMo);

	/**
	 * 更改studentt表学生照片
	 * @param studentMo
	 * @return
	 */
	public abstract void updateStu1(StudentMo studentMo);
}
