<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Search Engine </title>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Bootstrap JavaScript -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>

        /**
         * Event listeners
         */
        $(document).ready(function(){
            /**
             * Perform search on button click or when user hits enter.
             */
            $('#searchbtn').on('click', search);

            // $('.textfield').keypress(function (e) {
            //     if (e.which == 13) search();
            // });

            /**
             * User experience function to perform delayed AJAX queries
             * when user is writing in the textfield.
             */
            // $('.textfield').keyup(function (e) {
            //     $("#noresponse").alert('close');
            //
            //     //var minlength = 3;
            //     if($('#query').val().trim().length >= 3){
            //         delay(function(){
            //             search();
            //         }, 500 );
            //     }
            // });

        });

        /**
         * Delay snippet for delaying keyup listener.
         * Taken from:
         * http://scriptbaker.com/keyup-function-with-delay/
         */
        var delay = (function(){
            var timer = 0;
            return function(callback, ms){
                clearTimeout (timer);
                //timer = setTimeout(callback, ms);
            };
        })();

        function search(event) {
            $('#results').empty();
            var formData = {
                'query' : $('#query').val().trim()
            };
            if($('#query').val().trim().length!=0){
                $.ajax({
                    type 		: 'POST',
                    url 		: 'GetSearchServlet',
                    data 		: formData,
                    dataType 	: 'json'
                })
                    .done(function(data){

                        if(!data.success){

                        }else{
                            $.each(data.res, function(i, val) {
                                //loop data
                            });
                        }

                });

            }

        };

    </script>

</head>
<body>
    <div style="text-align: center;">
        <div class="page-header">
            <h1>Search!</h1>
        </div>
    </div>

    <!-- Search div -->
    <div class="row">
        <div class="form-group col-md-4 col-md-offset-4">

            <div class="input-group">
                <input type="text" class="form-control input-lg textfield" name="query" id="query"></input>
                <span class="input-group-btn">
                        <button class="btn btn-primary btn-lg" type="button" id="searchbtn">
                            Go <span class="glyphicon glyphicon-search" aria-hidden="true" aria-label="Left Align"> </span>
                        </button>
                </span>
            </div>

        </div>
    </div>

    <!-- Prototype div for a result block -->
    <div class="row" style="display: none;" id="prototype">
        <div class="col-md-3">
            <p class="text-right score"></p>
        </div>
        <div class="col-md-9">
            <h3 class="title"></h3>
            <p class="url"></p>
        </div>
    </div>

</body>
</html>
