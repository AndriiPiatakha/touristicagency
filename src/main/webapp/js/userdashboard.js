// Tabs

function openLink(evt, linkName) {
    var i, x, tablinks;
    x = document.getElementsByClassName("myLink");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" user-red", "");
    }
    document.getElementById(linkName).style.display = "block";
    evt.currentTarget.className += " user-red";
}
$(document).ready(function() {
    document.getElementsByClassName("tablink")[0].click();
});

$(document).ready(function() {
	$('#search-tours').on('click', function(e) {
        e.preventDefault();
        $("#tour-dates").removeClass('has-error');
	    var start = $("#tour-dates input[name='startDate']").val();
        var end = $("#tour-dates input[name='endDate']").val();
        var regexDate = /\d{2}\/\d{2}\/\d{4}/m;

        if(regexDate.test(start) && regexDate.test(end)){
            $('#tours-modal').modal('toggle');

        var table = $("#tours").DataTable({
            "ajax":{
                url: "tours/period",
                dataType : "json",
                type: "GET",
                "data": function(d){
                    d.startDate = start
                    d.endDate = end
                },
                dataSrc:'',
            },
            "columns": [
                { "data": "name"},
                { "data": "language"},
                {
                    "data": function(data, type) {
                        return "<a class='details btn btn-info btn-sm'>Details</a>";
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

        }else{
            $("#tour-dates").addClass('has-error');
        };
        $('#tours tbody').on( 'click', 'a', function () {
            var tourId = $("#tours").DataTable().row($(this).closest('tr')).data().tourId;
            var url = "dashboard/tour?id="+ tourId;
            window.open(url, '_blank');
        } );
	});

    $('#search-flights').on('click', function(e) {
        e.preventDefault();
        $("#flight-dates").removeClass('has-error');
        var start = $("#flight-dates input[name='startDate']").val();
        var end = $("#flight-dates input[name='endDate']").val();
        var regexDate = /\d{2}\/\d{2}\/\d{4}/m;

        if(regexDate.test(start) && regexDate.test(end)){
            $('#flights-modal').modal('toggle');
            $("#flights").DataTable({
                "ajax":{
                    url: "flights/period",
                    dataType : "json",
                    type: "GET",
                    "data": function(d){
                        d.startDate = start
                        d.endDate = end
                    },
                    dataSrc:'',
                },
                "columns": [
                
                    { "data": "from"},
                    { "data": "to"},
                    { "data": "departureDate"},
                    {
                        "data": function(data, type) {
                            return "<a class='fligt-details btn btn-info btn-sm'>Details</a>";
                        },
                        "bSortable": false
                    }
                ],
                "columnDefs": [
                    { "width": "5%", "targets": 0 },
                    { "width": "20%", "targets": 2 }
                ],
                "bDestroy": true

            });
        } else{
        	$("#flight-dates").addClass('has-error');        
        	}
        $('#flights tbody').on( 'click', 'a', function () {
            var flightID = $("#flights").DataTable().row($(this).closest('tr')).data().flightID;
            var url = "dashboard/flight?id="+ flightID;
            window.open(url, '_blank');
        } );
    });

    $('#search-hotels').on('click', function(e) {
    e.preventDefault();
    $(".hotel-select").css("background-color", "#ffffff");
    var city = $(".hotel-select").val();
    if(city != "default"){
        $('#hotels-modal').modal('toggle');
        $("#hotels").DataTable({
            "ajax":{
                url: "hotels/city",
                dataType : "json",
                type: "GET",
                "data": function(d){
                    d.city = city
                },
                dataSrc:'',
            },
            "columns": [
                { "data": "name"},
                { "data": "address"},
                {
                    "data": function(data, type) {
                        return "<a class='hotel-details btn btn-info btn-sm'>Details</a>";
                    },
                    "bSortable": false
                }
            ],
            "bDestroy": true

        });
    } else{
    	$(".hotel-select").css("background-color", "#ddffb7");
    	}
    $('#hotels tbody').on( 'click', 'a', function () {
        var hotelId = $("#hotels").DataTable().row($(this).closest('tr')).data().hotelId;
        var url = "dashboard/hotel?id="+ hotelId;
        window.open(url, '_blank');
    } );
});
    
    $('#search-rentals').on('click', function(e) {
        e.preventDefault();
        $(".rental-select").css("background-color", "#ffffff");
        var city = $(".rental-select").val();
        if(city != "default"){
            $('#rentals-modal').modal('toggle');
            $("#rentals").DataTable({
                "ajax":{
                    url: "rentals/city",
                    dataType : "json",
                    type: "GET",
                    "data": function(d){
                        d.city = city
                    },
                    dataSrc:'',
                },
                "columns": [
                    { "data": "name"},
                    {
                        "data": function(data, type) {
                            return "<a class='rentals-details btn btn-info btn-sm'>Details</a>";
                        },
                        "bSortable": false
                    }
                ],
                "bDestroy": true

            });
        }else{
        		$(".rental-select").css("background-color", "#ddffb7");
        	}
        $('#rentals tbody').on( 'click', 'a', function () {
            var rentalId = $("#rentals").DataTable().row($(this).closest('tr')).data().rentalId;
            var url = "dashboard/rental?id="+ rentalId;
            window.open(url, '_blank');
        } );
    });
});

$(document).ready(function() {
    $('.input-daterange').datepicker({
        autoclose: true,
        todayHighlight: true
    });
    $('#tours-modal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    });
    $('#flights-modal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    });
});
