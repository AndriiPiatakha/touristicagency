$(document).ready(function() {
	$("#booking-btn").on('click', function(e){
		e.preventDefault();
		$.ajax({
			url : $(this).attr('href'),
			type : "POST",
			success : function(data) {
				  $("#alert-area").append($("<div class=\"alert alert-success alert-dismissible fade in\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Success!</strong> Booking successful.</div>"));
	               $(".alert-success").delay(2000).fadeOut("slow", function () { $(this).remove(); });
			},
			error : function(jXHR, textStatus, errorThrown) {
				alert(textStatus);
			}
		});
		 return false;
	});
});
