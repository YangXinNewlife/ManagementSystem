package edu.lstc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.lstc.bean.Salary;
import edu.lstc.db.DBHelper;

/**
 * 类名：SalaryDao 
 * 功能：提供与工资处理相关的方法
 */
public class SalaryDao {
	
	private Salary s;
	/*
	 * 功能：根据员工编号得到该员工工资
	 * 输入：workerno：员工编号
	 * 输出:数据库中存在该员工,返回其工资信息
	 */
	public Salary GetSalary(String workerno) {
		String sql = "select * from salary where wno='" + workerno + "'";
		//System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String wno = rs.getString("wno");
				float basic = rs.getFloat("basic");
				float post = rs.getFloat("post");
				float allowance = rs.getFloat("allowance");
				float checking = rs.getFloat("checking");
				float insurance = rs.getFloat("insurance");
				float tax = rs.getFloat("tax");
				s = new Salary(wno, basic, post, allowance, checking,
						insurance, tax);
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
		return s;
	}
	/*
	 * 功能：根据部门编号得到部门所有员工的工资信息
	 * 输入：dno：部门编号
	 * 输出:部门的工资ArrayList
	 */
	public ArrayList<Salary> GetList(String dno) {
		String sql = "select * from salary where wno  in (select wno from worker_info where dno='"
				+ dno + "')";
		//System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ArrayList<Salary> salary1 = new ArrayList<Salary>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Salary ss = new Salary();
				ss.setWno(rs.getString("wno"));
				ss.setBasic(rs.getFloat("basic"));
				ss.setPost(rs.getFloat("post"));
				ss.setAllowance(rs.getFloat("allowance"));
				ss.setChecking(rs.getFloat("checking"));
				ss.setInsurance(rs.getFloat("insurance"));
				ss.setTax(rs.getFloat("tax"));

				salary1.add(ss);
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
		return salary1;
	}
	/*
	 * 功能：得到所有员工的工资信息
	 * 输出:所有员工的工资ArrayList
	 */
	public ArrayList<Salary> GetAll() {
		String sql = "select * from salary";
		//System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ArrayList<Salary> salary2 = new ArrayList<Salary>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Salary ss = new Salary();
				ss.setWno(rs.getString("wno"));
				ss.setBasic(rs.getFloat("basic"));
				ss.setPost(rs.getFloat("post"));
				ss.setAllowance(rs.getFloat("allowance"));
				ss.setChecking(rs.getFloat("checking"));
				ss.setInsurance(rs.getFloat("insurance"));
				ss.setTax(rs.getFloat("tax"));

				salary2.add(ss);
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
		return salary2;
	}
	/*
	 * 功能：根据员工编号修改基本工资
	 * 输入：wno:员工编号,basic：基本工资
	 * 输出:员工信息符合数据库的约束，则修改员工的基本工资,修改成功,返回true,否则返回false
	 */
	public boolean UpdateBasic(String wno, float basic) {

		String sql = "update salary set basic='" + basic + "'where wno='" + wno
				+ "'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try {
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
	 * 功能：根据员工编号修改岗位工资
	 * 输入：wno:员工编号,post：岗位工资
	 * 输出:员工信息符合数据库的约束，则修改员工的考勤工资,修改成功,返回true,否则返回false
	 */
	public boolean UpdatePost(String wno, float post) {
		String sql = "update salary set post='" + post + "'where wno='" + wno
				+ "'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try {
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
	 * 功能：根据员工编号修改津贴
	 * 输入：wno:员工编号,allowance：津贴
	 * 输出:员工信息符合数据库的约束，则修改员工的津贴,修改成功,返回true,否则返回false
	 */
	public boolean UpdateAllowance(String wno, float allowance) {
		String sql = "update salary set allowance='" + allowance
				+ "'where wno='" + wno + "'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try {
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
	 * 功能：根据员工编号修改保险金
	 * 输入：wno:员工编号,insurance：保险金
	 * 输出:员工信息符合数据库的约束，则修改员工的保险金,修改成功,返回true,否则返回false
	 */
	public boolean UpdateInsurance(String wno, float insurance) {
		String sql = "update salary set insurance='" + insurance
				+ "'where wno='" + wno + "'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try {
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
	 * 功能：根据员工编号修改考勤工资
	 * 输入：wno:员工编号,checking：考勤工资
	 * 输出:员工信息符合数据库的约束，则修改员工的考勤工资,修改成功,返回true,否则返回false
	 */
	public boolean UpdateChecking(String wno, float checking) {

		String sql = "update salary set checking='"+checking+"' where wno='" + wno + "'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try {
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
	 * 功能：根据员工编号修改个人税
	 * 输入：wno:员工编号,tax：个人税
	 * 输出:员工信息符合数据库的约束，则修改员工的个人税,修改成功,返回true,否则返回false
	 */
	public boolean UpdateTax(String wno, float tax) {
		String sql = "update salary set tax='" + tax
				+ "'where wno='" + wno + "'";
		//System.out.println(sql);
		Statement stat = null;
		Connection conn = new DBHelper().getConn();
		try {
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
}
