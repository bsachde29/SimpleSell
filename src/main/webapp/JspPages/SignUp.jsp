<%--
  Created by IntelliJ IDEA.
  User: shivambairoliya
  Date: 2/28/21
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body style="overflow: hidden">
<div class="back login">
    <div class="li_su_box">
        <div class="logo login">
            <img src="img/logo.png">
        </div>

        <div class="login_txt">
            <section class="si_txt">Create Account. </section>
            <input class="su_txt_box name" id="firstName" type="text" placeholder="First Name">
            <input class="su_txt_box name" id="lastName" type="text" placeholder="Last Name">
            <input class="su_txt_box" id="email" type="text" placeholder="Email ID">
            <input class="su_txt_box" id="mobileNumber" type="text" placeholder="Mobile Number">
            <input class="su_txt_box" id="password" type="text" placeholder="Password">
            <input class="su_txt_box" id="re-password" type="text" placeholder="Re-type Password">
            <input class="su_txt_box" id="storeName" type="text" placeholder="Store Name">
        </div>

        <div>
            <button id="su_but">Start Selling!</button>
            <button><a href = "${pageContext.request.contextPath}/SignUp">Hello</a> Start Selling!</button>
            <script>
                console.log("${pageContext.request.contextPath}/SignUp");
            </script>
        </div>
    </div>
</div>
<script src="js/jquery-3.5.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-confirm.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/main.js"></script>

</body>
</html>
