package maccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class MYSQLConnect
*/
public class MYSQLConnect extends HttpServlet 
{
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
      response.setContentType("text/html");
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
         String query = "select *from users";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);

         while(rs.next())
         {
            response.getWriter().write(rs.getString("name") + " - " + rs.getString("pass") + "");
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}