package cn.yunxue.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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

@Getter
@Setter
public class BuyClassOrderAction extends ActionSupport {

	private static final long serialVersionUID = 9054196604103715294L;

	private String box1;
	private String box2;
	private String box3;
	private String box4;
	private String box5;
	private String box8;
	private String box10;
	private String buyNo;
	private int yunbi;
	private boolean flag;

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		StudentMo stu = (StudentMo) session.getAttribute("stuLoginer");
		int stuNo = stu.getStuNo();
		flag = true;
		String buyStuStage = box1;
		String buyStuGrade = box2;
		String Amount = box3;
		String Money = box4; // 放回
		System.out.println(box4);
		String Amount2 = box8;
		String bi = box5;
		String bi2 = box10;
		int buyMoney = Integer.parseInt(Money);
		this.yunbi = Integer.parseInt(bi) + Integer.parseInt(bi2);
		int buyAmount = Integer.parseInt(Amount) + Integer.parseInt(Amount2);
		BuyClassMo buy = new BuyClassMo();
		buy.setStuNo(stuNo);
		buy.setBuyStuStage(buyStuStage);
		buy.setBuyStuGrade(buyStuGrade);
		buy.setBuyAmount(buyAmount);
		buy.setBuyMoney(buyMoney);
		buy.setBuyState("未支付");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Long buyNo1 = Long.parseLong(dateFormat.format(new Date())) * 10000;
		String orderNo = buyNo1.toString() + UUID.randomUUID().toString().substring(6, 15);
		this.buyNo = orderNo;
		buy.setBuyClassOrderNo(orderNo);
		studentService.insertOrder(buy);

		return SUCCESS;
	}

}
