package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/dis")

public class DisplayServlet implements Servlet
{
	public void init(ServletConfig sc) throws ServletException
	{
		//NoCode	
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		//code
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String eId = req.getParameter("eid");
		String eN = req.getParameter("ename");
		String eD = req.getParameter("edesg");
		float eB = Float.parseFloat(req.getParameter("ebal"));
		
		pw.println("===EmployeeDetails===");
		pw.println("<br>Employee ID: "+eId);
		pw.println("<br>Employee Name: "+eN);
		pw.println("<br>Employee Designation: "+eD);
		pw.println("<br>Employee Balance: "+eB);
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
		return "DisplayServlet";
	}
	
}
