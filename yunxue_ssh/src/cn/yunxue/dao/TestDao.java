package cn.yunxue.dao;

import java.util.Iterator;
import java.util.List;

import cn.yunxue.model.TeaInfoView;

public interface TestDao {
	public abstract TeaInfoView get(int id);

	public abstract Iterator<?> update(TeaInfoView teaInfoView);

	public abstract List<TeaInfoView> getList(String name);
}
