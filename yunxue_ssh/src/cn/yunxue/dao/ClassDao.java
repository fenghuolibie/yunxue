package cn.yunxue.dao;

import java.util.List;

import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;

/**
 * 针对视图class_resume
 * @author m1827
 *
 */
public interface ClassDao {
	/**
	 * 查询学生已完成课程
	 * @param studentMo
	 * @return
	 */
	public abstract List<ClassResumeView> getFinishClass(ClassResumeView classResumeView);

	/**
	 * 查询学生记录表
	 * @param studentMo
	 * @return
	 */
	public abstract List<ClassResumeView> getTimeTable(StudentMo studentMo);
}
