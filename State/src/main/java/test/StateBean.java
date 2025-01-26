package test;
import java.io.*;


public class StateBean implements Serializable 
{
	private String sname, scode;
	public StateBean() {}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	
}
