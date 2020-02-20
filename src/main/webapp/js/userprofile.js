$(document).ready(function() {
	$("form").on('submit', function(){
		window.location.reload();
	});
    var info = document.getElementById('form-info');
    var pass = document.getElementById('form-password');
    window.onclick = function (event) {
        if (event.target == info) {
            info.style.display = "none";
        }
        if (event.target == pass) {
            pass.style.display = "none";
        }
    };

    $('#repeat-password').on('keyup', function () {
        if ($('#new-password').val() == $('#repeat-password').val()) {
            $('.confirm-password').removeClass('has-error');
            $('#signup :input[type="submit"]').prop('disabled', false);
            $('#repeat-password').css("background-color", "#f1f1f1");
            $('#signup :input[type="submit"]').css("background-color", "#75c2f4");
        } else{
            $('#repeat-password').css("background-color", "#ffcccc");
            $('#signup :input[type="submit"]').css("background-color", "#7a7a7a");
            $('#signup :input[type="submit"]').prop('disabled', true);
            $('.confirm-password').addClass('has-error');
        }
    });

$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})

$('#search-tours:not(.bound)').addClass('bound').on('click', function(e) {
        	e.preventDefault();
            $('#tours-modal').modal('toggle');
            var table = $("#tours").DataTable({
                "ajax":{
                    url: "profile/mytours",
                    dataType : "json",
                    type: "GET",
                    dataSrc:'',
                },
                "columns": [
                	{ "data": "orderId"},
                    { "data": "tourName",
                    	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                    			if(oData.tourId != null){
                    				$(nTd).html("<a href='dashboard/tour?id="+oData.tourId+"'>"+oData.tourName+"</a>");
                    			}
                    	},
                     "emptyTable": "<i>You have not booked any tours!</i>"
                    },
    	            {
    	                "data": function(data, type) {
    	                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
    	                },
    	                "bSortable": false
    	            }
                ],
                "bDestroy": true
            }).off( 'click' ).on( 'click', '.delete', function () {
                var orderId = $("#tours").DataTable().row($(this).closest('tr')).data().orderId;
                var url = "profile/mytours/tour?orderid="+ orderId + "&delete=true";
                var deleteTour = confirm("Are you shure you want to remove this tour?");
                if(deleteTour){
                    $.ajax({
                        url : url,
                        type: "DELETE",
                        success: function (data) {
                        	$('#tours-modal').modal('toggle');
                        },
                        error: function (jXHR, textStatus, errorThrown) {
                            alert(textStatus);
                        }
                    });
                }
   });;
});

$('#search-bookings:not(.bound)').addClass('bound').on('click', function(e) {
		e.preventDefault();
	    $('#bookings-modal').modal('toggle');
	    var table = $("#bookings").DataTable({
	        "ajax":{
	            url: "profile/mybookings",
	            dataType : "json",
	            type: "GET",
	            dataSrc:'',
	        },
	        "columns": [
	            { "data": "bookingId"},
	            {"data": "hotelId",
	            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
	            			if(oData.bookingId != null){
	            				$(nTd).html("<a href='dashboard/hotel?id="+oData.hotelId+"'>"+oData.hotelId+"</a>");
	            			}
	            	}
	            },
	            { "data": "checkin"},
	            { "data": "checkout"},
	            { "data": "price"},
	            {
	                "data": function(data, type) {
	                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
	                },
	                "bSortable": false
	            }
	        ],
	        "language": {
	            "emptyTable": "No data available in table"
	          },
	        "bDestroy": true
	    }).off( 'click' ).on( 'click', '.delete', function () {
            var bookingId = $("#bookings").DataTable().row($(this).closest('tr')).data().bookingId;
            var url = "profile/update/booking?id="+ bookingId + "&delete=true";
            var deleteBooking = confirm("Are you shure you want to remove this booking?");
            if(deleteBooking){
                $.ajax({
                    url : url,
                    type: "DELETE",
                    success: function (data) {
                    	$('#bookings-modal').modal('toggle');
                    },
                    error: function (jXHR, textStatus, errorThrown) {
                        alert(textStatus);
                    }
                });
            }
        });
	});

$('#search-flights:not(.bound)').addClass('bound').on('click', function(e) {
    	e.preventDefault();
        $('#flights-modal').modal('toggle');
        var table = $("#flights").DataTable({
            "ajax":{
                url: "profile/myflights",
                dataType : "json",
                type: "GET",
                dataSrc:'',
            },
            "columns": [
            	{ "data": "orderId"},
                { "data": "flightId",
                	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                			if(oData.flightId != null){
                				$(nTd).html("<a href='dashboard/flight?id="+oData.flightId+"'>"+oData.flightId+"</a>");
                			}
                	},
                "emptyTable": "<i>You have not booked any flights!</i>"
                },
	            {
	                "data": function(data, type) {
	                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
	                },
	                "bSortable": false
	            }
            ],
            "bDestroy": true
        }).off( 'click' ).on( 'click', '.delete', function () {
            var orderId = $("#flights").DataTable().row($(this).closest('tr')).data().orderId;
            var url = "profile/myflights/flight?orderid="+ orderId + "&delete=true";
            var deleteFlight = confirm("Are you shure you want to remove this flight?");
            if(deleteFlight){
                $.ajax({
                    url : url,
                    type: "DELETE",
                    success: function (data) {
                    	$('#flights-modal').modal('toggle');
                    },
                    error: function (jXHR, textStatus, errorThrown) {
                        alert(textStatus);
                    }
                });
            }
        });
    });
});
