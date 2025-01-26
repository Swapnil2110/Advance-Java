package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/sub")
public class SubtractionServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse res)
	throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			int v1 = Integer.parseInt(req.getParameter("v1"));
			int v2 = Integer.parseInt(req.getParameter("v2"));
			int v3 = v1-v2;
			
			pw.println("Subtraction: "+v3);
			
			
		}catch(Exception e) {
			pw.println("Enter Only Integer values...");
		}
		RequestDispatcher rd = req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}
}
