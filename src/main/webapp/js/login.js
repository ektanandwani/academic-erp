$(document).ready(function() {
    validateLogin();
});

function validateLogin(){
    $('#login').click(function(event) {
        event.preventDefault();
        var domainId = $('#domainId').val();
        var organizationId = $('#organizationId').val();
        document.cookie = "username=";
        var json =  {'orgId':organizationId,
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
            success: function(student) {

                    var student_data_body = "";
                    for (var i = 0; i < student.length; i++) {
                        var domainName = student[i].domain.discipline + " " + student[i].domain.branch;
                        var orgName;
                        if(!student[i].organization) {
                            orgName = "N/A";
                        }
                        else {
                            orgName = student[i].organization.name;
                        }
                        student_data_body += '<tr>'
                            + '<td>' + student[i].id + '</td>'
                            + '<td>' + student[i].rollNumber + '</td>'
                            + '<td>' + student[i].firstName + '</td>'
                            + '<td>' + student[i].lastName + '</td>'
                            + '<td>' + student[i].emailId + '</td>'
                             + '<td>' + domainName + '</td>'
                            + '<td>' + orgName +'</td>'
                            + '</tr>';
                    }
                    $('#student_data tbody').html(student_data_body);


                    // window.localStorage.setItem('rollNo', response.rollNumber);
                    // window.location.href = "/webapi/student";
                //    alert("data recieved");

                //$('.login-error').show();

                // $('#rollNo').val("");
                // $('#password').val("") ;
            },
            error : function(response){

            }
        });
    });
}