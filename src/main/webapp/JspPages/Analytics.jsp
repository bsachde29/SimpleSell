<%--
  Created by IntelliJ IDEA.
  User: shivambairoliya
  Date: 3/12/21
  Time: 2:33 AM
  To change this template use File | Settings | File Templates.
--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Analytics</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/7dff33b5c2.js" crossorigin="anonymous"></script>

</head>
<body style="overflow: scroll">

<div>
    <div class="nav_bar">
        <div class="logo_nav">
            <img class="nav_logo" src="img/logo.png">
        </div>

        <div class="right_nav">
            <i class="fas fa-user-circle"></i>
            <div class="sellername">
                Jon Doe
            </div>

        </div>
    </div>
    <div class="content">
        <div class="side_bar">
            <span class="side_bar_item">
                <i class="fas fa-home"></i>
                Home
            </span>
            <span class="side_bar_item">
                <i class="fas fa-dolly-flatbed"></i>
                Inventory

            </span>
            <span class="side_bar_item selected_nav_item">
                <i class="fas fa-chart-bar"></i>
                Analytics

            </span>
            <span class="side_bar_item">
                <i class="fas fa-star"></i>
                Discounts
            </span>
            <span class="side_bar_item">
                <i class="fas fa-store"></i>
                Storefront
            </span>
            <span class="side_bar_item">
                <i class="fas fa-user-alt"></i>
                Profile
            </span>

        </div>
        <div class="content_main_out">
            <div class="content_main" id="analytics_page" >
                <h1 class="product_text prd_title">Analytics</h1>
                <h2 class= "product_text">Total Sales</h2>
                <i class="fas fa-dollar-sign in_page_icon"></i>
                <h2 class= "product_text sales_txt" id="total_sales">999.99</h2>
                <h2 class= "product_text">Average Order Value</h2>
                <i class="fas fa-dollar-sign in_page_icon"></i>
                <h2 class= "product_text sales_txt" id="avg_order_value">999.99</h2>
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
