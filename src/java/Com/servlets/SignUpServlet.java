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
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author Jembere
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/sign-up"})
public class SignUpServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.getRequestDispatcher("/JSP/sign_up_page.jsp").forward(request, response);
        }catch(Exception e){
            
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
        
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String doB = request.getParameter("dateOfBirth");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date birthDate;
        try {
            birthDate = (Date) sdf.parse(doB);
        
            String password = request.getParameter("password");
            String keep = request.getParameter("keep");


            DB db = DB.instance;

            Connection connection = db.getconnection();

            PreparedStatement pst;
            ResultSet result;

            String sql = "SELECT * FROM `passenger` WHERE email = '" + email + "';";

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
                                String insert = "INSERT INTO `passenger`(`firstName`, `lastName`, `password`, `dateOfBirth`, `balance`, `countryOfResidence`, `createdAt`, `updatedAt`, `email`)" + " values (?, ?, ?, ?, ?, ?,?, ?, ?)";

                                PreparedStatement preparedSt = connection.prepareStatement(insert);

                                preparedSt.setString(1, fname);
                                preparedSt.setString(2, lname);
                                preparedSt.setString(9, email);
                                preparedSt.setString(3, password);
                                preparedSt.setDate(4, birthDate);
                                preparedSt.setDouble(5, 200000.0);
                                preparedSt.setString(6, "Ethiopia");
                                preparedSt.setDate(7, Date.valueOf(LocalDate.now()));
                                preparedSt.setDate(8, Date.valueOf(LocalDate.now()));

                                preparedSt.execute();
                                request.setAttribute("Success", "true");
                                RequestDispatcher rd = request.getRequestDispatcher("./JSP/sign_in_page.jsp");  
                                rd.forward(request, response);
                            }

                        }catch(Exception e){
                            System.out.println(e);
                        }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
