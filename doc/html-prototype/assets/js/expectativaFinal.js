

$( document ).ready(function() {
	
	
	$('.altaExpectativa').click(function() {
		window.location.href = "expectativaFinalEdicio.html";
	});
	
	
	$('#deleteExpectativa').on('shown.bs.modal', function () {
		 $( "#deleteExpectativa .modal-content" ).effect('shake');
	})

	

});
