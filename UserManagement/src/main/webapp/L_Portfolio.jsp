<%--
  Created by IntelliJ IDEA.
  User: RAHUL THAKUR
  Date: 18-04-2024
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/L_Portilo.css">
    <title>Title</title>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">

</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">

<div class="container">
    <div class="forms-container">
        <div class="signin-signup">

            <form action="L_portfolio-servlet" class="sign-in-form" method="post">
                <h2 class="title">Sign in</h2>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Username" name="L_name"/>
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Password" name="L_password"/>
                </div>
                <input type="submit" value="Login" class="btn solid" />
                <p class="social-text">Or Sign in with social platforms</p>
                <div class="social-media">
                    <a href="#" class="social-icon">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a href="#" class="social-icon">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a href="#" class="social-icon">
                        <i class="fab fa-google"></i>
                    </a>
                    <a href="#" class="social-icon">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                </div>
            </form>


            <form action="R_Portfolio-servlet" class="sign-up-form" method="post">
                <h2 class="title">Sign up</h2>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Username" name="Uname" />
                </div>
                <div class="input-field">
                    <i class="fas fa-envelope"></i>
                    <input type="email" placeholder="Email"  name="Email"/>
                </div>
                <div class="input-field">
                    <i class="fas fa-envelope"></i>
                    <input type="text" placeholder="Mobile"  name="Mobile"/>
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Password"  name="Password"/>
                </div>
                <input type="submit" class="btn" value="Sign up" />

                <p class="social-text">Or Sign up with social platforms</p>
                <div class="social-media">
                    <a href="#" class="social-icon">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a href="#" class="social-icon">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a href="#" class="social-icon">
                        <i class="fab fa-google"></i>
                    </a>
                    <a href="#" class="social-icon">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                </div>
            </form>

        </div>
    </div>

    <div class="panels-container">
        <div class="panel left-panel">
            <div class="content">
                <h3>New to our community ?</h3>
                <p>
                    Discover a world of possibilities! Join us and explore a vibrant
                    community where ideas flourish and connections thrive.
                </p>
                <button class="btn transparent" id="sign-up-btn">
                    Sign up
                </button>
            </div>
            <img  src="https://i.ibb.co/6HXL6q1/Privacy-policy-rafiki.png" class="image" alt="" />
        </div>
        <div class="panel right-panel">
            <div class="content">
                <h3>One of Our Valued Members</h3>
                <p>
                    Thank you for being part of our community. Your presence enriches our
                    shared experiences. Let's continue this journey together!
                </p>
                <button class="btn transparent" id="sign-in-btn">
                    Sign in
                </button>
            </div>
            <img src="https://i.ibb.co/nP8H853/Mobile-login-rafiki.png"  class="image" alt="" />
        </div>
    </div>
</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
    const sign_in_btn = document.querySelector("#sign-in-btn");
    const sign_up_btn = document.querySelector("#sign-up-btn");
    const container = document.querySelector(".container");

    sign_up_btn.addEventListener("click", () => {
        container.classList.add("sign-up-mode");
    });

    sign_in_btn.addEventListener("click", () => {
        container.classList.remove("sign-up-mode");
    });

    var status = document.getElementById("status").value;

    if(status == "success"){
        swal("Congrats", "Account Creation Successfully ","success");
    }
    if(status == "failed"){
        swal("Sorry", "Wrong UserName Or Password  ","error");
    }

    if(status == "Invalid Password"){
        swal("Sorry", "Sorry Your Password Is Wrong 🤨 ","error");
    }
    if(status == "invalidUserName"){
        swal("Sorry", "OPPs Your UserName Is Wrong 💔  ","error");
    }

</script>

</body>
</html>
