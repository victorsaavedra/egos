
$(document).ready( function() {
	
	$('.js-jumbotron').click(function() {
		var idClicat = $(this).children('span').attr('id');
		var idMetamodelCerca = $(this).children('span').attr('data-idMetamodel');
		var idActual = $('.circle-active').closest('span').attr('id');
		
		$('#' + idActual).children('a').children('.js-circle').removeClass('circle-active');
		$('#' + idActual).children('.js-icon').removeClass('icon-circle-active');
		$('#' + idActual).children('a').children('.js-circle').addClass('circle');
		$('#' + idActual).children('.js-icon').addClass('icon-circle');
		
		$('#' + idClicat).children('a').children('.js-circle').addClass('circle-active');
		$('#' + idClicat).children('.js-icon').addClass('icon-circle-active');
		$('#' + idClicat).children('a').children('.js-circle').removeClass('circle');
		$('#' + idClicat).children('.js-icon').removeClass('icon-circle');

		if(idMetamodelCerca != '7') {
			$('#formJumbotron').children($('#metamodelCerca')).val(idMetamodelCerca);
		} else {
			$('#formJumbotron').children($('#metamodelCerca')).val();
		}
		
		$('#formJumbotron').attr('method','GET');
		$('#formJumbotron').submit();
	});
	
	$('#cerca').click(function() {
		$('#formCerca').attr('method', 'GET');
		$('#formCerca').submit();
	});
	
	$('.js-serveiEdicio').click(function() {
		var href = $(this).attr('href');
		$('#formServei').attr('action', href);
		$('#formServei').attr('method', 'GET');
		$('#formServei').submit();
	});
		
	//Inicialitzem el jumbotron
	inicialitzarJumbotron();
	
});

function inicialitzarJumbotron() {
	var idJumbotronActual = $('#tots-circle').attr('id');
	 
	$('#' + idJumbotronActual).children('a').children('.js-circle').removeClass('circle-active');
	$('#' + idJumbotronActual).children('.js-icon').removeClass('icon-circle-active');
	$('#' + idJumbotronActual).children('a').children('.js-circle').addClass('circle');
	$('#' + idJumbotronActual).children('.js-icon').addClass('icon-circle');

	
	 switch($('#metamodelSeleccionat').val()) {
	    case '2':
			var idSeleccionat = $('#identitat-circle').attr('id');
	        break;
	    case '3':
	    	var idSeleccionat = $('#docencia-circle').attr('id');
	    	break;
	    case '4':
	    	var idSeleccionat = $('#doctorands-circle').attr('id');
	    	break;
	    case '5':
	    	var idSeleccionat = $('#biblioteques-circle').attr('id');
	        break;
	    case '1':
	    	var idSeleccionat = $('#alumnes-circle').attr('id');
	        break;
	    default:
	    	var idSeleccionat = $('#tots-circle').attr('id');
	    	break;
	}
	 
	$('#' + idSeleccionat).children('a').children('.js-circle').addClass('circle-active');
	$('#' + idSeleccionat).children('.js-icon').addClass('icon-circle-active');
	$('#' + idSeleccionat).children('a').children('.js-circle').removeClass('circle');
	$('#' + idSeleccionat).children('.js-icon').removeClass('icon-circle');
}

