$(document).ready(function(){
	
	/*
	 * Mostrar div d'espera per a totes les peticions Ajax
	 */
	$(document).ajaxSend(function() {
		$("#waitModal").modal({
			backdrop: 'static' ,
			show: true
		});
	});

	/*
	 * Ocultar div d'espera quan finalitza una petició Ajax
	 */
	$(document).ajaxStop(function() {
		$("#waitModal").modal('hide');
	});
	
	
	/*
	 * Controlar si ha caducat la sessió de l'usuari en una petició Ajax, 
	 * en aquest cas redirecciona a l'usuari a la pàgina principal 
	 * per autenticar-se
	 */
	$( document ).ajaxComplete(function( event, jqXHR, settings ) {
		// 401- Session caducada o usuari no autoritzat 
		if (jqXHR.status == 401) {
			 window.location.href = sessionExpiredPath;
		 }
	});
	
	
	/*
	 * Habilitar el tooltip de Boostrap, 
	 * sempre que el dispositiu no sigui touchscreen 
	 */
	if(('ontouchstart' in document.documentElement) == false){
		$('body').tooltip({ 
			 selector: '[data-toggle=tooltip]' 
		});
	} 
	
	
});



/*
 *  Gestionar el control de tornada de les urls a més d'un nivell
 */
function controlTornar(){
	var urlBackRefererTop = $('#urlBackRefererTop').val();
	var urlBackReferer = $('#urlBackReferer').val();
	var tornarInici = $('#tornarInici').val();
	var urlTornar = '';
		
	if(urlBackRefererTop == ''){
		urlBackRefererTop = urlBackReferer;
	}
	
	if(tornarInici == ''){
		urlTornar =  urlBackReferer;
		
	} else if(tornarInici == 'true'){
		var position = urlBackReferer.indexOf('?');
		if(position != -1){
			urlBackReferer = urlBackReferer.substr(0,position);
		}
		urlTornar = urlBackReferer + '?urlBackRefererTop=' + encodeURIComponent(urlBackRefererTop) + '&tornarInici=false';
		
	} else if(tornarInici == 'false'){
		urlTornar =  urlBackRefererTop;
	}
	
	$(location).attr('href', urlTornar);
}


