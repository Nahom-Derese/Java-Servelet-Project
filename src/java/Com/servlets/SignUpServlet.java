/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.servlets;

import Com.db_controller.DB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;


@WebServlet(name = "SignUpServlet", urlPatterns = {"/sign-up"})
public class SignUpServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.getRequestDispatcher("/JSP/sign_up_page.jsp").forward(request, response);
        }catch(Exception e){
            System.out.println("Error");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SignUP POST Endpoint Hit !!");
        String email = request.getParameter("email");
        String fname = request.getParameter("name");
        String doB = request.getParameter("Dob");
        String gender = request.getParameter("gender");
        String BG = request.getParameter("BG");
        String P_ID = "PID/" + email;
        
        if(fname.split(" ").length < 2){
            request.setAttribute("Success", "true");
            RequestDispatcher rd = request.getRequestDispatcher("./JSP/sign_up_page.jsp");
            rd.include(request, response);
        }
        
        Date birthDate;
        
        try {
            birthDate = Date.valueOf(doB);
            System.out.println(birthDate.toString());
            String password = request.getParameter("password");
            Object admin = request.getParameter("admin");
            
            if(admin!= null){
                admin = true;
            }
            else{
                admin = false;
            }


            DB db = DB.instance;

            Connection connection = db.getconnection();
            
            System.out.println(connection);

            PreparedStatement pst;
            ResultSet result;

            String sql = "SELECT * FROM `patient` WHERE emailId = '" + email + "';";

                        try {
                            pst = connection.prepareStatement(sql);
                            result = pst.executeQuery();

                            // checking if ResultSet is empty 
                            if (result.next() == true) { 
                                System.out.println("Duplicate Email");
                                request.setAttribute("Duplicate", "true");
                                RequestDispatcher rd = request.getRequestDispatcher("./JSP/sign_up_page.jsp");  
                                rd.include(request, response); 
                            }
                            else{
                                String insert = "INSERT INTO `patient`(`P_ID`, `Name`, `DOB`, `Gender`, `BloodGroup`, `EmailID`, `password`)" + " values (?, ?, ?, ?, ?, ?, ?)";

                                PreparedStatement preparedSt = connection.prepareStatement(insert);

                                preparedSt.setString(1, P_ID);
                                preparedSt.setString(2, fname);
                                preparedSt.setDate  (3, birthDate);
                                preparedSt.setString(4, gender);
                                preparedSt.setString(5, BG);
                                preparedSt.setString(6, email);
                                preparedSt.setString(7, password);
//                                preparedSt.setString(8, address);

                                preparedSt.execute();
                                request.setAttribute("Success", "true");
                                RequestDispatcher rd = request.getRequestDispatcher("./JSP/sign_in_page.jsp");  
                                rd.forward(request, response);
                            }

                        }catch(Exception e){
                            System.out.println("Connection Problem");
                            System.out.println(e);
                        }
        }catch(Exception e){
            System.out.println("Date Problem");
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
