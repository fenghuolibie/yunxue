package cn.yunxue.dao;

import java.util.List;

import cn.yunxue.model.TeaIdentityMo;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;

public interface TeacherDao {
	/**
	 * 查询号码是否存在
	 * @return 
	 */
	public abstract Boolean QueryTea(String teaPhone);

	/**
	 * 插入教师信息
	 * @return 
	 */
	public abstract void InsertTea(TeacherMo teacherMo);

	/**
	 * 验证教师登录密码是否正确
	 * @return 
	 */
	public abstract Boolean checkTea(TeacherMo teacherMo);

	/**
	 * 根据teaherNo获取教师实体
	 * @return 
	 */
	public abstract TeacherMo getTeaAcNo(int teaNo);

	/**
	 * 更新教师基本表信息
	 * @param 
	 * @return
	 */
	public abstract void updateTea(TeacherMo teacherMo);

	/**
	 * 登录验证
	 * @param teacherMo
	 * @return 1:登录成功；2：密码错误；3：账号不存在；4：登录失败
	 */
	public abstract int loginCheck(TeacherMo teacherMo);

	/**
	 * 根据字符串搜索教师集合
	 * @param currentPage 当前页数
	 * @param pagesize 页面实体数
	 * @param name 查询字符
	 * @return 所需集合
	 */
	public abstract List<TeaInfoView> getTeaList(int currentPage, int pagesize, String name);

	/**
	 * 根据多个信息搜索教师集合
	 * @param currentPage
	 * @param pageSize
	 * @param name
	 * @param stage
	 * @param sex
	 * @param subject
	 * @param sort
	 * @return
	 */
	public List<TeaInfoView> getTeaList1(int currentPage, int pageSize, String name, String stage, String sex,
			String subject, String sort);

	/**
	 * 根据name字段查询教师总数量
	 * @param name
	 * @return
	 */
	public abstract int getTeaCount(String name);

	/**
	 * 根据教师多个字段查询教师总数量
	 * @param name
	 * @param stage
	 * @param sex
	 * @param subject
	 * @param sort
	 * @return
	 */
	public int getTeaCount1(String name, String stage, String sex, String subject, String sort);

	/**
	 * 插入教师详细信息表
	 * @param phone
	 */
	public abstract void InsertTeaIdentify(TeaIdentityMo teaIdentityMo);

	/**
	 * 根据号码获得教师表实体
	 * @param Phone
	 */
	public abstract TeacherMo getTeaAcPhone(String Phone);

	/**
	 * 获得详细信息表
	 * @param teaIdentityMo
	 * @return
	 */
	public abstract TeaIdentityMo getTeaIdentityMo(TeaIdentityMo teaIdentityMo);

	/**
	 * 更新教师认证状态信息
	 * @param teacherMo
	 * @param teacherState
	 */
	public abstract void UpdateTeaState(TeacherMo teacherMo, String teacherState);

	/**
	 * 插入1阶段教师详细信息表
	 * @param teaIdentityMo
	 */
	public abstract void updateTeaIdentity(TeaIdentityMo teaIdentityMo);

	/**
	 * 插入2阶段教师详细信息表
	 * @param teaIdentityMo
	 */
	public abstract void updateTeaIdentity1(TeaIdentityMo teaIdentityMo);

	/**
	 * 更新3阶段教师详细信息表
	 * @param teacherMo
	 */
	public abstract void updateTeaIdentity2(TeacherMo teacherMo);

	/**
	 * 根据教师详细视图bean获取教师对象
	 * @param teaInfoView
	 * @return 
	 */
	public abstract TeaInfoView getTeaInfoView(TeaInfoView teaInfoView);
}
