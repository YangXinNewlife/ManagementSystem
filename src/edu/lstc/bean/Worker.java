package edu.lstc.bean;
/**
 * 类名：Worker 
 * 功能：员工bean
 */
public class Worker {
	//员工的成员变量对应数据库中的员工表
	private String wno;
	private String wname;
	private String sex;
	private String post;
	private String bankcode;
	private String pwd;
	private String dno;
	private String state;
	
	public Worker()	{}

	public Worker(String wno, String wname, String sex, String post,
			String bankcode, String pwd, String dno ,String state) {
		this.wno = wno;
		this.wname = wname;
		this.sex = sex;
		this.post = post;
		this.bankcode = bankcode;
		this.pwd = pwd;
		this.dno = dno;
		this.state = state;
	}

	public String getWno() {
		return wno;
	}

	public void setWno(String nwnoo) {
		this.wno = nwnoo;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
}
