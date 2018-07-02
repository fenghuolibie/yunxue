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
 * 教师计划课表
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "class")
public class ClassMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer classNo;
	private Integer teacherNo;
	private Integer stuNo;
	private String classDate;
	private String classTime;
	private String classState;
	private String classComt;
	private String classLevel;
	private String className;
	private String classMoney;
	private String classReview;
	private String courseState2;
}
