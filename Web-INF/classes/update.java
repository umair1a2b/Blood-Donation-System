import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class update extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String donor_name=request.getParameter("donor_name");
    String donor_no=request.getParameter("donor_no");
    String donor_address=request.getParameter("donor_address");
    String donor_blood_group=request.getParameter("donor_blood_group");
     String donor_email=request.getParameter("donor_email");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body background='33.jpg'>");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/blood_donation";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
    
     String query="Update donor set donor_no='"+donor_no+"',donor_address='"+donor_address+"',donor_blood_group='"+donor_blood_group+"',donor_email='"+donor_email+"' where donor_name='"+donor_name+"'  ";
   
    int rs = st.executeUpdate( query );
   
     if (rs!=0){

    
 	    out.println("<center><h1><strong>donor is updated</strong></h1></center><br>");
            out.println("<a href='./home.html'><input type='button' value='home' ></a>");
            out.println("<a href='./main.html'><input type='button' value='main' ></a>");
        

	  }
     
     else{
    	 out.println("<center><h1>No donor updated</h1></center>");
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
