package edu.lstc.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.dao.WorkerDao;

public class GoLogin extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String Username;
	private String Password;
	private String Type;
	private String Msg;
	
	

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	
	public String execute() throws Exception {

	
		if (Username != null && Password != null) {
			
			byte[] bs = Username.getBytes("ISO-8859-1");
			byte[] bs1 = Password.getBytes("ISO-8859-1");
			Username = new String(bs, "utf-8");
			Password = new String(bs1, "utf-8");
		}
		

		if (Type.equals("worker")) {
			String type = "worker";
			
			if (null == new WorkerDao().CheckLogin(Username, Password, type)) {
				Msg = "用户名或密码错误，请重新登录";
				return INPUT;
				
			} else {
				String Worker_ID = new WorkerDao().CheckLogin(Username,
						Password, type);
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				session.setAttribute("id", Worker_ID);
				session.setAttribute("type", "1");
				
			
				return SUCCESS;
			}
		} else if (Type.equals("manager")) {
			String type = "manager";
			if (null == new WorkerDao().CheckLogin(Username, Password, type)) {
				Msg = "用户名或密码错误，请重新登录";
				return INPUT;
			} else {
				String Manage_ID = new WorkerDao().CheckLogin(Username,
						Password, type);
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				session.setAttribute("id", Manage_ID);
				session.setAttribute("type", "2");
				return SUCCESS;
			}
		} else {
			String type = "manager";
			if (null == new WorkerDao().CheckLogin(Username, Password, type)) {
				Msg = "用户名或密码错误，请重新登录";
				return INPUT;
			} else {
				String Worker_ID = new WorkerDao().CheckLogin(Username,
						Password, type);
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				session.setAttribute("id", Worker_ID);
				session.setAttribute("type", "3");
				return SUCCESS;
			}
		}
	}

}
