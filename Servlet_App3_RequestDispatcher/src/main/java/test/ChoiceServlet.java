package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/choicen")

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
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("sub");
			rd.forward(req, res);
		}
	}
}
