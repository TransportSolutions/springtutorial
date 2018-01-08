$(document).ready(main);

function main() {
    $('#about-us').click(function (e) {
        e.preventDefault();
        $('.lead').text('You clicked on about us button');
    })
}