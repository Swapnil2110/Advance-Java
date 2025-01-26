package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/first")
public class FirstServlet implements Servlet 
{
	public void init(ServletConfig sc) throws javax.servlet.ServletException
	{
		//No Code
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Welcome to Servlet Programming...");
	}
	public void destroy()
	{
		//NoCode
	}
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
	public String getServletInfo()
	{
		return "FirstServlet";
	}
}