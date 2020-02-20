/*$(document).ready(function() {
	$('.signupbtn').on('click', function(e) {
	    e.preventDefault();
	    $.ajax({
	    url : "signing",
	    type: "POST",
	    data: $('#signup').serialize(),
	    success: function (data) {
           // window.history.pushState('dasboard', 'Home', '/dasboard');
	       },
	        error: function (jXHR, textStatus, errorThrown) {
	         alert(textStatus);
	         }
	     });
	});
});*/

//action="signing" method="post"
/*$('#login').on('submit', function(e) {

    console.log("submit");
    e.preventDefault();
    $.ajax({
        url : "/logging",
        type: "POST",
        data: $('#loggin').serialize(),
        success: function (data) {
            console.log("logging");
            //$("#schedule").html(data);
        },
        error: function (jXHR, textStatus, errorThrown) {
            alert(textStatus);
        }
    });
});*/
$(document).ready(function() {
    var signUp = document.getElementById('id02');
    var login = document.getElementById('id01');
    window.onclick = function (event) {
        if (event.target == signUp) {
            signUp.style.display = "none";
        }
        if (event.target == login) {
            login.style.display = "none";
        }
    };
});

    $(document).ready(function() {
    var date_input=$('input[name="birthday"]'); //our date input has the name "date"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    date_input.datepicker({
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
        orientation: 'top auto',
    });
        $('#repeatPassword-signup').on('keyup', function () {
            if ($('#inputPassword-signup').val() == $('#repeatPassword-signup').val()) {
                $('.confirm-password').removeClass('has-error');
                $('#signup :input[type="submit"]').prop('disabled', false);
                $('#repeatPassword-signup').css("background-color", "#f1f1f1");
                $('#signup :input[type="submit"]').css("background-color", "#75c2f4");
            } else{
                $('#repeatPassword-signup').css("background-color", "#ffcccc");
                $('#signup :input[type="submit"]').css("background-color", "#7a7a7a");
                $('#signup :input[type="submit"]').prop('disabled', true);
                $('.confirm-password').addClass('has-error');
            }
        });
    });






