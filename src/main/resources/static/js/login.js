$(document).ready(main);

function main() {
    $('#signUp').click(function (e) {
        e.preventDefault();
        $('#loginbox').hide();
        $('#signupbox').show()
    })

    $('#signinlink').click(function (e) {
        e.preventDefault();
        $('#signupbox').hide();
        $('#loginbox').show();
    })
}