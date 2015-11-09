$(document).ready(function() {

	$("#registrationLogin").validate({

		rules : {

			firstName : {
				required : true
			},

			lastName : {
				required : true
			},

			login : {
				required : true,
				minlength : 4,
				maxlength : 20
			},

			password : {
				required : true,
				minlength : 6
			},

			confirmPassword : {
				required : true,
				minlength : 6,
				equalTo : "#password_id"
			}

		},

		messages : {


			confirmPassword : {

				equalTo : "Passwords are not equal"
			}
		}

	});

}); // end of ready
