$(document).ready(function() {
    validateLogin();
});

function validateLogin(){
    $('#admission-form').submit(function(event) {
        event.preventDefault();
        var userName = $('#userName').val();
        var password = $('#password').val();
        // document.cookie = "username=";
        var json =  {'userName':userName,
            'password':password
        };
        $.ajax({
            url: "/webapi/user",
            method: "POST",
            dataType: "JSON",
            contentType: "application/json",
            data: JSON.stringify(json),
            cache: false,
            async: true,
            timeout: 600000,
            success: function(response) {
                    var userName = $('#userName').val();
                    window.localStorage.setItem('userName', userName);
                    window.location.href = "/menu.html";
                // }
                // else
                //     alert("Wrong Username or Password");
                //$('.login-error').show();

                $('#userName').val("");
                $('#password').val("") ;
            },
            error : function(response){
                if(response.status=="401") {
                    alert("Wrong Username or Password");
                }
                else
                    alert("Unknown Error encountered");
            }
        });
    });
}