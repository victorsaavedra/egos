$(document).ready(function(){
	$('#accesInternet').change(function(){
		var valueSelect = $(this).val();
		
		if(valueSelect == '1') {
			$('#js-accesInternet').removeClass('hide');
			$('#js-accesInternet').addClass('show');
		} else {
			$('#js-accesInternet').removeClass('show');
			$('#js-accesInternet').addClass('hide');
		}
	});
	
	$('#accesIntranetUPC').change(function(){
		var valueSelect = $(this).val();
		
		if(valueSelect == '1') {
			$('#js-accesIntranet').removeClass('hide');
			$('#js-accesIntranet').addClass('show');
		} else {
			$('#js-accesIntranet').removeClass('show');
			$('#js-accesIntranet').addClass('hide');
		}
	});
	
	$('#js-ipExplotacioIntranet').click(function(){
		var nouRegistre = "<div class='col-md-offset-3 col-md-4'><input type='text' class='form-control insertIpDinamica' id='ipAccesExplotacio' placeholder=''></div>";
		$('#novaIpExplotacioIntranet').append(nouRegistre);
	});
	
	$('#js-ipTestIntranet').click(function(){
		var nouRegistre = "<div class='col-md-offset-3 col-md-4'><input type='text' class='form-control insertIpDinamica' id='ipAccesExplotacio' placeholder=''></div>";
		$('#novaIpTestIntranet').append(nouRegistre);
	});
});