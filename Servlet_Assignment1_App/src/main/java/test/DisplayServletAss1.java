package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/dis")

public class DisplayServletAss1 implements Servlet
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
		String bC = req.getParameter("bcode");
		String bN = req.getParameter("bname");
		String bA = req.getParameter("bauthor");
		float bP = Float.parseFloat(req.getParameter("bprice"));
		int bQ = Integer.parseInt(req.getParameter("bqty"));
		
		pw.println("===BookDetails===");
		pw.println("<br>Book Code: "+bC);
		pw.println("<br>Book Name: "+bN);
		pw.println("<br>Book Author: "+bA);
		pw.println("<br>Book Price: "+bP);
		pw.println("<br>Book Quantity: "+bQ);
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
		return "ServletDisplay";
	}
}
