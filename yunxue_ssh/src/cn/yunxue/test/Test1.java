package cn.yunxue.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.yunxue.dao.StudentDao;
import cn.yunxue.dao.TeacherDao;
import cn.yunxue.dao.TestDao;
import cn.yunxue.model.TeaInfoView;
import cn.yunxue.model.TeacherMo;
import cn.yunxue.service.StudentService;
import cn.yunxue.service.TeacherService;
import cn.yunxue.utils.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	@Autowired
	@Qualifier("studentDaoImpl")
	private StudentDao studentDao;

	@Autowired
	@Qualifier("testDaoImpl")
	private TestDao testDao;

	@Autowired
	@Qualifier("teacherDaoImpl")
	private TeacherDao teacherDao;

	@Test
	public void test1() {
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherPhone("18270953570");
		teacherMo.setTeacherPwd("123456");
		assertEquals(true, teacherDao.checkTea(teacherMo));
	}

	@Test
	public void test3() {
		// System.out.println(testDao.get(3));
		// TeaInfoView teaInfoView = new TeaInfoView();
		// teaInfoView.setTeaAge(21);
		// teaInfoView.setTeacherNo(3);
		// testDao.update(teaInfoView);
		System.out.println(testDao.get(3));
		TeacherMo teacherMo = teacherDao.getTeaAcNo(3);
		teacherMo.setTeacherNo(3);
		teacherMo.setTeacherMoney(100);
		teacherDao.updateTea(teacherMo);
		System.out.println(testDao.get(3));
	}

	@Test
	public void test4() {
		PageBean<?> pageBean = teacherService.getTeaList("刘", 4, 2);
		List<?> list = pageBean.getPageList();
		for (Object object : list) {
			System.out.println(object.toString());
		}
		// System.out.println(teacherDao.getTeaCount(""));
		// System.out.println(pageBean.getStart() + "|||" + pageBean.getEnd());
	}

	@Test
	public void test5() {
		List<TeaInfoView> list = testDao.getList("刘");
		System.out.println(list.size());
		for (TeaInfoView teaInfoView : list) {
			System.out.println(teaInfoView.toString());
		}
	}

	@Test
	public void test6() {
		TeacherMo teacherMo = new TeacherMo();
		teacherMo.setTeacherPhone("18211111111");
		teacherService.initTeaState(teacherMo);
	}

	@Test
	@Transactional
	public void test7() {
		testDao.update(null);
		// System.out.println(testDao.get(1));
	}

	@Test
	public void test8() {
		long a = 1000l;
		System.out.println(a);

	}
}
