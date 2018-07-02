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
 * 教师注册表，基本身份信息
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "teachert")
public class TeacherMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer teacherNo;
	private String teacherPhone;
	private String teacherPwd;
	private String teacherName;
	private String teacherSatisfaction;
	private String teacherStyle;
	private Integer teacherMoney;
	private String teacherClasses;
	private String teacherStage;
	private String teacherState;
}
