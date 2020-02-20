$(document).ready(function() {
        $('.input-daterange').datepicker({
            autoclose: true,
            todayHighlight: true
        });
    $('#birthday').datepicker({
        autoclose: true,
        todayHighlight: true
    });
        $('#tours-modal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus');
        });

    $('#editTourModal').on('hidden.bs.modal', function () {
        $('.modal-header').find('h4').remove();
        $('#edit-tour-form').off('submit');
    });

    $( "#create-tour-form").on('submit', function(e) {
        $.ajax({
            url : 'create/tour?create=true',
            type: "POST",
            data: $('#create-tour-form').serialize(),
            success: function (data) {
                $("#alert-area").append($("<div class=\"alert alert-success alert-dismissible fade in\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Success!</strong> Created a tour.</div>"));
                $(".alert-success").delay(2000).fadeOut("slow", function () { $(this).remove(); });
                loadTours();
            },
            error: function (jXHR, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
        e.preventDefault();
    });
});
$(document).ready(function() {
    $(".panel-heading").html('<b>All Tours </b><button id="refresh">Refresh</button>');
    $('#refresh').on('click', loadTours);
    var table = $("#tours").DataTable({
        "responsive" : true,
        "ajax":{
            url: "tours/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
            },
            dataSrc:'',
        },
        "columns": [
            { "data": "tourId"},
            { "data": "name"},
            { "data": "description"},
            { "data": "start"},
            { "data": "end"},
            { "data": "price"},
            { "data": "language"},
            {
                "data": function(data, type) {
                    return "<a class='details btn btn-info btn-sm'>Details</a>";
                },
                "bSortable": false
            },
            {
                "data": function(data, type) {
                    return "<button class='edit btn btn-warning btn-sm' data-toggle=\"modal\" data-target=\"#editTourModal\">Edit</button>";
                },
                "bSortable": false
            },
            {
                "data": function(data, type) {
                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
                },
                "bSortable": false
            }
        ],
        "columnDefs": [
            { "width": "5%", "targets": 0 },
            { "width": "30%", "targets": 2 }
        ],
        "bDestroy": true

    }).on( 'click', 'a', function () {
        var tourId = $("#tours").DataTable().row($(this).closest('tr')).data().tourId;
        var url = "dashboard/tour?id="+ tourId;
        window.open(url, '_blank');
    }).on( 'click', '.edit', function () {
        var tourId = $("#tours").DataTable().row($(this).closest('tr')).data().tourId;
        var url = "update/tour?id="+ tourId + "&edit=true";
        updateTour(url);
    }).on( 'click', '.delete', function () {
        var tourId = $("#tours").DataTable().row($(this).closest('tr')).data().tourId;
        var url = "update/tour?id="+ tourId+ "&delete=true";
        var deleteTour = confirm("Are you shure you want to delete the tour #" + tourId + "?");
        if(deleteTour){
            $.ajax({
                url : url,
                type: "DELETE",
                success: function (data) {
                    loadTours();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
            });
        }
    });


});

function loadTours(){
    var table = $("#tours").DataTable({
        "responsive" : true,
        "ajax":{
            url: "tours/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
            },
            dataSrc:'',
        },
        "columns": [
            { "data": "tourId"},
            { "data": "name"},
            { "data": "description"},
            { "data": "start"},
            { "data": "end"},
            { "data": "price"},
            { "data": "language"},
            {
                "data": function(data, type) {
                    return "<a class='details btn btn-info btn-sm'>Details</a>";
                },
                "bSortable": false
            },
            {
                "data": function(data, type) {
                    return "<button class='edit btn btn-warning btn-sm' data-toggle=\"modal\" data-target=\"#editTourModal\">Edit</button>";
                },
                "bSortable": false
            },
            {
                "data": function(data, type) {
                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
                },
                "bSortable": false
            }
        ],
        "columnDefs": [
            { "width": "5%", "targets": 0 },
            { "width": "30%", "targets": 2 }
        ],
        "bDestroy": true
    });
}


$('#editTourModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var recipient = button.data('whatever');
    var modal = $(this);
    modal.find('.modal-title').text('New message to ' + recipient);
    modal.find('.modal-body input').val(recipient);
});

function updateTour(url){
    $( "#edit-tour-form").on('submit', function(e) {
            $.ajax({
                url : url,
                type: "POST",
                data: $('#edit-tour-form').serialize(),
                success: function (data) {
                    loadTours();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
        });
        e.preventDefault();
        $('#editTourModal').modal('toggle');
    });
}


