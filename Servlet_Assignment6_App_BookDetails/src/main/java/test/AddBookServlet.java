package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/add")

public class AddBookServlet extends GenericServlet
{
	BookBean bb = null;
	AddBookDAO ab = null;
	public void init() throws ServletException
	{
		bb = new BookBean();
		ab = new AddBookDAO();
	}
	public void service(ServletRequest req, ServletResponse res)throws
	ServletException, IOException
	{
		bb.setBcode(req.getParameter("bcode"));
		bb.setBname(req.getParameter("bname"));
		bb.setBauthor(req.getParameter("bauthor"));
		bb.setBprice(Float.parseFloat(req.getParameter("bprice")));
		bb.setBqty(Integer.parseInt(req.getParameter("bqty")));
		
		int k = ab.addBook(bb);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(k>0)
		{
			pw.println("Book Added Successfully...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("Book is not Added to DB...");
			RequestDispatcher rd = req.getRequestDispatcher("AddBook.html");
			rd.include(req, res);
		}
	}
}
