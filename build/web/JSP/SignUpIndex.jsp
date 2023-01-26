<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/SignUpStyle.css">
    <title>Sign Up</title>
</head>
<body>
    <div class="signupContainer">
        <h3>Sign Up</h3>
        <form action="SignUp" method="post">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username" class="in" required>
            <p>Email</p>
            <input type="email" name="email" placeholder="@gmail.com" class="in" required>
            <p>Security Question</p>
            <select id="Question" name="question" class="in-select" required>
                <option value="What is your nickname?">What is your nickname?</option>
                <option value="What is your favorite Game?">What is your favorite Game?</option>
                <option value="where you wish to live?">where you wish to live?</option>
            </select>
            <p>Answer</p>
            <input type="text" name="answer" placeholder="what is your nickname?" class="in" id="answer" required>
            <span style="color: red; text-align: center; font-weight: bold;">${error}</span>
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password" class="in" required>
            <p>Confirm</p>
            <input type="password" name="confirm" placeholder="Confirm Password" class="in" required>
            <input type="submit" value="Create account">
            <div class="anchor">
                Already have an account? 
            <a href="../index.jsp">Login</a>
            </div>
        </form>
    </div>
    <script>
    let q=document.getElementById('Question');
    let a=document.getElementById('answer');
    q.addEventListener("change",function(){
        a.setAttribute("placeholder",q.value);
    });


    </script>
</body>
</html>