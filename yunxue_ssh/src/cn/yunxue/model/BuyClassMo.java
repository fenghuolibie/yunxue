package cn.yunxue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//购买课时订单
@Getter
@Setter
@ToString
@Entity
@Table(name = "buyclass")
public class BuyClassMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private Integer buyNo;
	private Integer stuNo;
	private String buyStuStage;
	private Integer buyAmount;
	private Integer buyMoney;
	private String buyState;
	private String buyStuGrade;
	private String buyClassOrderNo;
}
