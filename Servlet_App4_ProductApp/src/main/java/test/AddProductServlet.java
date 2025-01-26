package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")

public class AddProductServlet extends GenericServlet
{
	public ProductBean pb = null;//instance variable
	public InsertDAO id = null;//instance variable
	public void init() throws ServletException
	{
		
		pb = new ProductBean();
		id = new InsertDAO();
	}
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pb.setCode(req.getParameter("pcode"));
		pb.setName(req.getParameter("pname"));
		pb.setPrice(Float.parseFloat(req.getParameter("pprice")));
		pb.setQty(Integer.parseInt(req.getParameter("pqty")));
		
		
		int k = id.insert(pb);//bean object as parameter
		
		
		
		if(k>0)
		{
			pw.println("Product added successfully...");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
	}
}

