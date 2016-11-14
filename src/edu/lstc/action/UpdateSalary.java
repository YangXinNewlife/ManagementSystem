package edu.lstc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.dao.SalaryDao;
/**
 * 类名：DBHelper 
 * 功能：与数据库建立连接
 */
public class UpdateSalary extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	// 下面是Action内用于封装用户请求参数的属性
	private String wno ;
	private float basic;
	private float post;
	private float checking;
	private float allowance;
	private float insurance;
	private float tax;
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
		boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;
		
			if( Double.toString(basic) != null)
				b1 = new SalaryDao().UpdateBasic(wno, basic);
			if(Double.toString(post) != null)
				b2 = new SalaryDao().UpdatePost(wno, post);
			if(Double.toString(allowance) != null)
			   b3 = new SalaryDao().UpdateAllowance(wno, allowance);
			if(Double.toString(insurance) != null)
			    b4 = new SalaryDao().UpdateInsurance(wno, insurance);
			if(Double.toString(tax) != null)
			   b5 = new SalaryDao().UpdateTax(wno, tax);
			if(Double.toString(checking) != null)
			   b6 = new SalaryDao().UpdateChecking(wno, checking);
		
			return SUCCESS;
	}
	/*
	 * 测试本类中的方法是否正确
	 */
	public  static void main(String args[])	{
		System.out.println("OK");
	}
	
	public UpdateSalary() {}

	public UpdateSalary(String wno, float basic, float post, float allowance,float checking,
			float insurance, float tax) {
		this.wno = wno;
		this.basic = basic;
		this.post = post;
		this.allowance = allowance;
		this.insurance = insurance;
		this.tax = tax;
		this.checking = checking;
	}

	public String getWno() {
		return wno;
	}

	public void setWno(String wno) {
		this.wno = wno;
	}

	public float getBasic() {
		return basic;
	}

	public void setBasic(float basic) {
		this.basic = basic;
	}

	public float getPost() {
		return post;
	}

	public void setPost(float post) {
		this.post = post;
	}

	public float getAllowance() {
		return allowance;
	}

	public void setAllowance(float allowance) {
		this.allowance = allowance;
	}

	public float getInsurance() {
		return insurance;
	}

	public void setInsurance(float insurance) {
		this.insurance = insurance;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getChecking() {
		return checking;
	}

	public void setChecking(float checking) {
		this.checking = checking;
	}
	
}
