package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/choice")

public class ChoiceServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse res)
	throws ServletException, IOException
	{
		String s1 = req.getParameter("s1");
		if(s1.equals("Add"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("add");
			rd.forward(req, res);
		}
		else if(s1.equals("Sub"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("sub");
			rd.forward(req, res);
		}
		else if(s1.equals("Mul"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("mul");
			rd.forward(req, res);
		}
		else if(s1.equals("Div"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("div");
			rd.forward(req, res);
		}
		else if(s1.equals("Mod"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("mod");
			rd.forward(req, res);
		}
	}
}
