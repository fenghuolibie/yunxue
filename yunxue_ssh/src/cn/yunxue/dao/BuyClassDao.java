package cn.yunxue.dao;

import cn.yunxue.model.BuyClassMo;

public interface BuyClassDao {
	/**
	 * 插入buyclass表订单数据
	 * @param buyclassMo
	 */
	public abstract void insertBuyClass(BuyClassMo buyclassMo);

	/**
	 * 将未支付状态改为支付
	 * @param buyclassMo
	 */
	public abstract void updateBuyState(BuyClassMo buyclassMo);
}
