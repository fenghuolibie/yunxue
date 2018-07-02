package cn.yunxue.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.model.BuyClassMo;
import cn.yunxue.model.StudentMo;
import cn.yunxue.service.StudentService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BuyClassSuccessAction extends ActionSupport {

	private static final long serialVersionUID = -6788875737745052959L;
	private String bi;
	private String buyNo;
	/**
	 * ok成功
	 */
	private String buyMsg;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		StudentMo stu = (StudentMo) session.getAttribute("stuLoginer");
		int stuNo = stu.getStuNo();
		int stuMoney = Integer.parseInt(bi);
		StudentMo studentMo = new StudentMo();
		BuyClassMo buyClassMo = new BuyClassMo();
		studentMo.setStuNo(stuNo);
		studentMo.setStuMoney(stuMoney);

		studentService.buyClass(buyClassMo, studentMo);
		buyMsg = "ok";
		return SUCCESS;
	}

}
