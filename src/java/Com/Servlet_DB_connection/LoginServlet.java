
package com.Servlet_DB_connection;

import com.Crud.JdbcCrud;
import com.Entity.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname=request.getParameter("username");
        String upass=request.getParameter("password");
        
        JdbcCrud jdbcCrud=new JdbcCrud();
        
        JdbcConnect jdbcConnect=new JdbcConnect();
        Connection con=jdbcConnect.CreateConnection();
        
        User user=jdbcCrud.SearchUsername(uname,con);
        
        HttpSession session=request.getSession();  
        if(user.getUname()==null){
//            session.setAttribute("Username_error","Username Doesn't Exist");
            response.sendRedirect("index.jsp");
        }
        else{
            if((user.getUpass()).equals(upass)){
                response.getWriter().println(user.getUname() +"Successfully Login");
            }
            else{
                 session.setAttribute("Password_error","Incorrect Password");
//                response.sendRedirect("index.jsp");
            }
        }
          
    }
}
