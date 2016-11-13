// JavaScript Document
$(window).load(function(){
      $("[data-toggle]").click(function() {
        var toggle_el = $(this).data("toggle");
        $(toggle_el).toggleClass("open-sidebar");
      });
});//]]>

$('.slider').slick({
    dots: false,
});	
$(document).ready(function() {
	$('.open_list').click(function(){
		$('.select_hidden').toggleClass('select_is_open');
	});
});

$('.slider-for').slick({
  slidesToShow: 1,
  slidesToScroll: 1,
  arrows: false,
  fade: true,
  asNavFor: '.slider-nav'
});
$('.slider-nav').slick({
  slidesToShow: 5,
  slidesToScroll: 1,
  centerPadding: '0',
  asNavFor: '.slider-for',
  dots: false,
  arrows: true,
  centerMode: false,
  focusOnSelect: true,
  responsive: [
    {
		breakpoint: 761,
		settings: {
        slidesToShow:3,
		
      }
	},
	{
		breakpoint: 481,
		settings: {
        slidesToShow: 1,
		arrows: true,
      }
	}
  ]
});