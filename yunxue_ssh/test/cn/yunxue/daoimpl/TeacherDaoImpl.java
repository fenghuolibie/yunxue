package cn.yunxue.daoimpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yunxue.dao.TeacherDao;
import cn.yunxue.model.TeaInfoView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TeacherDaoImpl {

	@Autowired
	@Qualifier("teacherDaoImpl")
	private TeacherDao teacherDao;

	@Test
	public void getTeaCount1() {
		System.out.println(teacherDao.getTeaCount1("", "", "男", "", ""));
	}

	@Test
	public void getTeaList1() {
		List<TeaInfoView> list = teacherDao.getTeaList1(1, 4, "", "", "男", "", "");
		for (TeaInfoView teaInfoView : list) {
			System.out.println(teaInfoView);
		}
	}

}
