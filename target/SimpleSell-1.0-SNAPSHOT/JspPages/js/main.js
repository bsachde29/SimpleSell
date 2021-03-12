'use strict';


(function ($) {


    var DEBUG = true;

    var DEBUG = true;

    var signUpButton = $('#su_but');
    $('.email_check').hide();
    $('.phone_check').hide();
    $('.pass_check').hide();


    signUpButton.on('click', function () {

        $('.email_check').hide();
        $('.phone_check').hide();
        $('.pass_check').hide();

        var FirstName = $('#firstName').val();
        var LastName = $('#lastName').val();
        var EmailID = $('#email').val();
        var Password = $('#password').val();
        var repass = $('#re-password').val();
        var MobileNumber = $('#mobileNumber').val();
        var storeName = $('#storeName').val();
        // send ajax request
        DEBUG && console.log(Password);
        DEBUG && console.log("Sign Up button works");

        var err = 0;

        if (Password != repass) {
            err = 1;
        }


        if (!err) {
            $.ajax({
                type: 'post',
                url: '/SimpleSell_war/SignUp',
                data: {
                    FirstName: FirstName, LastName: LastName, EmailID: EmailID, Password: Password,
                    MobileNumber: MobileNumber, StoreName: storeName
                },
                success: function (response) {

                    DEBUG && console.log(response);

                    if (response == "Email Exists") {
                        $('.email_check').show();
                        $('#email').addClass('err');
                    }

                    if (response == "Phone Exists") {
                        $('.phone_check').show();
                        $('#phoneNumber').addClass('err');
                    }

                    // if (data != 1) {
                    //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'red');
                    // }
                    // else {
                    //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'green');
                    // }
                }
            });
        } else {
            $('.pass_check').show();
            $('#password').addClass('err');
            $('re-password').addClass('err');
        }
    });


    var logInButton = $('#li_but');

    logInButton.on('click', function () {
        var EmailID = $('#email').val();
        var Password = $('#password').val();
        // send ajax request
        DEBUG && console.log(Password);
        DEBUG && console.log(EmailID);

        DEBUG && console.log("Sign IN button works");

        $.ajax({
            type: 'post',
            url: '/SimpleSell_war/Login',
            data: {
                EmailID: EmailID, Password: Password
            },

            success: function (response) {

                DEBUG && console.log(response);

                if (response == "Wrong Details") {


                } else {
                    var seller = JSON.parse(response);
                    console.log(seller);
                    sessionStorage.setItem("sellerID", seller.sellerID);
                    sessionStorage.setItem(("storeName"), seller.appName);
                    sessionStorage.setItem("sellerName", seller.firstName + " " + seller.lastName);

                }

                window.location.href = "Inventory.jsp";

                // if (data != 1) {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'red');
                // }
                // else {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'green');
                // }

            }
        });
    });



    if (($(".all_products")[0])) {


        $.ajax({
            type: 'get',
            url: '/SimpleSell_war/Inventory',
            data: {
                SellerID: sessionStorage.getItem("sellerID")
            },

            success: function (response) {

                DEBUG && console.log(response);
                var obj = JSON.parse(response);

                DEBUG && console.log(obj[0]["name"]);

                DEBUG && console.log(obj.length);


                for (let i = 0; i < obj.length; i ++ ) {

                    var hasSub = "No";
                    if(obj[i]["hasSubCategories"] == true ) {
                        hasSub = "Yes";
                    }



                    var soldout_btn = "<button class=\"product_btns sold_out\" >Mark as sold out</button>\n"
                    var instock_btn = "<button class=\"product_btns in_stock\" >Mark as in stock</button>\n"

                    var final_btn;










                    $('.all_products').append("<div class=\"prod_wrapper prod_" + i +"\">\n" +
                        "                        <div class=\"product_content\">\n" +
                        "                            <img class=\"inv_img\" src=\"img/product_image.jpg\">\n" +
                        "                            <div class=\"product_txt\">\n" +
                        "                                <div class=\"title_price\">\n" +
                        "                                    <input class=\"prod_title\" value=\"" + obj[i]["name"] + "\">\n" +
                        "                                    <section class=\"product_price\">\n" +
                        "                                        <span class=\"price_dollar\">$</span>\n" +
                        "                                        <input class=\"prod_title_price\" value=\"" + obj[i]["price"] + "\">\n" +
                        "                                    </section>\n" +
                        "                                </div>\n" +
                        "                                <textarea class=\"prd_desc\">" + obj[i]["description"] + " </textarea>\n" +
                        "                                <input class=\"prod_cat\" value=\"" + obj[i]["category"] + "\">\n" +
                        "                                <button class=\"product_btns save_mod_prod\">Save</button>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"prod_right\">\n" +
                        "                                <p class = \"prod_id\">SKU Number: " + obj[i]["productID"] + "</p>\n" +
                        "                                <p class = \"has_sub\">Has Sub Products: " + hasSub +"</p>\n" +
                        "\n" +
                        "                                <button class=\"product_btns sold_out\">Mark as sold out</button>\n" +
                        "                                <button class=\"product_btns in_stock\" >Mark as in stock</button>\n" +
                        "                                <button class=\"product_btns delete_prod\" >Remove from inventory</button>\n" +
                        "\n" +
                        "                            </div>\n" +
                        "\n" +
                        "\n" +
                        "                        </div>\n" +
                        "\n" +
                        "                    </div>")

                    DEBUG &&
                    console.log(obj[i]["in_Stock"]);


                    if (obj[i]["in_Stock"] == "IN_STOCK") {
                        $('.prod_'+ i).find('.in_stock').hide();
                        DEBUG && console.log("is in stock  " + i);

                    } else {
                        $('.prod_'+ i).find('.sold_out').hide();
                    }



                    // $('.all_products').append("<div class=\"prod_wrapper\">\n" +
                    //     "                        <div class=\"product_content\">\n" +
                    //     "                            <img class=\"inv_img\" src=\"img/product_image.jpg\">\n" +
                    //     "                            <div class=\"product_txt\">\n" +
                    //     "                            <div class=\"title_price\">\n" +
                    //     "                                <input class=\"prod_title\" value=\"" + obj[i]["name"] + "\">\n" +
                    //     "                                <section class=\"product_price\">\n" +
                    //     "                                    <span class=\"price_dollar\">$</span>\n" +
                    //     "                                    <input class=\"prod_title_price\" value=\"" + obj[i]["price"] + "\">\n" +
                    //     "                                </section>\n" +
                    //     "                            </div>\n" +
                    //     "                            <textarea class=\"prd_desc\">" + obj[i]["description"] + " </textarea>\n" +
                    //     "                                <button class=\"product_btns\">Save</button>\n" +
                    //     "                            </div>\n" +
                    //     "                           <p id='prod_id'>SKU Number: " + obj[i]["skuNumber"] + "</p>\n" +
                    //     "                        </div>\n" +
                    //     "\n" +
                    //     "                    </div>")


                }

                $('.scripts').append("<script src=\"js/save_moded.js\"></script>")


            }
        });
    }






    if (($(".all_orders")[0])) {


        var sellerID = sessionStorage.getItem("sellerID");




        $.ajax({
            type: 'get',
            url: '/SimpleSell_war/FetchOrder',
            data: {
                SellerID: sellerID
            },

            success: function (response) {

                DEBUG && console.log(response);

                // if (response == "Wrong Details") {
                //
                //
                // } else {
                //     var seller = JSON.parse(response);
                //     console.log(seller);
                //     sessionStorage.setItem("sellerID", seller.sellerID);
                //     sessionStorage.setItem(("storeName"), seller.appName);
                //     sessionStorage.setItem("sellerName", seller.firstName + " " + seller.lastName);
                //
                // }
                //
                // window.location.href = "Inventory.jsp";

                // if (data != 1) {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'red');
                // }
                // else {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'green');
                // }

            }
        });

    }

    if (($(".modify_details")[0])) {

        $(".modify_details").hide();
        $.ajax({
            type: 'get',
            url: '/SimpleSell_war/ModifyAccountDetails',
            data: {
                SellerID: sessionStorage.getItem("sellerID")
            },
            success: function (response) {
                var seller = JSON.parse(response);
                $("#firstName").val(seller.firstName);
                $("#lastName").val(seller.lastName);
                $("#storeName").val(seller.appName);
                $("#description").val(seller.Description);
                $("#email").val(seller.email);
                $("#phone").val(seller.phoneNumber);
                $("#pass").val("");
                $("#ConfirmPass").val("");
                $("#instaID").val(seller.InstaHandle);
                $("#fbID").val(seller.FbHandle);
                $(".modify_details").show();
            }
        });
    }

    var modifySaveBut = $("#modify_account_button");

    modifySaveBut.on('click', function () {
        var FirstName = $('#firstName').val();
        var LastName = $('#lastName').val();
        var storeName = $('#storeName').val();
        var description = $('#description').val();
        var EmailID = $('#email').val();
        var Password = $('#password').val();

        var MobileNumber = $('#phone').val();
        var instaID = $('#instaID').val();
        var fbID = $('#instaID').val();
        // send ajax request
        DEBUG && console.log("Sign Up button works");

        $.ajax({
            type: 'post',
            url: '/SimpleSell_war/ModifyAccountDetails',
            data: {
                SellerID: sessionStorage.getItem("sellerID"),
                FirstName: FirstName,
                LastName: LastName,
                EmailID: EmailID,
                Password: Password,
                MobileNumber: MobileNumber,
                StoreName: storeName,
                Description: description,
                InstaHandle: instaID,
                FbHandle: fbID
            },

            success: function (response) {

                DEBUG && console.log(response);

                if (response == "Email Exists") {
                    $('.email_check').show();
                    $('#email').css({
                        "background-color": "#f4d2d294",
                        "border": "1.5px solid #e10000a3"
                    });

                }

                if (response == "Phone Exists") {
                    $('.phone_check').show()
                    $('#phoneNumber').css({
                        "background-color": "#f4d2d294",
                        "border": "1.5px solid #e10000a3"
                    });
                }

                //TODO password too weak

            }
        });
    });

    if (($("#analytics_page"))) {

        $("#analytics_page").hide();
        $.ajax({
            type: 'get',
            url: '/SimpleSell_war/FinancialReports',
            data: {
                SellerID: sessionStorage.getItem("sellerID")
            },
            success: function (response) {
                var seller = JSON.parse(response);
                console.log(response);
                $("#total_sales").text(seller.sales)
                $("#avg_order_value").text(seller.avg)
                $("#analytics_page").show();
            }
        });
    }



})(jQuery);