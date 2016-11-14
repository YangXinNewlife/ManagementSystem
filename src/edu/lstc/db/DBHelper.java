package edu.lstc.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 类名：DBHelper 
 * 功能：与数据库建立连接
 */
public class DBHelper {
	
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=SalaryManagement";
	private String dbUser="sa";
	private String dbPassword="123456";
	
	//打开与数据库的连接
	public Connection getConn() {
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){
			System.out.println(e);
		}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			//System.out.println("OK");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
			
		}
		return conn;		
	}
	
	/*
	 * 测试本类中的方法是否正确
	 */
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
	}
}
