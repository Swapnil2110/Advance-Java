package test;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/view")

public class ViewBooksServlet extends GenericServlet 
{
	public ViewBooksDAO vb = null;
	
	public void init() throws ServletException
	{
		vb = new ViewBooksDAO();
	}
	
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList<BookBean> al = vb.viewBooks();
		if(al.size()==0)
		{
			pw.println("Books Not Available...<br>");
		}
		else
		{
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext())
			{
				BookBean bb = (BookBean)it.next();
				pw.println(bb.getBcode()+"&nbsp&nbsp"+
						   bb.getBname()+"&nbsp&nbsp"+
						   bb.getBauthor()+"&nbsp&nbsp"+
						   bb.getBprice()+"&nbsp&nbsp"+
						   bb.getBqty()+"<br>");
			}//end of loop
			BookBean bb = null;
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
	}
}
