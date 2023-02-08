
package Com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(description= "Sign-In Servlet" , urlPatterns = {"/home"})
public class Home extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Cookie cookies[] = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals("airlineSession")) {
               c.setMaxAge(0);
               response.addCookie(c);
            }
        }
        
        response.sendRedirect("sign-in");
        
    }
    
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Home Endpoint Hit !!");
        
        Cookie cookies[] = request.getCookies();
        
        String str = null;
        
        for(Cookie c : cookies){
            if(c.getName().equals("airlineSession")){
                str = c.getValue();
            }
        }
        
        RequestDispatcher rd=request.getRequestDispatcher("/JSP/home.jsp"); 
        rd.include(request, response);
        System.out.println(request.getAttribute("User"));
//        HttpSession session = request.getSession();
//        if (str == null) str = (String) session.getAttribute("User");
//        
//        for (String i : str.split("_")) {
//                response.getWriter().println(i + "<br> <br>");
//            }
//        response.setContentType("text/HTML");
//        response.getWriter().println("<form method=\"post\" action=\"home\">");
//        response.getWriter().println("<input type=\"logout\" name=\"keep\" value=\"1\" hidden=\"true\"/>");
//        response.getWriter().println("<button class=\"blob-btn\" type=\"submit\"> Logout </button>");
//        response.getWriter().println("</form>");
    }
}
