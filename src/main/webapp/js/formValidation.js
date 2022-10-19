$().ready(function() {
    $("#editProfileForm").validate({

        rules: {
            firstName: "required",
            lastName: "required",
            email: {
                required: true,
                email: true
            }
        },

        messages: {
            firstName: "First Name is required.",
            lastName: "Last Name is required.",
            email: {
                required: "Email is required.",
                email: "Please enter a valid email."
            }
        },

        submitHandler: function(form) {
            form.submit();
        }
    });
});