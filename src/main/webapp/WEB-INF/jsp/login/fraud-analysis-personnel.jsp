<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Login</title>
    <link href="../css/login.css" rel="stylesheet" type="text/css">
    <script src="../js/loginValidation.js" type="text/javascript"></script>
</head>

<body>
    <div class="container">
        <h1>Login as Fraud Analysis Personnel</h1>
        <form method="post" onsubmit="return validate()">
            <label>User ID</label>
            <input id="userId" type="text" name="id" placeholder="Enter Your ID" autofocus required />
            <p id="userIdError"></p>
            <label>Password</label>
            <input id="password" type="password" name="password" placeholder="Enter Password" required />
            <p id="passwordError"></p>
            <button class="login-btn" type="submit">Login</button>
            <a href="/fraud-analysis-personnel-forgot-password">Forgot Password?</a>
            <a href="/register/fraud-analysis-personnel">Don't have an account? Signup</a>
        </form>
    </div>
</body>

</html>