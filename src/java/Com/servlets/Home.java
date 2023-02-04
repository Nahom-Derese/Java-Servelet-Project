
package Com.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description= "Sign-In Servlet" , urlPatterns = {"/home"})
public class Home extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        
        
    }
    
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Home Endpoint Hit !!");
        
        Cookie cookies[] = request.getCookies();
        
        String str = null;
        
        for(Cookie c : cookies){
            if(c.getName().equals("airlineSession")){
                str = c.getValue();
            }
        }
        
         for (String i : str.split("_")) {
             response.getWriter().println(i);
         }
        
    }
}
