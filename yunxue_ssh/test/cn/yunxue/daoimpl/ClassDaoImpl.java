package cn.yunxue.daoimpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.yunxue.dao.ClassDao;
import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ClassDaoImpl {
	@Autowired
	@Qualifier("classDaoImpl")
	private ClassDao classDao;

	@Test
	@Transactional
	public void getTimeTable() {
		StudentMo studentMo = new StudentMo();
		studentMo.setStuNo(1);
		List<ClassResumeView> list = classDao.getTimeTable(studentMo);
		for (ClassResumeView classResumeView : list) {
			System.out.println(classResumeView);
		}
	}
}
