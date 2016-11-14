package edu.lstc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.bean.Worker;
import edu.lstc.dao.WorkerDao;

/**
 * 类名：WorkerAdd 
 * 功能：增加员工
 */
public class WorkerAdd extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 下面是Action内用于封装用户请求参数的属性
	private String wno;
	private String wname;
	private String post;
	private String dno;
	private String state;
	private String bankcode;
	private String password;
	private String sex;

	public WorkerAdd() {
	}

	public WorkerAdd(String wno, String wname, String post, String dno,
			String state, String bankcode, String password, String sex) {
		this.wno = wno;
		this.wname = wname;
		this.post = post;
		this.dno = dno;
		this.state = state;
		this.bankcode = bankcode;
		this.password = password;
		this.sex = sex;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/*
	 * 处理用户请求的execute方法
	 */
	public String execute() throws Exception {
		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		boolean b = false;
		if (wno == "") {
			out.print("<script language='javascript'>alert('请输入员工编号!');"
					+ "window.location='WorkerAdd.jsp';</script>");
		}

		if ("01".equals(sex))
			sex = "男";
		else if ("02".equals(sex))
			sex = "女";
		else
			sex = "未知";

		if ("01".equals(state))
			state = "在职";
		else if ("02".equals(state))
			state = "休假";
		else if ("03".equals(state))
			state = "离职";

		if ("01".equals(post))
			post = "经理";
		else if ("02".equals(post))
			post = "员工";
		else
			post = "boss";

		Worker w = new Worker(wno, wname, sex, post, bankcode, password, dno,
				state);
		b = new WorkerDao().SetBean(w);
		if(b){
			out.print("<script language='javascript'>alert('增加成功!');"
				+ "window.location='WorkerAdd.jsp';</script>");
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
