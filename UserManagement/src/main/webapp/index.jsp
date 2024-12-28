<%--
  Created by IntelliJ IDEA.
  User: RAHUL THAKUR
  Date: 18-04-2024
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="CSS/index.css">

    <link href="hi-from-pulkit-removebg-preview.png" rel="icon">
    <link href="assets/img/favicon.jpg" rel="apple-touch-icon">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hi there👋, I am Rahul Thakur</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.11/typed.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"/>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

</head>
<body>
<div class="scroll-up-btn">
    <i class="fas fa-angle-up"></i>
</div>
<nav class="navbar">
    <div class="max-width">
        <div class="logo"><a href="#" class="hire about-img" style="padding: 20px; border-radius: 10px;">Rahul <span>Thakur</span></a></div>
        <ul class="menu about-img" style="padding: 20px; border-radius: 10px;">
            <li><a href="#home" class="menu-btn hire">Home</a></li>
            <li><a href="#about" class="menu-btn hire">About</a></li>
            <li><a href="#services" class="menu-btn hire">Services</a></li>
            <li><a href="#skills" class="menu-btn hire">Skills</a></li>
            <li><a href="#teams" class="menu-btn hire">Testimonials</a></li>
            <li><a href="#contact" class="menu-btn hire">Contact</a></li>
            <li><a href="#contact" class="menu-btn hire"><%=session.getAttribute("name")%>🧑‍💻</a></li>
            <a href="P_Logout-servlet" class="hire about-img">LogOut</a>
        </ul>
        <div class="menu-btn">
            <i class="fas fa-bars"></i>
        </div>
    </div>
</nav>

<!-- home section start -->
<section class="home" id="home">
    <div class="max-width">
        <div class="home-content">
            <div class="text-1"></div>
            <div class="text-2">Rahul Thakur</div>
            <div class="text-3">I Am Passionate <span class="typing"></span> from Delhi</div>
            <br>
            <div class="row">
                <a href="https://discord.gg/Q7BTD58JKr"><i class='fab fa-discord' style="font-size: 45px; color: white;"></i></a><span>  </span>
                <a href="https://github.com/pulkitsinghdev"><img src="http://pulkitsinghdev.tech/github-logo-white.png" width="40px" height="40px"></a><span>  </span>
                <a href="https://dev.to/PulkitSinghDev"><img src="http://pulkitsinghdev.tech/assets/img/dev-logo.png" width="40px" height="40px"></a><span>  </span>
                <a href="https://twitter.com/PulkitSinghDev"><img src="http://pulkitsinghdev.tech/twitter-logo.png" width="40px" height="40px"></a><span>  </span>
                <a href="https://www.youtube.com/channel/UCWvqpm9sTcjgXLkp5Ylro-A"><img src="http://pulkitsinghdev.tech/youtube-logo.png" width="55px" height="40px"></a><span>  </span>
            </div>
            <br>
            <a href="mailto:rahulthakur95609@gmail.com" class="hire about-img">Hire him</a>
        </div>
    </div>
</section>

<!-- about section start -->
<section class="about" id="about">
    <div class="max-width">
        <h2 class="title">About him</h2>
        <div class="about-content">
            <div class="column left">
                <img src="" alt="" class="about-img" style="border-radius: 10px;"><style>
                .about-img:hover{
                    box-shadow: 10px 10px 15px 5px rgba(1,1,1,100);
                    transform: rotate(5deg);

                    transition: 0.3s;
                }
            </style>
            </div>
            <div class="column right about-img" style="padding: 20px; border-radius: 10px;">
                <div class="text">I Am Passionate <span class="typing-2"></span></div>
                <p>A self taught programmer who is a Passionate contributor towards communities, Open Source & Competitve, Who is Pursuing Knowledge to Progamming in future endeavor and helping people to enhance there learnings through providing them with practical experience and Knowledge.</p>
                <a href="#" class="about-img">Download Resume</a>
            </div>
        </div>
    </div>
</section>

