package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/update")

public class UpdateBookServlet extends GenericServlet
{
	public BookBean bb = null;
	public UpdateBookDAO ub = null;
	public void init() throws ServletException
	{
		bb = new BookBean();
		ub = new UpdateBookDAO();
	}
	
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException, IOException
	{
		bb.setBcode(req.getParameter("bcode"));
		bb.setBname(req.getParameter("bname"));
		bb.setBauthor(req.getParameter("bauthor"));
		bb.setBprice(Float.parseFloat(req.getParameter("bprice")));
		bb.setBqty(Integer.parseInt(req.getParameter("bqty")));
		
		int k = ub.updateBook(bb);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(k>0)
		{
			pw.println("Book Updated successfully...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("Book is nnot updated...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("CheckBookCode.html");
			rd.include(req, res);
		}
	}
}
