var api = "webapi/domain";
var api2 = "webapi/organization";
$.get(api, function (domain, status) {
    if (status == "success") {
        var domainOptions = "";
        for (var i = 0; i < domain.length; i++) {
            domainOptions += '<option value="' + domain[i].id + '">' + domain[i].discipline + ' ' + domain[i].branch + '</option>';
        }
        $("#domainId").append(domainOptions);
    }
});


$.get(api2, function (organization, status) {
    if (status == "success") {
        var organizationOptions = "";
        for (var i = 0; i < organization.length; i++) {
            organizationOptions += '<option value="' + organization[i].id + '">' + organization[i].name + ' ' + organization[i].location + '</option>';
        }
        $("#organizationId").append(organizationOptions);
    }
});
