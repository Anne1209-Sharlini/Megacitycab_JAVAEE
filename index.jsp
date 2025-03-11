<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="styles.css" />

</head>
<body>
<header>
    <a href="#" class="logo">Mega City Cab<span>.</span></a>
    <div class="menutoggle" onclick="togglemenu();"></div>
    <ul class="navigation">
      <li><a href="#banner">Home</a></li>
      <li><a href="#about">About</a></li>
      <li><a href="#menu">Cabs</a></li>
      <!-- <li><a href="#expert">Expert</a></li> -->
      <li><a href="#tesominal">Testimonals</a></li>
      <li><a href="#contact">Contact</a></li>
    </ul>
  </header>
  <section class="banner" id="banner">
    <div class="content">
      <h2>Book a Cab, Leave the Rest to Us!</h2>

      <a href="login.jsp" class="btn">Book Now</a>
    </div>
  </section>
  <section name="about" id="about">
    <div class="row">
      <div class="col50">
        <h2 class="titletextt"><span>A</span>bout Us</h2>
        <p>
          Mega City Cab is your trusted partner for safe, reliable, and affordable rides in the city. With a focus on
          comfort and convenience, we ensure seamless travel experiences for every customer. Our professional drivers
          and modern fleet are here to make your journey smooth and stress-free. Your satisfaction is our priority
        </p>
      </div>
      <div class="col50">
        <div class="imgBx">
          <img src="img/car1.jpg" alt="" />
        </div>
      </div>
    </div>
  </section>
   <!-- menu -->
  <section class="menu" id="menu">
    <div class="title">
      <h2 class="titletextt">Our <span>C</span>abs</h2>
      <p>
        With a focus on comfort and convenience, we ensure seamless travel experiences for every customer
      </p>
    </div>
    <div class="content">
      <div class="box">
        <div class="imgBx">
          <img src="img/1.jpeg" alt="" />
        </div>
        <div class="text">
          <h3>Vitara _ 900</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/2.jpeg" alt="" />
        </div>
        <div class="text">
          <h3>Vitara_300</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/3.jpeg" alt="" />
        </div>
        <div class="text">
          <h3>Hummear</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/4.jpg" alt="" />
        </div>
        <div class="text">
          <h3>Honda Civic_Sedan</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/5.jpg" alt="" />
        </div>
        <div class="text">
          <h3>Hilux Double Cab</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/6.jpg" alt="" />
        </div>
        <div class="text">
          <h3>S-Cross</h3>
        </div>
      </div>
    </div>
    <div class="title">
      <a href="login.jsp" class="btn">Choose Yours</a>
    </div>
  </section>
  <section class="tesominal" id="tesominal">
         <center>
         <h2 class="titletextt">They<span>S</span>aid US</h2> </center>
  
    <div class="title white">

    </div>
    <div class="content">
      <div class="box">
        <div class="imgBx">
          <img src="img/testi1.jpg" alt="" />
        </div>
        <div class="text">
          <p>"I had an amazing experience with mega City Cab! The booking process was super easy, and the car was
            in perfect condition. I’ll definitely be renting from them again next time I need a car. Highly recommend
          </p>
          <h3>--Mrs.AM.Henry--</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/testi2.jpg" alt="" />
        </div>
        <div class="text">
          <p>Excellent service! The staff was friendly and the car was exactly what I needed. I appreciate the seamless
            booking process and the flexibility in pick-up/drop-off locations. I will definitely use their service
            again!</p>

          <h3>-- Mr.AS.Yoga --</h3>
        </div>
      </div>
      <div class="box">
        <div class="imgBx">
          <img src="img/testi3.jpg" alt="" />
        </div>
        <div class="text">
          <p>The car I rented was in pristine condition, clean, and drove like a dream. It was exactly what I expected
            and more. Definitely worth every penny!"
            "I rented an Hummer for a weekend getaway and it was perfect! Clean, spacious, and reliable. Thank you,  for making my trip so easy and enjoyable!</p>

          <h3>-- Mrs.Fernando --</h3>
        </div>
      </div>
</div>
  </section>
   <section class="contact" id="contact">
    <div class="title">
      <h2 class="titletextt"> <span>C</span>ontact Us</h2>
      <p>The Road to Your Destination Starts Here</p>
    </div>
    <div class="contactForm">
      <h3>Send Message</h3>
      <div class="inputBox">
        <input type="text" placeholder="Name">
      </div>
      <div class="inputBox">
        <input type="text" placeholder="Email">
      </div>
      <div class="inputBox">
        <textarea name="" id=""></textarea>
      </div>
      <div class="inputBox">
        <input type="submit" name="" id="" value="Send">
      </div>
    </div>
  </section>
  <div class="copyrighttext">
    <p>Copyright by @ 2025 <a href="#">Anne Sharlini &nbsp;</a>All rights reserved</p>
  </div>
  <script>
    window.addEventListener("scroll", function () {
      const header = document.querySelector("header");
      header.classList.toggle("sticky", window.scrollY > 0);
    });
    function togglemenu() {
      const menutoggle = document.querySelector('.menutoggle');
      const navigation = document.querySelector('.navigation');

      menutoggle.classList.toggle('active');
      navigation.classList.toggle('active');
    }
  </script>
</body>
</html>