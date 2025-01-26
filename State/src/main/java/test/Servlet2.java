package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/Servlet2")

public class Servlet2 extends GenericServlet
{
	public ViewStateDAO vd = null;
	
	public void init() throws ServletException
	{
		vd = new ViewStateDAO();
	}
	public void service(ServletRequest req, ServletResponse res) 
		throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList<StateBean> al = vd.viewState();
		if(al.size()==0)
		{
			pw.println("State Not Available...<br>");
		}
		else
		{
			Iterator<StateBean> it = al.iterator();
			while(it.hasNext())
			{
				StateBean sb = (StateBean)it.next();
				pw.println(sb.getScode()+"&nbsp&nbsp"+
						   sb.getSname()+"&nbsp&nbsp"+
						   "<br>");
			}//end of loop
			StateBean bb = null;
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
	}

}
