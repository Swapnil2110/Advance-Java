package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/Servlet1")

public class Servlet1 extends GenericServlet 
{
	StateBean sb = null;
	AddStateDao as = null;
	
	public void init() throws ServletException
	{
		sb = new StateBean();
		as = new AddStateDao();
	}
	
	public void service(ServletRequest req, ServletResponse res) 
		throws ServletException, IOException 
	{
		sb.setScode(req.getParameter("code"));
		sb.setScode(req.getParameter("state"));
		
		int k = as.addState(sb);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(k>0)
		{
			pw.println("State Added Successfully...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("State is not Added to DB...");
			RequestDispatcher rd = req.getRequestDispatcher("Add.html");
			rd.include(req, res);
		}
		
	}

}
