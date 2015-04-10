$(document).ready( function() {

	 $('.datepicker').datepicker({
		format: 'dd/mm/yyyy'
	 });	
	 
	$('#cerca').click(function() {
		$('#formCerca').attr('method', 'GET');
		$('#formCerca').submit();
	});
	
	$('#nouServei*').click(function() {
		var href = $(this).attr('href');
		$('#formNou').attr('action', href);
		$('#formNou').attr('method', 'GET');
		$('#formNou').submit();
	});


});