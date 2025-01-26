package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/reg")

public class RegisterServlet extends GenericServlet 
{
	public UserBean ub = null;//instance variable
	public RegisterDAO rd = null;//instance variable
	
	public void init() throws ServletException
	{
		ub = new UserBean();
		rd = new RegisterDAO();
	}
	
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException,IOException
	{
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		
		int k = rd.register(ub);//bean object as parameter
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(k>0)
		{
			pw.println("User Registered Successfully...");
			RequestDispatcher rqd = req.getRequestDispatcher("login.html");
			rqd.include(req, res);
		}
	}
}
