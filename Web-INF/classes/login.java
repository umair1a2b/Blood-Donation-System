import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class login extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    String donor_name=request.getParameter("donor_name");
 
String donor_email=request.getParameter("donor_email");


    

    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/blood_donation";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

    String query="Select * from donor where donor_name='"+donor_name+"' and donor_email='"+donor_email+"'";
   
     ResultSet rs = st.executeQuery( query );     
    
     if(rs.next())
	 {
		 
		// HttpSession s = request.getSession(false);
		 //s.setAttribute("user_logged",true);

	    out.println("<h1>Record found</h1>");
            out.println("<a href='./main.html'><input type='button' value='main' ></a>");
      
     
	  }

     else{
     
      out.println("<h1 style= color:blue;>Wrong Name or email</h1>");
      response.sendRedirect("login.html");
}

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
