$(document).ready(function() {
    validateLogin();
});

function validateLogin(){
    $('#login').click(function(event) {
        event.preventDefault();
        var domainId = $('#domainId').val();
        var organizationId = $('#organizationId').val();
        document.cookie = "username=";
        var json =  {'orgID':organizationId,
            'domainId':domainId
        };
        $.ajax({
            url: "/webapi/student/submit",
            method: "POST",
            dataType: "JSON",
            contentType: "application/json",
            data: JSON.stringify(json),
            cache: false,
            async: true,
            timeout: 600000,
            success: function(response) {
                if(response.status=="200"){
                    // window.localStorage.setItem('rollNo', response.rollNumber);
                    // window.location.href = "/webapi/student";
                    alert("data recieved");
                }
                else
                    alert("Wrong Username or Password");
                //$('.login-error').show();

                $('#rollNo').val("");
                $('#password').val("") ;
            },
            error : function(response){

            }
        });
    });
}