<%--
  Created by IntelliJ IDEA.
  User: RAHUL THAKUR
  Date: 22-04-2024
  Time: 06:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Montserrat:700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="CSS/Std_Register.css">
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    <title>Student CURD</title>
</head>
<body>

<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">

<main style="width: 80%; height: 70%">
    <figure>
        <picture>
            <source  media="(min-width: 768px)"
                     srcset="//my-assets.netlify.com/codepen/dailyui-001/img.png     340w,
                          //my-assets.netlify.com/codepen/dailyui-001/img@2x.png  680w,
                          //my-assets.netlify.com/codepen/dailyui-001/img@3x.png 1020w"
                     sizes="360px" />
            <source srcset="//my-assets.netlify.com/codepen/dailyui-001/img-small.png     340w,
                          //my-assets.netlify.com/codepen/dailyui-001/img-small@2x.png  680w,
                          //my-assets.netlify.com/codepen/dailyui-001/img-small@3x.png 1020w"
                    sizes="(min-width: 320px) 290px,
                          (min-width: 480px) 435px
                          (min-width: 640px) 580px" />
            <img       src="//my-assets.netlify.com/codepen/dailyui-001/img.png"
                       alt="Citymap illustration" />
        </picture>
    </figure>

    <div class="headline">
        <h2 class="text-headline">Update Form</h2>
        <h3 class="text-subheadline">The Student Portal</h3>
    </div>
    <form action="Std_Update-servlet" method="post">
            <span>
              <label for="stdId" class="text-small-uppercase">Student ID</label>
              <input class="text-body" id="stdId" name="stdId" type="text" required>
            </span>
        <span>
              <label for="nam" class="text-small-uppercase">Name</label>
              <input class="text-body" id="nam" name="name" type="text" required>
            </span>
        <span>
              <label for="it" class="text-small-uppercase">Email Address</label>
              <input class="text-body"  name="email" id="it" type="email" required>
            </span>

        <span>
              <label for="ty" class="text-small-uppercase">Course </label>
              <input class="text-body" id="ty" name="course" type="text" required>
            </span>

        <span>
              <label for="cy" class="text-small-uppercase">Course Fees</label>
              <input class="text-body" id="cy" name="fee" type="text" required>
            </span>
        <input class="text-small-uppercase" id="submit" type="submit" value="Update">
    </form>
</main>



<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
    var inputs = document.querySelectorAll( 'input[type=text], input[type=email]' );
    for (i = 0; i < inputs.length; i ++) {
        var inputEl = inputs[i];
        if( inputEl.value.trim() !== '' ) {
            inputEl.parentNode.classList.add( 'input--filled' );
        }
        inputEl.addEventListener( 'focus', onFocus );
        inputEl.addEventListener( 'blur', onBlur );
    }

    function onFocus( ev ) {
        ev.target.parentNode.classList.add( 'inputs--filled' );
    }

    function onBlur( ev ) {
        if ( ev.target.value.trim() === '' ) {
            ev.target.parentNode.classList.remove( 'inputs--filled' );
        } else if ( ev.target.checkValidity() == false ) {
            ev.target.parentNode.classList.add( 'inputs--invalid' );
            ev.target.addEventListener( 'input', liveValidation );
        } else if ( ev.target.checkValidity() == true ) {
            ev.target.parentNode.classList.remove( 'inputs--invalid' );
            ev.target.addEventListener( 'input', liveValidation );
        }
    }

    function liveValidation( ev ) {
        if ( ev.target.checkValidity() == false ) {
            ev.target.parentNode.classList.add( 'inputs--invalid' );
        } else {
            ev.target.parentNode.classList.remove( 'inputs--invalid' );
        }
    }

    var submitBtn = document.querySelector( 'input[type=submit]' );
    submitBtn.addEventListener( 'click', onSubmit );

    function onSubmit( ev ) {
        var inputsWrappers = ev.target.parentNode.querySelectorAll( 'span' );
        for (i = 0; i < inputsWrappers.length; i ++) {
            input = inputsWrappers[i].querySelector( 'input[type=text], input[type=email]' );
            if ( input.checkValidity() == false ) {
                inputsWrappers[i].classList.add( 'inputs--invalid' );
            } else if ( input.checkValidity() == true ) {
                inputsWrappers[i].classList.remove( 'inputs--invalid' );
            }
        }
    }


</script>

</body>
</html>

