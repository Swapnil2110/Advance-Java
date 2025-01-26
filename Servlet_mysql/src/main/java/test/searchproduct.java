package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/search")
public class searchproduct extends GenericServlet
{
	public SearchDAO sd = null;
	public void init() throws ServletException
	{
		 sd = new SearchDAO();        
	}
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException,IOException
	{
	 	PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String str =  req.getParameter("empsearch");
		System.out.println(str+" passing value");
		ArrayList<empbean> al = sd.search(req.getParameter("empsearch"));
		if(al.size()==0) 
		{pw.println("error 404 ...<br>");}
		else 
		{
			Iterator<empbean> it = al.iterator();
			while(it.hasNext())
			{
				empbean eb = (empbean)it.next();
				pw.println(eb.getEmpid()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+eb.getEmpname()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+eb.getYerofexp()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+eb.getDesg()+"<br>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req,res);
		}
	}
}
