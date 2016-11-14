package edu.lstc.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 类名：Quit 
 * 功能：退出系统
 */
public class Quit extends ActionSupport{
	private static final long serialVersionUID = 1L;

	//处理用户请求的execute方法
	public String execute() throws Exception {
		//清除session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("id");
		
		return SUCCESS;
	}
	
}
