var api = "webapi/student";
$.get(api, function (student, status) {
    if (status == "success") {
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
    }
    $('#student_data').DataTable();
});

