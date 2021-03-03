
'use strict';


(function ($) {


    var DEBUG = true;

    var signUpButton = $('#su_but');


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
                FirstName: Name, LastName: LastName, EmailID: EmailID, Password: Password,
                MobileNumber: MobileNumber, StoreName: storeName
            },
            success: function (data) {

                DEBUG && console.log(data);

                // if (data != 1) {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'red');
                // }
                // else {
                //     $('h6:contains("Cream of Mushroom")').parent().css('background-color', 'green');
                // }

            }
        });
    });


})(jQuery);