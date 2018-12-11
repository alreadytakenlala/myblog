// Window Scroll
var windowScroll = function () {
    $(window).scroll(function () {

        if ($(window).scrollTop() > 70)
        {
            $('header').removeClass('source_location');
            $('.navbar').removeClass('source_location');
            $('.logo').children().children(":last").removeClass('source_location');
            $('#example-navbar-collapse').children('ul').children('li').children('a').children('span').removeClass('source_location');
        }
        else
        {
            $('header').addClass('source_location');
            $('.navbar').addClass('source_location');
            $('.logo').children().children(":last").addClass('source_location');
            $('#example-navbar-collapse').children('ul').children('li').children('a').children('span').addClass('source_location');
        }
    });
};

$( document ).ready(function() {
    windowScroll();
});