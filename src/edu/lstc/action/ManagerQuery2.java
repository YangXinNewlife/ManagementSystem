package edu.lstc.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.bean.Salary;
import edu.lstc.dao.SalaryDao;


/**
 * 类名：ManagerQuery2 
 * 功能：处理部门经理查询部门所有员工工资
 */

public class ManagerQuery2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 下面是Action内用于封装用户请求参数的属性
	private ArrayList<Salary> salary;
	private String dno = null;
	
	public String getDno() {
		return dno;
	}
	
	public void setDno(String dno) {
		this.dno = dno;
	}
	
	public ArrayList<Salary> getSalary() {
		return salary;
	}

	public void setSalary(ArrayList<Salary> salary) {
		this.salary = salary;
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
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(!(dno == null))	{
			if("2".equals(session.getAttribute("type"))){
				salary = new SalaryDao().GetList(dno);
			} else {
				out.print("<script language='javascript'>alert('请用其他身份登录！');window.location='login.jsp';</script>");
				out.flush();out.close();	return null;
			}
		}
		return SUCCESS;
	}
	/*
	 * 测试本类中的方法是否正确
	 */
	public static void main(String[] args) {
		System.out.println("OK");
	}


	
	
	
	
}