<!-- services section start -->
<section class="services" id="services">
    <div class="max-width">
        <h2 class="title">Services</h2>
        <div class="serv-content">
            <div class="card about-img">
                <div class="box">
                    <img src="" width="75px" height="70px"></img>
                    <div class="text">Coding</div>
                    <p>Helping people to get practical experience and knowledge and helping to enhance there confidence by mentoring, judging, Organising & even helping others to organise one.</p>
                </div>
            </div>
            <div class="card about-img">
                <div class="box">
                    <img src="" width="75px" height="70px"></img>
                    <div class="text">Documentation & Blogs</div>
                    <p>Writing accessible technical documentation for helping people to learn & get practical experience in a way so that everyone even enjoys it.</p>
                </div>
            </div>
            <div class="card about-img">
                <div class="box">
                    <i class="fas fa-code"></i>
                    <div class="text">Front End Web Dev + Programming</div>
                    <p>Using best practices to build good web designs and creating programms for solving real world problems, resulting in less bugs and user satisfaction.</p>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<section class="services" id="service">
    <div class="max-width">
        <div class="serv-content">
            <div class="card about-img">
                <div class="box">
                    <img src="" width="75px" height="70px"></img>
                    <div class="text">Events/Live Streams/Video</div>
                    <p>Creating video content for sharing my knowledge in the community and engaging live streams to highly produced videos. Even organises various live events</p>
                </div>
            </div>
            <div class="card about-img">
                <div class="box">
                    <img src="" width="75px" height="70px"></img>
                    <div class="text">Communities</div>
                    <p>Helping people through various communities by giving talks, mentoring, volunteering and even helping others to organise one ( <a href="https://www.pugroups.in">check out my community here</a> )</p>
                </div>
            </div>
            <div class="card about-img">
                <div class="box">
                    <img src="" width="75px" height="70px"></img>
                    <div class="text">Open Source (Git + Github)</div>
                    <p>Contributing in opensource by making my projects, documentatins, etc. Open-Source and even contributing to various companies, communities,etc. to make their successful projects - Open Source.</p>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>

<!-- skills section start -->
<section class="skills" id="skills">
    <div class="max-width">
        <h2 class="title">My skills</h2>
        <div class="skills-content">
            <div class="column left">
                <div class="text">My creative skills & experiences.</div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos, ratione error est recusandae consequatur, iusto illum deleniti quidem impedit, quos quaerat quis minima sequi. Cupiditate recusandae laudantium esse, harum animi aspernatur quisquam et delectus ipsum quam alias quaerat? Quasi hic quidem illum. Ad delectus natus aut hic explicabo minus quod.</p>
                <a href="#" class="about-img">Read more</a>
            </div>
            <div class="column right">
                <div class="bars">
                    <div class="info">
                        <span>HTML</span>
                        <span>100%</span>
                    </div>
                    <div class="line html"></div>
                    <div class="bars">
                        <div class="info">
                            <span>CSS</span>
                            <span>80%</span>
                        </div>
                        <div class="line css"></div>
                        <div class="bars">
                            <div class="info">
                                <span>JAVA</span>
                                <span>70%</span>
                            </div>
                            <div class="line py"></div>
                            <div class="bars">
                                <div class="info">
                                    <span>Git & Github</span>
                                    <span>75%</span>
                                </div>
                                <div class="line opensource"></div>
                                <div class="bars">
                                    <div class="info">
                                        <span>BootStrap</span>
                                        <span>80%</span>
                                    </div>
                                    <div class="line html"></div>
                                    <div class="bars">
                                        <div class="info">
                                            <span>Tailwind CSS</span>
                                            <span>100%</span>
                                        </div>
                                        <div class="line html"></div>
                                        <div class="bars">
                                            <div class="info">
                                                <span>Adobe Photoshop & Illustrator</span>
                                                <span>80%</span>
                                            </div>
                                            <div class="line adpi"></div>
                                            <div class="bars">
                                                <div class="info">
                                                    <span>Competitive Programming</span>
                                                    <span>50%</span>
                                                </div>
                                                <div class="line cc"></div>
                                                <div class="bars">
                                                    <div class="info">
                                                        <span>Artificial Intelligence</span>
                                                        <span>25%</span>
                                                    </div>
                                                    <div class="line ai"></div>
                                                    <div class="bars">
                                                        <div class="info">
                                                            <span>MY SQL</span>
                                                            <span>70%</span>
                                                        </div>
                                                        <div class="line bld"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
