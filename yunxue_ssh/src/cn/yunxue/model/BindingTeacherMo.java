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
 * 学生课表订单
 * @author m1827
 * 
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "bindingteacher")
public class BindingTeacherMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer bindNo;
	private Integer stuNo;
	private Integer planClassNo;
	private Integer bindMoney;
}
