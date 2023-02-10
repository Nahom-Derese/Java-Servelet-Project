<%-- 
    Document   : sign_in_page
    Created on : Feb 1, 2023, 3:00:29 AM
    Author     : Nahom Derese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title></title>
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Marvel"
            />
        <link rel="stylesheet" href="CSS/SignUpStyle.css" />
    </head>
    <body>
        <nav>
            <div class="Logo">
                <img src="Assets/icons8-airport-100.png" alt="logo" class="LOGO" />
            </div>
        </nav>

        <main>
            <div class="container">
                <div class="sign_in">
                    <h1>Create an account</h1>
                    <span>
                        Save an average of 15% on thousands of hotels ans a member....it's
                        always free
                    </span>
                </div>
                <form action="sign-up" method="post">
                    <div class="sign_in_form">
                        <div class="form">
                            <div class="credentials">
                                <div class="Email">
                                    <input type="email" name="email" placeholder="Email address *" required>
                                </div>
                                <div class="Name">
                                    <input type="text" name="fname" placeholder="Full Name *" required>
                                </div>
                                <div class="Gender">
                                    <input type="text" name="lname" placeholder="Gender *" required>
                                </div>
                                <div class="DateOfBirth">
                                    <input type="date" name="doB" placeholder="Date of Birth *" required>
                                </div>
                                <div>
                                    <select >
                                        <option value="" disabled selected>Blood Group</option>
                                        <option value="AB">AB</option>
                                        <option value="B">B</option>
                                        <option value="A">A</option>
                                        <option value="O">O</option>
                                        <option value="O">O <sup>-</sup> </option>
                                    </select>
                                </div>
                                <div class="Password">
                                    <input type="password" name="password" placeholder="Password *" required>
                                </div>
                            </div>
                            <%
                                Object e = request.getAttribute("Duplicate");
                                if(e!=null){
                            %>
                            <div class="error">
                                User with provided email already exists ...
                            </div>
                            <%
                                }
                            %>
                            <div class="Checkbox">
                                <div style="margin-bottom: 5px; display:flex; align-items:center; justify-content: flex-start;">
                                    <input type="checkbox" name="admin" value="1"/>
                                    <span> Admin ? </span>
                                </div>
                            </div>
                            <div class="Details">
                                <span class="check">
                                    Selecting this checkbox will keep you signed in for 30 days.
                                    If you are using a public computer, uncheck this box to
                                    prevent unauthorized access to your account information.
                                </span><br><br>
                                <span>
                                    By signing up, you agree to our
                                    <a href="">Terms of Use</a> and <a href="">Privacy Policy</a>
                                </span>
                            </div>
                            <div class="buttons">
                                <button class="blob-btn">
                                    Continue
                                    <span class="blob-btn__inner">
                                        <span class="blob-btn__blobs">
                                            <span class="blob-btn__blob"></span>
                                            <span class="blob-btn__blob"></span>
                                            <span class="blob-btn__blob"></span>
                                            <span class="blob-btn__blob"></span>
                                        </span>
                                    </span>
                                </button>
                                <br />
                                <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
                                <defs>
                                <filter id="goo">
                                    <feGaussianBlur
                                        in="SourceGraphic"
                                        result="blur"
                                        stdDeviation="10"
                                        ></feGaussianBlur>
                                    <feColorMatrix
                                        in="blur"
                                        mode="matrix"
                                        values="1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 21 -7"
                                        result="goo"
                                        ></feColorMatrix>
                                    <feBlend
                                        in2="goo"
                                        in="SourceGraphic"
                                        result="mix"
                                        ></feBlend>
                                </filter>
                                </defs>
                                </svg>
                            </div>
                        </div>
                            
                    </div>
                    <div class="create">
                            <span> Don't have an account? <a href="sign-in">Login Instead</a></span>
                    </div>
                </form>
            </div>
        </main>

    </body>
</html>

