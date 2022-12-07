$().ready(function() {
    $("#editProfileForm").validate({

        rules: {
            firstName: "required",
            lastName: "required",
            email: {
                required: true,
                email: true
            },
            zip: "required"
        },

        messages: {
            firstName: "First Name is required.",
            lastName: "Last Name is required.",
            email: {
                required: "Email is required.",
                email: "Please enter a valid email."
            },
            zip: "Please enter a zip code"
        },

        submitHandler: function(form) {
            form.submit();
        }
    });
});