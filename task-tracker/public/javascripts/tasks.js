$( document ).ready(function() {
    $('#tasks').on('click', '.delete-button', function (event) {
        var id = $(this).data('id');
        $.ajax({
            url: "/tasks/" + id,
            type: "DELETE",

            // Work with the response
            success: function( response ) {
                document.location.reload(true);
            }
        });
    });
});