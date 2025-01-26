package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/dis")

public class DisplayServlet extends GenericServlet 
{
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pC = req.getParameter("pcode");
		String pN = req.getParameter("pname");
		float pP = Float.parseFloat(req.getParameter("pprice"));
		int pQ = Integer.parseInt(req.getParameter("pqty"));
		
		pw.println("===ProductDetails comes from HTML page===");
		pw.println("<br>PCode: "+pC);
		pw.println("<br>PName: "+pN);
		pw.println("<br>PPrice: "+pP);
		pw.println("<br>PQty: "+pQ);
	}
	
}