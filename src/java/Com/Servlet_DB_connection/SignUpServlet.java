package com.Servlet_DB_connection;

import java.sql.*;
import com.Crud.JdbcCrud;
import com.Entity.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uname = request.getParameter("username");
        String email = request.getParameter("email");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String upass = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        JdbcConnect jdbcConnect = new JdbcConnect();
        Connection con = jdbcConnect.CreateConnection();
        JdbcCrud jdbcCrud = new JdbcCrud();
        User user = new User(uname, email, question, answer, upass);
        
        
        
        boolean created=jdbcCrud.insert(user,con);
        
        if (!upass.equals(confirm)) {
                response.getWriter().println("not Successfully saved");
            } 
        else {
            if (created) {
                response.getWriter().println("Successfully saved");
            }
            else{
                response.getWriter().println("Change Username");
            }
        }

    }
}