</section>

<!-- teams section start -->
<section class="teams" id="teams">
    <div class="max-width">
        <h2 class="title">Testimonials</h2>
        <div class="carousel owl-carousel">
            <div class="card">
                <div class="box">
                    <img src="http://pulkitsinghdev.tech/assets/img/paJzgmb-_400x400-removebg-preview.png" alt="" class="about-img">
                    <div class="text">Aashi Dutt</div>
                    <p>Pulkit is a self driven person who is motivated to go lengths to learn and explore new opportunities at such a tender age. His self motivation inspires others to try hands in field of AI. I wish him great success and many more great experiences and learnings in life.</p>
                </div>
            </div>
            <div class="card">
                <div class="box">
                    <img src="http://pulkitsinghdev.tech/Shaurya_Guliani-removebg-preview.png" alt="" class="about-img">
                    <div class="text">Shaurya Guliani</div>
                    <p>Very enthusiastic and hardworking person. Always looking for new challenges to overcome👍👍</p>
                </div>
            </div>
            <div class="card">
                <div class="box">
                    <img src="http://pulkitsinghdev.tech/rishit_dagli.png" alt="" class="about-img">
                    <div class="text">Rishit Dagli</div>
                    <p>It is really cool what is he doing at such a young age and also helping the community, continue doing such awesome work!</p>
                </div>
            </div>
            <div class="card">
                <div class="box">
                    <img src="http://pulkitsinghdev.tech/assets/img/jBiPhG7s_400x400-removebg-preview%20(1).png" alt="" class="about-img">
                    <div class="text">Hemang Sinha</div>
                    <p>Pulkit is a cool, calm and talented person with lots of enthusiasm in him. His persistent efforts to carry out several activities always helps others to see the best in him. I wish the best of everything to him to excel in life and move ahead in life with several new endeavours.</p>
                </div>
            </div>
            <div class="card">
                <div class="box">
                    <img src="http://pulkitsinghdev.tech/assets/img/Lfv5tdn3_400x400-removebg-preview%20(1).png" alt="" class="about-img">
                    <div class="text">Avinash Dalvi</div>
                    <p>Pulkit is communities person and his passion about learning and contributing is amazing at this age.</p>
                </div>
            </div>
            <div class="card">
                <div class="box">
                    <img src="http://pulkitsinghdev.tech/assets/img/DR-VISHAL-VARIA-removebg-preview.png" alt="" class="about-img">
                    <div class="text">Dr. Vishal Varia</div>
                    <p>Pulkit is a very promising student. He is tech-savvy and quite ahead of his time. He is having a progressive mindset that sets him apart from other students or people. He is also a humble person always ready to accept change and help others. He is having good skills for web-designing and at such early age is able to make use of the computer as a tool. He has good programming logic and is capable of upgrading to program AI. He is fascinated by AI and all curious to learn about same. At this age where other students are coaxed to learn or study, he is already a member of a professional community of programmers and capable of teaching programming to others.Pulkit is an inspiration to his fellow mates and us as well. He is charming and diligent that makes him a lovable student. Best wishes to Pulkit for his bright future.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- contact section start -->
