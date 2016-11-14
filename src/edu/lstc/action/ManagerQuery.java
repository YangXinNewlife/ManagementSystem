package edu.lstc.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.lstc.bean.Worker;
import edu.lstc.dao.WorkerDao;
/**
 * 类名：ManagerQuery 
 * 功能：经理查询员工的基本信息
 */
public class ManagerQuery extends ActionSupport {
	// 下面是Action内用于封装用户请求参数的属性
	private static final long serialVersionUID = 1L;
	private ArrayList<Worker> workers;
	private String dno = null;
	
	public String getDno() {
		return dno;
	}
	
	public void setDno(String dno) {
		this.dno = dno;
	}
	
	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
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
System.out.println(session.getAttribute("type"));
			if("2".equals(session.getAttribute("type"))){
				workers = new WorkerDao().GetList(dno);
				/*for(int i=0;i<workers.size();i++){
					System.out.println(workers.get(i));
				}*/
			
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
