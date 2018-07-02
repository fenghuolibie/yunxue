package cn.yunxue.serviceImpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yunxue.model.BuyClassMo;
import cn.yunxue.model.ClassResumeView;
import cn.yunxue.model.StudentMo;
import cn.yunxue.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceImpl {
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@Test
	public void insertOrder() {
		BuyClassMo buyclassMo = new BuyClassMo();
		buyclassMo.setBuyClassOrderNo("1");
		buyclassMo.setBuyState("1");
		studentService.insertOrder(buyclassMo);
	}

	@Test
	public void getFinishClass() {
		StudentMo studentMo = new StudentMo();
		studentMo.setStuNo(1);
		List<ClassResumeView> list = studentService.getFinishClass(studentMo);
		for (ClassResumeView classResumeView : list) {
			System.out.println(classResumeView);
		}
	}

	@Test
	public void updateStu() {
		StudentMo studentMo = new StudentMo();
		studentMo.setStuNo(3);
		studentMo.setStuImg("///");
		studentMo.setStuSex("男");
		// studentService.updateStu(studentMo);
		studentService.register(studentMo);
	}

	@Test
	public void updateStu1() {
		StudentMo studentMo = new StudentMo();
		studentMo.setStuNo(2);
		studentMo.setStuImg("///");
		studentService.updateStu1(studentMo);
	}

	@Test
	public void getStuMsg() {
		StudentMo studentMo = new StudentMo();
		studentMo.setStuPhone("18270953571");
		studentMo = studentService.getStuMsg(studentMo);
		System.out.println(studentMo);
		System.out.println(studentMo.getStuImg());
	}
}
