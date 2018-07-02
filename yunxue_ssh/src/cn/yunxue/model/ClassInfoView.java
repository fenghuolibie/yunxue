package cn.yunxue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author m1827
 * 学生课程信息视图
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "class_info")
public class ClassInfoView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private int classNo;
	private String teacherName;
	private String teaPicture;
	private String className;
	private String classDate;
	private String classTime;
	private String classLevel;
	private String classMoney;
	private String classComt;
	private String classState;
}
