package edu.lstc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.dao.WorkerDao;

/**
 * 类名：WorkerUpdate 
 * 功能：修改员工信息
 */
public class WorkerUpdate extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 下面是Action内用于封装用户请求参数的属性
	private String wno = "unknow";
	private String wname = "unknow";
	private String post = "unknow";
	private String dno = "unknow";
	private String state = "unknow";
	private String bankcode = "unknow";

	public WorkerUpdate() {
	}

	public WorkerUpdate(String wno, String wname, String post, String dno,
			String state, String bankcode) {
		this.wno = wno;
		this.wname = wname;
		this.post = post;
		this.dno = dno;
		this.state = state;
		this.bankcode = bankcode;
	}

	public String getWno() {
		return wno;
	}

	public void setWno(String wno) {
		this.wno = wno;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	/*
	 * 处理用户请求的execute方法
	 */
	public String execute() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false;
		//验证是否正常登录

			if(!"unknow".equals(wname))	{
				b1 = new WorkerDao().UpdateName(wno, wname);		
			} 
			if(!"unknow".equals(post)){
				b2 = new WorkerDao().UpdatePost(wno, post);
			}
			if(!"unknow".equals(dno))	{
				b3 = new WorkerDao().UpdateDepartment(wno, dno);
			}
			if(!"unknow".equals(state))	{
				b4 = new WorkerDao().UpdateState(wno, state);
			}
			if(!"unknow".equals(bankcode))	{
				b5 = new WorkerDao().UpdateBankcode(wno, bankcode);
			}
		
    	if(b1 || b2 || b3 || b4 || b5){
			out.print("<script language='javascript'>alert('员工信息修改成功---');window.location='WorkerUpdate.jsp';</script>");
			out.flush();
			out.close();
		} 
		return SUCCESS;
	}
	/*
	 * 测试本类中的方法是否正确
	 */
	public static void main(String args[]) {
		System.out.println("OK");
	}
}
