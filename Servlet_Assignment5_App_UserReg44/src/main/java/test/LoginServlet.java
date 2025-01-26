package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/log")

public class LoginServlet extends GenericServlet
{
	public UserBean ub=null;
	public LoginDAO ld=null;
	public void init() throws ServletException
	{
		ub = new UserBean();
		ld = new LoginDAO();
	}
	
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException, IOException
	{
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		
		String fname = ld.login(req);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(fname != null)
		{
			pw.println("Login Successfull...<br>");
			pw.println("Welcome User "+fname);
		}
		else
		{
			pw.println("Invalid UserName/Password...");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		
	}
	
}
