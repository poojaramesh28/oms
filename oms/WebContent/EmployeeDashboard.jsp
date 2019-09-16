<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oms.DAO.*, com.oms.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <title>Selling &mdash; Website by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    
    
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/jquery-ui.css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">

    <link rel="stylesheet" href="../css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="../fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
    
    <style>
    .button-4{
  width:100px;
  height:40px;
  border:2px solid white;
  float:left;
  text-align:center !important;
  cursor:pointer;
  position:relative;
  box-sizing:border-box;
  overflow:hidden;
  margin:20px;
}
.button-4 a{
  font-family:sans-serif;
  font-size:12px;
  color:white;
  text-decoration:none;
  line-height:40px;
  transition:all .5s ease;
  z-index:2;
  position:relative;
}
.eff-4{
  width:100px;
  height:40px;
  left:-100px;
  background:lightslategrey;
  position:absolute;
  transition:all .5s ease;
  z-index:1;
}
.button-4:hover .eff-4{
  left:0;
}
.button-4:hover a{
  color:#fff;
}
.site-navbar {
  margin-bottom: 0px;
  z-index: 1999;
  position: relative;
  width: 100%;
  background:#0000; 
  }
  .site-navbar .site-navigation .site-menu .active {
      color: red;
      display: inline-block;
      padding: 5px 20px;
 }
 .site-navbar .site-navigation .site-menu > li > a:hover {
          color:red; 
  }
  .site-navbar .site-navigation .site-menu > li > a {
        padding: 5px 20px;
        color:white;
  }
 
    </style>
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   
    <div class="top-bar py-3 " id="home-section" style="background-color:rgba(82, 79, 79, 0.836);"> 
      <div class="container">
        <div class="row align-items-center">
         
          
          <div class="col-12">
            <marquee behavior="alternate" style="color:white; font-family:Arial, Helvetica, sans-serif">Welcome!You are logged in as a 
              <span style="color:rgb(134, 2, 101);">Purchase Employee.</span></marquee>
            <p class="mb-0 float-right text">
            </p>
            
          </div>
        </div>
      </div> 
    </div>

    <header class="site-navbar py-4 bg-black js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2">
            <div class="mb-0 site-logo" style="margin-left:-100px !important;">
              <img src="img/logo.png" height="80" class="d-inline-block align-top" alt="RBC logo" > 
            </div>
          </div>
          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="#home-section" class="nav-link">Home</a></li>
                <li><a href="#products-section" class="nav-link">Products</a></li>
                <li><a href="#about-section" class="nav-link">About Us</a></li>
                <li><a href="#special-section" class="nav-link">Special</a></li>
                <li><a href="#News-section" class="nav-link">News</a></li>
                <li><a href="#contact-section" class="nav-link">Contact</a></li>
                <li><a href="#" class="btn btn-white btn-outline-white py-3 px-4 rounded-0 mb-lg-0 mb-2 d-block d-sm-inline-block">Logout</a></li>
              </ul>
            </nav>
          </div>

        </div>
      </div>
      
    </header>

  
     
    <div class="site-blocks-cover overlay" style="background-image: url(img/background1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="container">
      
        <div class="row align-items-center justify-content-center">

          <div class="col-md-12" data-aos="fade-up" data-aos-delay="400">
                        
            <div class="row mb-4">
              <div class="col-md-7">
                <h1>GO ON SHAPE YOUR ENFIELD</h1>
                <p class="mb-5 lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam assumenda ea quo cupiditate facere deleniti fuga officia.</p>
                <div>
                  <a href="#" class="btn btn-white btn-outline-white py-3 px-5 rounded-0 mb-lg-0 mb-2 d-block d-sm-inline-block">Shop Now</a>
                  <a href="#" class="btn btn-white py-3 px-5 rounded-0 d-block d-sm-inline-block">Club Membership</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>  


    
    
        
<% List<Items> list=ItemsDAO.getPurchaseableItems(); 

String emp_sid =request.getAttribute("employee_id").toString();
int emp_id = Integer.parseInt(emp_sid);
%>

        
     <div class="site-section" id="products-section">
      <div class="container">
        <div class="row mb-5 justify-content-center">
          <div class="col-md-6 text-center">
            <h3 class="section-sub-title">Popular Products</h3>
            <h2 class="section-title mb-3">Our Products</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repudiandae nostrum natus excepturi fuga ullam accusantium vel ut eveniet aut consequatur laboriosam ipsam.</p>
          </div>
        </div>
       <div class="row">
 <% for(Items i:list){  %>       
        
        
        
          <div class="col-lg-4 col-md-6 mb-5">
            <div class="product-item">
              <figure>
                <img src="img/tank.jpg" alt="Image" class="img-fluid">
              </figure>
              <div class="px-4">
                <h3><a href="#">Customized Tank Decal</a></h3>
                
                <p class="mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing.</p>
                <div>
                  <a href='SupplierListServlet?item_name=<%=i.getItem_name()%>&type_of_employee=employee&employee_id=<%=emp_id%>' class="btn btn-black mr-1 rounded-0" data-toggle="modal" data-target="#modalCart">View Suppliers</a>
                  <!--
                  <button type="button" class="btn btn-primary" >Launch modal</button>
                  -->
                </div>
              </div>
            </div>
          </div>
          
        
       
 <%} %>         
      </div>
     </div>
   
    

  </div> <!-- .site-wrap -->


  


<!-- Modal: modalCart -->
<div class="modal fade" id="modalCart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <!--Header-->
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">Your cart</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <!--Body-->
      <div class="modal-body">

        <table class="table table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>Available Suppliers</th>
              <th>Price</th>
              <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>Supplier A</td>
              <td>100$</td>
              <td>
                  <input type="number" value="0" aria-label="Search" class="form-control" style="width:80px; height:30px;">
              </td>
              <td>
                  <button1 type="button" class="btn btn-primary" style="width:160px;">Send for approval</button>
              </td>
              <!--<td><a><i class="fas fa-times"></i></a></td>-->
            </tr>
            
     
          </tbody>
        </table>

      </div>
      <!--Footer-->
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal: modalCart -->

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>

  
  <script src="js/main.js"></script>
  
  <script>
  // Material Select Initialization
  $(document).ready(function() {
  $('.mdb-select').materialSelect();
  });
</script>
  
  <script>
    $("#example-one").on("click", function() {
  var el = $(this);
  el.css("background-color","green")
  el.text() == el.data("text-swap") 
  ? el.text(el.data("text-original") , el.css("background-color","red"))  
  : el.text(el.data("text-swap"));
});
  </script>
  
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("button1").click(function(){
            $(this).text($(this).text() == 'SENT' ? 'ALREADY SENT' : 'SENT');
        });
    });
</script>
  </body>
</html>