<section class="contact" id="contact">
    <div class="max-width">
        <h2 class="title">Contact me</h2>
        <div class="contact-content">
            <div class="column left">
                <div class="text">Get in Touch</div>
                <p></p>
                <div class="icons">
                    <div class="row">
                        <i class="fas fa-user"></i>
                        <div class="info">
                            <div class="head">Name</div>
                            <div class="sub-title">Rahul Thakur</div>
                        </div>
                    </div>
                    <div class="row">
                        <i class="fas fa-map-marker-alt"></i>
                        <div class="info">
                            <div class="head">Address</div>
                            <div class="sub-title">Delhi -110034 India</div>
                        </div>
                    </div>
                    <div class="row">
                        <i class="fas fa-envelope"></i>
                        <div class="info">
                            <div class="head">Email</div>
                            <div class="sub-title">rahulthakur95609@gmail.com</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column right">
                <div class="text">Message me</div>
                <form action="https://formspree.io/f/mqkgooqj" method="POST">
                    <div class="fields">
                        <div class="field name">
                            <input type="text" placeholder="Name" name="Name" required>
                        </div>
                        <div class="field email">
                            <input type="email" placeholder="Email" name="email_id" required>
                        </div>
                    </div>
                    <div class="field">
                        <input type="text" placeholder="Subject" name="subject" required>
                    </div>
                    <div class="field textarea">
                        <textarea cols="50" rows="20" placeholder="Message..." name="message" required></textarea>
                    </div>
                    <div class="button">
                        <button type="submit">Send message</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- footer section start -->
<footer>
    <span>Created By <a href="https://www.codingnepalweb.com">Rahul Thakur</a> | <span class="far fa-copyright"></span> 2023 <a href="https://github.com/PulkitSinghDev/PulkitSinghDev.github.io/blob/main/Privacy%20Policy.md">Privacy Policy</a></span>
</footer>

<!-- Calendly badge widget begin -->
<link href="https://assets.calendly.com/assets/external/widget.css" rel="stylesheet">
<script src="https://assets.calendly.com/assets/external/widget.js" type="text/javascript" async></script>
<script type="text/javascript">window.onload = function() { Calendly.initBadgeWidget({ url: 'https://calendly.com/pulkit-singh/meet-with-pulkit', text: 'Schedule a meet with him', color: '#fa0000', textColor: '#ffffff' }); }</script>
<!-- Calendly badge widget end -->

<script>
    $(document).ready(function(){
        $(window).scroll(function(){
            // sticky navbar on scroll script
            if(this.scrollY > 20){
                $('.navbar').addClass("sticky");
            }else{
                $('.navbar').removeClass("sticky");
            }

            // scroll-up button show/hide script
            if(this.scrollY > 500){
                $('.scroll-up-btn').addClass("show");
            }else{
                $('.scroll-up-btn').removeClass("show");
            }
        });

        // slide-up script
        $('.scroll-up-btn').click(function(){
            $('html').animate({scrollTop: 0});
            // removing smooth scroll on slide-up button click
            $('html').css("scrollBehavior", "auto");
        });

        $('.navbar .menu li a').click(function(){
            // applying again smooth scroll on menu items click
            $('html').css("scrollBehavior", "smooth");
        });

        // toggle menu/navbar script
        $('.menu-btn').click(function(){
            $('.navbar .menu').toggleClass("active");
            $('.menu-btn i').toggleClass("active");
        });

        // typing text animation script
        var typed = new Typed(".typing", {
            strings: ["Web Developer", "Mentor", "Open Source Contributor", "Action on Google Developer", "Freelancer", "AI Enthusiast", "Front End Enthusiast", "UI Designer", "Photographer", "Technical Writer", "Author", "Cloud Computing Enthusiast"],
            typeSpeed: 100,
            backSpeed: 60,
            loop: true
        });

        var typed = new Typed(".typing-2", {
            strings: ["Web Developer", "Mentor", "Open Source Contributor", "Action on Google Developer", "Freelancer", "AI Enthusiast", "Front End Enthusiast", "UI Designer", "Photographer", "Technical Writer", "Author", "Cloud Computing Enthusiast"],
            typeSpeed: 100,
            backSpeed: 60,
            loop: true
        });

        // owl carousel script
        $('.carousel').owlCarousel({
            margin: 20,
            loop: true,
            autoplayTimeOut: 2000,
            autoplayHoverPause: true,
            responsive: {
                0:{
                    items: 1,
                    nav: false
                },
                600:{
                    items: 2,
                    nav: false
                },
                1000:{
                    items: 3,
                    nav: false
                }
            }
        });
    });
</script>
</body>
</html>
