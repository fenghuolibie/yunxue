package cn.yunxue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity // 默认类名
@Table(name = "teacher_info")
public class TeaInfoView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teacherNo;
	private Integer teacherMoney;
	private Integer teaAge;
	private String teaName;
	private String teaSchool;
	private String teaPicture;
	private String teaSex;
	private String teacherSatisfaction;
	private String teacherStyle;
	private String teacherStage;
	private String teacherClasses;
	private String teaDescription;
	private String teaMajor;
	private String teaEducation;
	private String teaExperience;
}
