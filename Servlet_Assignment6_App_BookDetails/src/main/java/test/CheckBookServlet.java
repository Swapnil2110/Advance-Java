package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/checkbook")

public class CheckBookServlet extends GenericServlet
{
	public CheckBookDAO cb = null;
	public BookBean bb = null;
	public void init() throws ServletException
	{
		cb = new CheckBookDAO();
		bb = new BookBean();
	}
	
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException, IOException
	{
		bb.setBcode(req.getParameter("bcode"));
		String s1 = cb.checkBook(bb);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(s1 == null)
		{
			pw.println("Book Code Not Found...<br>");
			RequestDispatcher rd  = req.getRequestDispatcher("CheckBookCode.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("Book Code "+bb.getBcode()+" is Valid...<br>");
			pw.println("Fill following to update Book details...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("UpdateBook.html");
			rd.include(req, res);
		}
	}
}
