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
 * 学生表基本信息
 */
@Getter
@Setter
@ToString
@Entity // 默认类名
@Table(name = "studentt")
public class StudentMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer stuNo;
	private String stuPhone;
	private String stuPwd;
	private String stuName;
	private Integer stuMoney;
	private String stuState;
	private String stuImg;
	private String stuBirth;
	private String stuSex;
	private String stuStage;
	private String stuSchool;
}
