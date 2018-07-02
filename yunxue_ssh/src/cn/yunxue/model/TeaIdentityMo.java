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
 * 教师详细信息表（设计的不好）
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "teaidentify")
public class TeaIdentityMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成,@Entity默认类名
	private Integer teaIdentityNo;
	private Integer teacherNo;
	private String teaName;
	private Integer teaAge;
	private String teaArea;
	private String teaSchool;
	private String teaIdCard;
	private String teaIdCardImg;
	private String teaCardImg;
	private String teaPicture;
	private String teaExperience;
	private String teaSex;
	private String teaDescription;
	private String teaMajor;
	private String teaEducation;
}
