package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/dis")

public class DisplayServlet implements Servlet 
{
	public void init(ServletConfig sc) throws ServletException
	{
		//NoCode
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pC = req.getParameter("pcode");
		String pN = req.getParameter("pname");
		float pP = Float.parseFloat(req.getParameter("pprice"));
		int pQ = Integer.parseInt(req.getParameter("pqty"));
		
		pw.println("===ProductDetails===");
		pw.println("<br>PCode: "+pC);
		pw.println("<br>PName: "+pN);
		pw.println("<br>PPrice: "+pP);
		pw.println("<br>PQty: "+pQ);
	}
	public void destroy()
	{
		//NoCode
	}
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
	public String getServletInfo()
	{
		return "DisplayServlet";
	}
}