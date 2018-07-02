package cn.yunxue.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExitAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("stuLoginer") != null) {
			session.removeAttribute("stuLoginer");
			return SUCCESS;
		} else if (session.getAttribute("teaLoginer") != null) {
			session.removeAttribute("teaLoginer");
			return SUCCESS;
		}
		return SUCCESS;
	}

}
