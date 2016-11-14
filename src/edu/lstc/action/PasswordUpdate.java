package edu.lstc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.dao.WorkerDao;
/**
 * 类名：PasswordUpdate 
 * 功能：修改密码
 */

public class PasswordUpdate extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 下面是Action内用于封装用户请求参数的属性
	private String Password = null;
	private String Password2;
	private String wno;
	
	public PasswordUpdate() { }

	public PasswordUpdate(String password, String password2 ,String wno) {
		Password = password;
		Password2 = password2;
		this.wno = wno;
	}
	/*
	 * 处理用户请求的execute方法
	 */
	public String execute() throws Exception {
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		new WorkerDao().UpdatePassword(wno, Password, Password2);
		if(! (Password == null)){
			out.print("<script language='javascript'>alert('密码修改成功!');window.location='PasswordUpdate.jsp';</script>");
			out.flush();
			out.close();
		} 
		return SUCCESS;
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 * 测试本类中的方法是否正确
	 */
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPassword2() {
		return Password2;
	}
	public void setPassword2(String password2) {
		Password2 = password2;
	}
	public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
}
