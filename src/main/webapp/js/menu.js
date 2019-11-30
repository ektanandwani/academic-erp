$(document).ready(function(){
    var userName = localStorage.getItem('userName');
    if(!userName)
        userName = "Hello!";
    $('#user').text("Hello, " + userName + "!");
});
