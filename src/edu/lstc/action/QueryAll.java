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
 * 类名：QueryAll 
 * 功能：查询所有员工的工资信息
 */

public class QueryAll extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	// 下面是Action内用于封装用户请求参数的属性
	private ArrayList<Salary> salary;
	
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

		salary = new SalaryDao().GetAll();
	
		return SUCCESS;
	}
	/*
	 * 测试本类中的方法是否正确
	 */
	public static void main(String[] args) {
		System.out.println();
	}
	
}
