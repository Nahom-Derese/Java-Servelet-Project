
package com.Servlet_DB_connection;

import com.Crud.JdbcCrud;
import com.Entity.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ForgotServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String uname=request.getParameter("username");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String upass = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        
        JdbcCrud jdbcCrud=new JdbcCrud();
        
        
        JdbcConnect jdbcConnect=new JdbcConnect();
        Connection con=jdbcConnect.CreateConnection();
        
        
        User user=jdbcCrud.SearchUsername(uname,con);
        
           
        
        
        if(user.getEmail()==null){
            response.getWriter().println("username doesn't exist");
        }
        else{
            User userNewData= new User(uname,user.getEmail(),question,answer,upass);
            boolean forgot=jdbcCrud.Forgot(userNewData, con);
            if((userNewData.getQuestion().equals(question)) && (userNewData.getAnswer().equals(answer))){
                if(forgot){
                    response.getWriter().println("Successfully Forgotten");
                    response.getWriter().println(userNewData.getUname()+" "+userNewData.getUpass()+" "+
                            userNewData.getAnswer()+" "+userNewData.getEmail()+" "+userNewData.getQuestion());
                }
            }
            else{
                response.getWriter().println("Incorrect question and answer");
                
            }
        }
    }
}
