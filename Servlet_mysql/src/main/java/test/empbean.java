package test;
import java.io.*;
@SuppressWarnings("serial")
public class empbean implements Serializable
{
	private String empid,empname,desg;
	private int yerofexp;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public int getYerofexp() {
		return yerofexp;
	}
	public void setYerofexp(int yerofexp) {
		this.yerofexp = yerofexp;
	}
	

}
