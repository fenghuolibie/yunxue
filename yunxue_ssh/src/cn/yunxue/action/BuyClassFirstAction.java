package cn.yunxue.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyClassFirstAction extends ActionSupport {
	private String lgoinTip;
	private static final long serialVersionUID = 1L;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		Object stu = session.getAttribute("stuLoginer");
		if (stu == null) {
			request.setAttribute("loginTip", 1);
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}
