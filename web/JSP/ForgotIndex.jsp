<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="../CSS/ForgotStyle.css">
</head>
<body>
    <div class="forgotContainer">
        <h3>Forget Password</h3>
        <form action="Forgot" method="post">
            <p id="user-email">Username</p>
            <input type="text"name="username" placeholder="Enter Username" id="in" class="choose-text" required>
            <p>Security Question</p>
            <select name="question" name="" id="in-select" class="select-question" required>
                <option value="What is your nickname?">What is your nickname?</option>
                <option value="What is your favorite Game?">What is your favorite Game?</option>
                <option value="where you wish to live?">where you wish to live?</option>
            </select>
            <p>Answer</p>
            <input name="answer" type="text" id="in" placeholder="what is your nickname?" class="select-answer" required>
            <p>New Password</p>
            <input name="password" type="password" id="in" placeholder="Enter New Password" required>
            <p>Confirm</p>
            <input name="confirm" type="password" id="in" placeholder="Confirm Password" required> 
            <input type="submit" value="Save">
            <div class="anchor">
                I've remembered My password
                <a href="../index.jsp">Login</a>
            </div>
        </form>
    </div>
    <script>
        let q=document.querySelector(".select-question");
        let a=document.querySelector(".select-answer");
        q.addEventListener("change",function(){
            a.setAttribute("placeholder",q.value)
        })
    </script>
</body>
</html>