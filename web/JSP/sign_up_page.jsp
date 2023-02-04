<%-- 
    Document   : sign_in_page
    Created on : Feb 1, 2023, 3:00:29 AM
    Author     : Nahom Derese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link
          rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Marvel"
        />
        <link rel="stylesheet" href="CSS/SignInStyle.css" />
        <title>Sign In Page</title>
    </head>
    <body>
        <%
            Object e = request.getAttribute("Error");
        %>
    <nav>
      <div class="Logo">
        <img src="Assets/icons8-airport-100.png" alt="logo" class="LOGO" />
      </div>
    </nav>

    <main>
      <div class="container">
        <div class="sign_in">
          <h1>Sign in</h1>
          <span>
              Save an average of 15% on thousands of hotels ans a member....it's always free
          </span>
        </div>
          <form method="post" action="sign-in">
          <div class="sign_in_form">
            <div class="form">
                <div class="credentials">
                    <div class="Email">
                        <input type="email" name="email" placeholder="Email address *" required>
                      </div>
                      <div class="Password">
                        <input type="password" name="password" placeholder="Password *" required>
                      </div>
                </div>
                
                <c:set var = "error" scope = "session" value = "${e}"/>
                <c:if test = "${error.equals('true')}">
                    <div class="error">
                        User with provided credential doesn't exist ...
                    </div>
                </c:if>
              <div class="Checkbox">
                <input type="checkbox" name="keep" value="1" />
                <span> Keep me signed in </span>
              </div>
              <div class="Details">
                <span class="check">
                  Selecting this checkbox will keep you signed in for 30 days.
                  If you are using a public computer, uncheck this box to
                  prevent unauthorized access to your account information.<%=e%>
                </span><br><br>
                <span>
                  By signing in, you agree to our
                  <a href="">Terms of Use</a> and <a href="">Privacy Policy</a>
                </span>
              </div>
              <div class="buttons">
                <button class="blob-btn">
                  Sign in
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
            <div class="forget">
              <a href=""> Forgot password ?</a>
            </div>
            <div class="create">
              <span> Don't hava an account? <a href="">Create one</a></span>
            </div>
          </div>
        </form>
      </div>
    </main>

    <!-- <script src="" async defer></script> -->
  </body>
</html>
