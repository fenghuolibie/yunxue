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
 * 学生上课履历视图
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "class_resume")
public class ClassResumeView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer classNo;
	private Integer stuNo;
	private Integer teacherNo;
	private String teacherName;
	private String stuName;
	private String teaPicture;
	private String className;
	private String classDate;
	private String classTime;
	private String classLevel;
	private String classReview;
	private String classComt;
	private String classState;
	private String classMoney;
	/**
	 * 2:代表课已上完;1代表还未上
	 */
	private String courseState2;
}
