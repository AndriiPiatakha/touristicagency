$(document).ready(function() {
	   $('.input-daterange').datepicker({
	        autoclose: true,
	        todayHighlight: true
	    });
	  
	   var staying = function(selectedDate){
		    var startDate = $('#startDate').datepicker('getDate');
		    var endDate = $('#endDate').datepicker('getDate');
		    var difference = 0;
		    if (startDate && endDate) {
		    	difference = Math.floor((endDate.getTime() - startDate.getTime()) / 86400000); // ms per day
	      }
		    var days = difference + 1;
		    var rentalPrice = parseInt($('#rental_price').html());
		    $('#price').val(days * rentalPrice);
		    $('#days').val(days);
		}
	   $('#startDate').datepicker().on('changeDate', staying);
	   $('#endDate').datepicker().on('changeDate', staying);

	$("#booking-btn").on('click', function(e){
		e.preventDefault();
		$(".input-daterange").removeClass('has-error');
	    var start = $(".input-daterange input[name='startDate']").val();
        var end = $(".input-daterange input[name='endDate']").val();
        var regexDate = /\d{2}\/\d{2}\/\d{4}/m;
        
        if(regexDate.test(start) && regexDate.test(end)){
		$.ajax({
			url : $(this).attr('href'),
			type : "POST",
			data : $('#reservation-form').serialize(),
			success : function(data) {
				  $("#alert-area").append($("<div class=\"alert alert-success alert-dismissible fade in\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Success!</strong> Booking successful.</div>"));
	                $(".alert-success").delay(2000).fadeOut("slow", function () { $(this).remove(); });
	            
			},
			error : function(jXHR, textStatus, errorThrown) {
				alert(textStatus);
			}
		});
		 return false;
	}else{
		$(".input-daterange").addClass('has-error');
	}
	});
});
