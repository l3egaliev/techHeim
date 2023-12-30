$(document).ready(function(){
    $('.slider').slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        infinite: true,
        centerMode: false,
        variableWidth: true,
        nextArrow: $('.next'),
        prevArrow: $('.prev'),
        autoplay: true,
        autoplaySpeed: 1500,
    });
});