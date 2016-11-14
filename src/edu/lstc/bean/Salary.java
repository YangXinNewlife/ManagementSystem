package edu.lstc.bean;
/**
 * 类名：Salary 
 * 功能：工资bean
 */
public class Salary {
	//工资的成员变量对应数据库中的工资表
	private String wno;
	private float basic;
	private float post;
	private float allowance;
	private float checking;
	private float insurance;
	private float tax;
	
	public Salary() {}
	
	public Salary(String wno, float basic, float post, float allowance,
			float checking, float insurance, float tax) {
		this.wno = wno;
		this.basic = basic;
		this.post = post;
		this.allowance = allowance;
		this.checking = checking;
		this.insurance = insurance;
		this.tax = tax;
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
	public float getChecking() {
		return checking;
	}
	public void setChecking(float checking) {
		this.checking = checking;
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
}
