'use strict';


(function ($) {
    var DEBUG = true;
    $('.save_mod_prod').on('click', function () {

        DEBUG && console.log("Save Button Pressed");

        var prod_name = $(this).parent().find('.prod_title').val();
        var prod_desc = $(this).parent().find('.prd_desc').val();
        var prod_price = $(this).parent().find('.prod_title_price').val();
        var prod_cat = $(this).parent().find('.prod_cat').val();
        var tempProd = $(this).parent().parent().find('#prod_id').text();
        var prod_id = tempProd.substring(12);
        //add other details

        $.ajax({
            type: 'post',
            url: '/SimpleSell_war/ModifyProducts',
            data: {
                ProductID: prod_id,
                Category: prod_cat,
                Name: prod_name,
                hasSubcategories: 0,
                Price: prod_price,
                inStock: 1,
                Description: prod_desc,
                isSubProduct: 0
            },

            success: function (response) {
                DEBUG && console.log(response);
                DEBUG && console.log(response);


            }
        });


    });
})(jQuery);