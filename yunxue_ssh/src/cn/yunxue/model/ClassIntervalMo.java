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
 * 课程时段设置表，属于静态表
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "classinterval")
public class ClassIntervalMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，根据所在数据库生成
	private int intervalNo;
	private String intervalDate;
	private String intervalTime;
}
