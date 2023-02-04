
package Com.servlets;

import Com.db_controller.DB;
import Com.db_controller.Passenger;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(description= "Sign-In Servlet" , urlPatterns = {"/sign-in"})
public class SignInServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Signin Endpoint Hit !!");
        
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String keep = request.getParameter("keep");
        
        
        DB db = DB.instance;
        
        Connection connection = db.getconnection();
        
        PreparedStatement pst;
        ResultSet result;
        
        String sql = "SELECT * FROM passenger WHERE email = '" + email + "' AND password = '" + password + "';";
        try {
            pst = connection.prepareStatement(sql);
            result = pst.executeQuery();
            
            // checking if ResultSet is empty 
            if (result.next() == false) { 
                System.out.println("ResultSet is empty in Java"); 
                request.setAttribute("Error", "true");
                RequestDispatcher rd=request.getRequestDispatcher("./JSP/sign_in_page.jsp");  
                rd.include(request, response);  
            }
            else{
                Passenger p = new Passenger(result);
                 if(keep != null){
                      Cookie cookie = new Cookie("airlineSession", p.toString());
                      System.out.println(p.toString());
                      response.addCookie(cookie);
                 }
                 response.sendRedirect("home");
                System.out.println(p.getFirstName());
            }
        } catch (SQLException ex) {
            System.out.println("Error Happened");
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
         RequestDispatcher rd=request.getRequestDispatcher("/JSP/sign_in_page.jsp"); 
         rd.include(request, response);
        
    }
}
