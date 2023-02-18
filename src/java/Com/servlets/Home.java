
package Com.servlets;

import Com.auth.Encryption;
import Com.auth.UserAuthentication;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description= "Sign-In Servlet" , urlPatterns = {"/home"})
public class Home extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Cookie cookies[] = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals("hospitalSession")) {
               c.setMaxAge(0);
               response.addCookie(c);
            }
        }
        
        
        response.sendRedirect("sign-in");
        
    }
    
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Home Endpoint Hit !!");
        
            String decrypted = Auth.processRequest(request);
            
            if(decrypted != null){
                
                // Setting Attributes
                request.setAttribute("User", decrypted);
                request.setAttribute("Page", "home");

                // Dispatchers
                RequestDispatcher home = request.getRequestDispatcher("/JSP/home.jsp");
                RequestDispatcher navbar = request.getRequestDispatcher("/JSP/nav_bar.jsp");

                // Include JSPs
                navbar.include(request, response);
                home.include(request, response);

            }else{
                
                // Log User Out
                RequestDispatcher rd=request.getRequestDispatcher("/JSP/sign_in_page.jsp"); 
                rd.forward(request, response);
        }
        
    }
}
