package test;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends GenericServlet
{
	public RetrieveDAO rd = null;
	public void init() throws ServletException
	{
		rd = new RetrieveDAO();
	}
	public void service(ServletRequest req, ServletResponse res)throws
	ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList<ProductBean> al = rd.retrieve();
		if(al.size()==0)
		{
			pw.println("Products Not Available...<br>");
		}
		else
		{
			Iterator<ProductBean> it = al.iterator();
			while(it.hasNext())
			{
				ProductBean pb = (ProductBean)it.next();
				pw.println(pb.getCode()+"&nbsp&nbsp"+
						   pb.getName()+"&nbsp&nbsp"+
						   pb.getPrice()+"&nbsp&nbsp"+
						   pb.getQty()+"<br>");
			}//end of loop
		}
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}
