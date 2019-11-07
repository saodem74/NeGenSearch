<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Search Engine </title>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Bootstrap JavaScript -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/pagination.js"></script>
<%--    <script src="js/paging.js"></script>--%>

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
                timer = setTimeout(callback, ms);
            };
        })();



        function search(event) {
            $('#results').empty();
            var formData = {
                'query' : $('#query').val().trim()
            };
            if($('#query').val().trim().length!=0){
                console.log("enter.....");
                $('#pagination').pagination({
                    dataSource: function (done) {
                        $.ajax({
                            type: 'POST',
                            url: 'GetSearchServlet',
                            data: formData,
                            dataType: 'json',
                            success: function (data) {
                                console.log("success: "+data);
                                if(data.length!=0) {
                                    done(data);
                                }else {
                                    $('.form-group').append('<div class="alert alert-danger alert-dismissible fade in" role="alert" id="noresponse"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>No response on the query "' + $('#query').val().trim() + '"</div>');
                                }
                            }
                        });
                    },
                    pageSize: 5,
                    pageNumber: 1,
                    formatResult: function(data) {
                        console.log("formatResult: "+data.toString());
                    },
                    callback: function(data, pagination) {
                        console.log("callback: "+data.toString());

                        var html = templating(data);
                        console.log(html);
                        $('#results').html(html);
                    }
                });
            }
        }

        function templating(data) {

            var html = '';
            $.each(data, function(i, val) {
                var cloned = $( "#prototype" ).clone();
                cloned.attr('id',i);
                cloned.attr('style', 'display:true;');
                cloned.find('.url').append('<a href="'+val.url+'"><u>'+val.url+'</u></a>');
                cloned.find('.content').text(val.content);
                html += cloned.html();
            });

            return html;
        }

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
                            Go <span aria-hidden="true" aria-label="Left Align"> </span>
                        </button>
                </span>
            </div>

        </div>
    </div>

    <!-- Prototype div for a result block -->
    <div class="row" style="display: none;" id="prototype">
        <div class="col-md-4">
            <p class="text-right score"></p>
        </div>
        <div class="col-md-8">
            <h3 class="url"></h3>
            <p class="content"></p>
        </div>
    </div>

    <!-- Div to apply the results with JS -->
    <div id="results"></div>
    <div id="pagination"></div>

</body>
</html>
