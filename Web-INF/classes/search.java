import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class search extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String name=request.getParameter("donor_name");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");

out.println("asdf");
    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/blood_donation";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
    
     String query="Select * from donor where donor_name='"+name+"' ";
   
     ResultSet rs = st.executeQuery( query );
   
     if(rs.next()){

	    out.println("<h1>Record found</h1>");

    	    String donor_name = rs.getString("donor_name");
    	    String donor_no = rs.getString("donor_no");
           String donor_address = rs.getString("donor_address");
         String donor_email = rs.getString("donor_email");


    	    out.println("<h1>Donor Name: "+donor_name+" </h1>");
	    out.println("<h1>Donor no: "+ donor_no+ " </h1>");
            out.println("<h1>Donor address : "+ donor_address+ " </h1>");
            out.println("<h1>Donor email: "+ donor_email+ " </h1>");
			out.println("<a href='./home.html'><input type='button' value='home' ></a>");
            out.println("<a href='./main.html'><input type='button' value='main' ></a>");

	  }
     
     else{
    	 out.println("<h1>No record found</h1>");
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
