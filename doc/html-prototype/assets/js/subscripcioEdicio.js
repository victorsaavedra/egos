$(document).ready(function(){
	$('#js-ipExplotacioIntranet').click(function(){
		var nouRegistre = "<div class='col-md-offset-3 col-md-4'><input type='text' class='form-control insertIpDinamica' id='ipAccesExplotacio' placeholder=''></div>";
		$('#novaIpExplotacioIntranet').append(nouRegistre);
	});
	
	$('#js-ipTestIntranet').click(function(){
		var nouRegistre = "<div class='col-md-offset-3 col-md-4'><input type='text' class='form-control insertIpDinamica' id='ipAccesExplotacio' placeholder=''></div>";
		$('#novaIpTestIntranet').append(nouRegistre);
	});
});