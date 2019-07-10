$(document).ready(function () {
    $('#btnSearch').click(function(event){
        event.preventDefault();

        var origin = $("#origin").val();
        var destination =  $("#destination").val();

        $.ajax({
            url: "http://localhost:8090/connected?origin="+ origin + "&destination=" + destination,
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function(result){
                if(result){
                    $("#resultdiv").removeClass("text-danger");
                    $("#resultdiv").addClass("text-success");
                }
                else{
                    $("#resultdiv").removeClass("text-success");
                    $("#resultdiv").addClass("text-danger");
                }

                $("#resultdiv").empty();
                $("#resultdiv").append('<p>Cities Connected? ' + result.toString().toUpperCase() + '</p>').show();
            },
            error: function () {
                $("#resultdiv").empty();
                $("#resultdiv").append("<h2>FAILED</h2>").show();
            }
        });
    });
});