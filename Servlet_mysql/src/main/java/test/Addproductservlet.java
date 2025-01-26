package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class Addproductservlet extends GenericServlet
{
	
	public InsertDAO id = null;
	public empbean eb = null;
	
	public void init() throws javax.servlet.ServletException
	{
		
		id = new InsertDAO();
		eb = new empbean();
	}
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException,IOException
	{
		eb.setEmpid(req.getParameter("slct1"));
		eb.setEmpname(req.getParameter("slct2"));
		eb.setYerofexp(Integer.parseInt(req.getParameter("exp")));
		eb.setDesg(req.getParameter("deg"));
		int k = id.insert(eb);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(k>0)
		{
			pw.println("Employee added successfully....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req,res);
		}
		else
		{
			pw.println("not successfully try again....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req,res);
		}
	}
}