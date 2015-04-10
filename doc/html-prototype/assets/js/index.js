$(document).ready( function() {
	
	$('.js-jumbotron').click(function() {
		var idClicat = $(this).children('span').attr('id');
		var idActual = $('.circle-active').closest('span').attr('id');
		
		$('#' + idActual).children('a').children('.js-circle').removeClass('circle-active');
		$('#' + idActual).children('.js-icon').removeClass('icon-circle-active');
		$('#' + idActual).children('a').children('.js-circle').addClass('circle');
		$('#' + idActual).children('.js-icon').addClass('icon-circle');
		
		$('#' + idClicat).children('a').children('.js-circle').addClass('circle-active');
		$('#' + idClicat).children('.js-icon').addClass('icon-circle-active');
		$('#' + idClicat).children('a').children('.js-circle').removeClass('circle');
		$('#' + idClicat).children('.js-icon').removeClass('icon-circle');

	});
});