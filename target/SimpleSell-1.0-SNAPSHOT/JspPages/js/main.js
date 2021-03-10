'use strict';


(function ($) {


    var DEBUG = true;

    var signUpButton = $('#su_but');
    $('.email_check').hide();
    $('.phone_check').hide();


    signUpButton.on('click', function () {
        var FirstName = $('#firstName').val();
        var LastName = $('#lastName').val();
        var EmailID = $('#email').val();
        var Password = $('#password').val();
        var MobileNumber = $('#mobileNumber').val();
        var storeName = $('#storeName').val();
        // send ajax request
        DEBUG && console.log(Password);
        DEBUG && console.log("Sign Up button works");

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

                // if (data != 1) {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'red');
                // }
                // else {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'green');
                // }

            }
        });
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

                // if (data != 1) {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'red');
                // }
                // else {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'green');
                // }

            }
        });
    });



    $('.test_inv').on('click', function () {


        $.ajax({
            type: 'get',
            url: '/SimpleSell_war/Inventory',
            data: {
                SellerID: sessionStorage.getItem("sellerID")
            },

            success: function (response) {

                DEBUG && console.log(response);



            }
        });
    });


    //TODO Send requests for Login


    //TODO Send requests for Modifying

})(jQuery);