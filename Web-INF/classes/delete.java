import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class delete extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String name=request.getParameter("donor_name");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
     out.println("<body bgcolor=\"#ffffff\">");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/blood_donation";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
    
     String query="Delete  from donor where donor_name='"+name+"'  ";
   
    int rs = st.executeUpdate( query );
   
     if (rs!=0){

    
	    
 	    out.println("<center><h1><strong>donor has been deleated</strong></h1></center><br>");
	   out.println("<a href='./home.html'><input type='button' value='Home' ></a>");
            out.println("<a href='./main.html'><input type='button' value='main' ></a>");
        

	  }
     
     else{
    	 out.println("<center><h1>No donor deleated</h1></center>");
         out.println("<a href='./home.html'><input type='button' value='home' ></a>");
          out.println("<a href='./main.html'><input type='button' value='main' ></a>");
          }


out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
