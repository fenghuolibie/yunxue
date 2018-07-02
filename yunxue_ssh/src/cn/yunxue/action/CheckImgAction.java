package cn.yunxue.action;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.yunxue.utils.CheckCodeUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckImgAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() {
		CheckCodeUtil checkCodeUtil = new CheckCodeUtil();
		try {
			ImageIO.write(checkCodeUtil.getImage(), "jpg", ServletActionContext.getResponse().getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}
