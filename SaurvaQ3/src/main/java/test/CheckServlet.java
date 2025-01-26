package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/check")
public class CheckServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse res) 
	throws ServletException, IOException 
	{
		try {
			int age = Integer.parseInt(req.getParameter("uage"));
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			if(age>=18)
			{	
				pw.println("Person "+req.getParameter("uname")+" is eligible for voting.");
			}
			else
			{
				pw.println("Person "+req.getParameter("uname")+" is not eligible for voting.");
			}
		}catch(Exception e) {e.printStackTrace();}
	}
}
