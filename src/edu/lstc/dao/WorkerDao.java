package edu.lstc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import edu.lstc.bean.Worker;
import edu.lstc.db.DBHelper;

/**
 * 类名：WorkerDao 
 * 功能：提供与员工处理相关的方法
 */
public class WorkerDao {
	/*
	 * 功能：验证登录
	 * 输入：username：用户名,password:密码,type:用户身份
	 * 输出:数据库中存在该用户且密码正确，则返回其员工号，否则返回null
	 */
	public String CheckLogin(String username, String password, String type){
		//将员工类型转化为数据库中的类型
		if(type.equals("manager"))
			type = "经理";
		else if(type.equals("worker"))
			type = "员工";
		else
			type = "boss";
		String id = null;
		String sql="select * from worker_info where wname='"+username+"' and pwd='"+password+"' and post='"+type+"'";
		//System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("wno");
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
			System.out.println(ex);
		}
		return id;
	}
	
	/*
	 * 功能：根据员工号得到员工信息
	 * 输入：id：员工号
	 * 输出:数据库中存在该员工，则返回其员工，所有信息，否则返回null
	 */
	public Worker GetBean(String id){
		String sql="select * from worker_info where wno='"+id+"'";
        //System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		Worker w = null;
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				String wno = rs.getString("wno");
				String wname = rs.getString("wname");
				String dno = rs.getString("dno");
				String sex = rs.getString("sex");
				String post = rs.getString("post");
				String state = rs.getString("state");
				String bankcode = rs.getString("bankcode");
				String pwd = rs.getString("pwd");
				w = new Worker(wno,wname,sex,post,bankcode,pwd,dno,state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return w;
	}
	/*
	 * 功能：根据部门编号得到该部门所有信息
	 * 输入：dno：部门编号
	 * 输出:得到部门的所有员工基本信息
	 */
	public ArrayList<Worker> GetList(String dno){
		String sql="select * from worker_info where dno='"+dno+"'";
		//System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ArrayList<Worker> workers = new ArrayList<Worker>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Worker worker = new Worker();
				worker.setWno(rs.getString("wno"));
				worker.setWname(rs.getString("wname"));
				worker.setSex(rs.getString("sex"));
				worker.setPost(rs.getString("post"));
				worker.setBankcode(rs.getString("bankcode"));
				worker.setDno(rs.getString("dno"));
				worker.setState(rs.getString("state"));

				workers.add(worker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return workers;
	}
	
	/*
	 * 功能：增加一个员工
	 * 输入：w:员工
	 * 输出:员工信息符合数据库的约束，则增加一个员工,返回TRUE,否则返回false
	 */
	public boolean SetBean(Worker w){
		String sql="insert into worker_info values('"+w.getWno()+"','"+w.getWname()+"','"+w.getDno()+"','"+w.getSex()+"','"+
				w.getPost()+"','"+w.getState()+"','"+w.getBankcode()+"','"+w.getPwd()+"')";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeQuery(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 功能：根据员工编号更新员工姓名
	 * 输入：wno:员工号，wname：员工姓名
	 * 输出:员工信息符合数据库的约束，则修改员工姓名,修改成功,返回true，否则返回false
	 */
	public boolean UpdateName(String wno,String wname){
		String sql="update worker_info set wname='"+wname+"'where wno='"+wno+"'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 功能：根据员工编号调换部门
	 * 输入：wno:员工号，dno：员工所属部门
	 * 输出:员工信息符合数据库的约束，则修改员工所属部门,修改成功，返回true，否则返回false
	 */
	public boolean UpdateDepartment(String wno,String dno){
		String sql="update worker_info set dno='"+dno+"'where wno='"+wno+"'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 功能：根据员工编号修改员工职位
	 * 输入：wno:员工号，post：员工职位
	 * 输出:员工信息符合数据库的约束，则修改员工的职位,修改成功，返回true，否则返回false
	 */
	public boolean UpdatePost(String wno,String post){
		//将职位编号转化为职位名称
		if(post.equals("01"))
			post ="经理";
		else if(post.equals("02"))
			post ="员工";
		else if(post.equals("03"))
			post ="boss";
		String sql="update worker_info set post='"+post+"'where wno='"+wno+"'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 功能：根据员工编号修改员工状态
	 * 输入：wno:员工号,state:员工状态
	 * 输出:员工信息符合数据库的约束，则修改员工的状态,修改成功,返回true,否则返回false
	 */
	public boolean UpdateState(String wno,String state){
		//将员工状态转为数据库状态名称
		if(state.equals("01"))
			state ="在职";
		else if(state.equals("02"))
			state ="休假";
		else if(state.equals("03"))
			state ="离职";
		String sql="update worker_info set state='"+state+"' where wno='"+wno+"'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 功能：根据员工编号修改员工银行卡号
	 * 输入：wno:员工号,bankcode：银行卡号
	 * 输出:员工信息符合数据库的约束，则修改员工的银行卡号,修改成功,返回true,否则返回false
	 */
	public boolean UpdateBankcode(String wno,String bankcode){
		String sql="update worker_info set bankcode='"+bankcode+"' where wno='"+wno+"'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 功能：根据员工编号修改员工密码
	 * 输入：no:员工号,old:旧密码,now:新密码
	 * 输出:员工信息符合数据库的约束，则修改员工的密码,修改成功,返回true,否则返回false
	 */
	public boolean UpdatePassword(String no,String old,String now){
		String sql="update worker_info set pwd='"+now+"' where pwd='"+old+"' and wno='"+no+"' ";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/*
	 * 测试本类中的方法是否正确
	 */
	public static void main(String[] args) {
		System.out.println("OK");
	}
}
