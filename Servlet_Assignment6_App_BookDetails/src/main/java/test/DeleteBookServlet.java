package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/delete")

public class DeleteBookServlet extends GenericServlet
{
	public BookBean bb = null;
	public DeleteBookDAO db = null;
	public void init() throws ServletException
	{
		bb = new BookBean();
		db = new DeleteBookDAO();
	}
	
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		bb.setBcode(req.getParameter("bcode"));
		//check if book code is available in database or not...
		String str = db.checkBookCode(bb);
		if(str != null)
		{
			int k = db.deleteBook(bb);
			if(k>0)
			{
				pw.println("Book Deleted successfully...");
				RequestDispatcher rd = req.getRequestDispatcher("input.html");
				rd.include(req, res);
			}
			
		}
		else
		{
			pw.println("Invalid Book Code, Please enter valid BookCode...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("DeleteBook.html");
			rd.include(req, res);
		}
	}

}
