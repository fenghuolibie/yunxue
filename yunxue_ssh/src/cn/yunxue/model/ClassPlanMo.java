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
 * 教师课程计划信息表，每个教师都有
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "classplan")
public class ClassPlanMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer planClassNo;
	private Integer teacherNo;
	private String planClassDate;
	private String planClassTime;
	private String planClassName;
	private String planClassState;
	private Integer classInterval;
}
