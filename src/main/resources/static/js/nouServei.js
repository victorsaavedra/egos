$(document).ready( function() {

	$('#guardarNouServei').click(function(){
		$("#sistemaInformacio option:selected").each(function() {
			$('#nomSistemaInformacioNou').val( $(this).text() );
			$('#idSistemaInformacioNou').val( $(this).val() );
			
			//alert( '1 - ' + $('#nomSistemaInformacioNou').val() );
			
			crearElementsTaulaResponsable();
			
			$('#formEdicio').attr('method', "POST");
			
			$('#nouServeiForm').submit();
		});
	});
	
	$('#next').click(function() {
		if( $('.currentPage').attr('id') == 'page1' ) {
			//Form
			$('#page1').addClass('hide');
			$('#page1').removeClass('currentPage');
			$('#page2').removeClass('hide');
			$('#page2').addClass('currentPage');
			//Wizard
			$('#js-wizardPage1').removeClass('current');
			$('#js-wizardPage2').addClass('current');
			//Buttons
			$('#previous').removeClass('disabled');
			
		} else if( $('.currentPage').attr('id') == 'page2' ) {
			//Form
			$('#page2').addClass('hide');
			$('#page2').removeClass('currentPage');
			$('#page3').removeClass('hide');
			$('#page3').addClass('currentPage');
			//Wizard
			$('#js-wizardPage2').removeClass('current');
			$('#js-wizardPage3').addClass('current');
			//Buttons
			$('#next').addClass('hide');
			$('#next').addClass('disabled');
			$('#guardar').removeClass('hide');
			
		}
	});
	$('#previous').click(function() {
		if( $('.currentPage').attr('id') == 'page2' ) {
			//Form
			$('#page2').addClass('hide');
			$('#page2').removeClass('currentPage');
			$('#page1').removeClass('hide');
			$('#page1').addClass('currentPage');
			//Wizard
			$('#js-wizardPage1').addClass('current');
			$('#js-wizardPage2').removeClass('current');
			//Buttons
			$('#next').removeClass('disabled');
			$('#previous').addClass('disabled');
		} else if( $('.currentPage').attr('id') == 'page3' ) {
			//Form
			$('#page3').addClass('hide');
			$('#page3').removeClass('currentPage');
			$('#page2').removeClass('hide');
			$('#page2').addClass('currentPage');
			//Wizard
			$('#js-wizardPage2').addClass('current');
			$('#js-wizardPage3').removeClass('current');
			//Buttons
			$('#guardar').addClass('hide');
			$('#next').removeClass('disabled');
			$('#next').removeClass('hide');
		}
	});
	
	$('#js-wizardPage1').click(function() {
		//Form
		var currentPageId = $('.currentPage').attr('id');
		$('#'+currentPageId).removeClass('currentPage');
		$('#'+currentPageId).addClass('hide');
		$('#page1').addClass('currentPage');
		$('#page1').removeClass('hide');
		
		//Wizard
		var currentWizardId = $('.current').attr('id');
		$('#'+currentWizardId).removeClass('current');
		$('#js-wizardPage1').addClass('current');
		//Buttons
		if( !$('#previous').hasClass('disabled') ) {
			$('#previous').addClass('disabled');
		}
		if( !$('#guardar').hasClass('hide') ) {
			$('#guardar').addClass('hide');
		}
		if( $('#next').hasClass('disabled') ) {
			$('#next').removeClass('disabled');
		}
		if( $('#next').hasClass('hide') ) {
			$('#next').removeClass('hide');
		}

	});
	$('#js-wizardPage2').click(function() {
		//Form
		var currentPageId = $('.currentPage').attr('id');
		$('#'+currentPageId).removeClass('currentPage');
		$('#'+currentPageId).addClass('hide');
		$('#page2').addClass('currentPage');
		$('#page2').removeClass('hide');
		
		//Wizard
		var currentWizardId = $('.current').attr('id');
		$('#'+currentWizardId).removeClass('current');
		$('#js-wizardPage2').addClass('current');
		
		//Buttons
		if($('#previous').hasClass('disabled')) $('#previous').removeClass('disabled');
		if(!$('#guardar').hasClass('hide')) $('#guardar').addClass('hide');
		if($('#next').hasClass('disabled')) $('#next').removeClass('disabled');
		if($('#next').hasClass('hide')) $('#next').removeClass('hide');
	});

	$('#js-wizardPage3').click(function() {
		//Form
		var currentPageId = $('.currentPage').attr('id');
		$('#'+currentPageId).removeClass('currentPage');
		$('#'+currentPageId).addClass('hide');
		$('#page3').addClass('currentPage');
		$('#page3').removeClass('hide');
		
		//Wizard
		var currentWizardId = $('.current').attr('id');
		$('#'+currentWizardId).removeClass('current');
		$('#js-wizardPage3').addClass('current');
		
		//Buttons
		if($('#previous').hasClass('disabled')) {
			$('#previous').removeClass('disabled');
		}
		if($('#guardar').hasClass('hide')) {
			$('#guardar').removeClass('hide');
		}
		if($('#next').hasClass('disabled')) {
			$('#next').addClass('disabled');
		}
		if(!$('#next').hasClass('hide')) {
			$('#next').addClass('hide');
		}
	});
	
	$('#accesInternet').change(function(){
		var valueSelect = $(this).val();
		
		if(valueSelect == '2') {
			$('#js-accesInternet').removeClass('hide');
			$('#js-accesInternet').addClass('show');
		} else {
			$('#js-accesInternet').removeClass('show');
			$('#js-accesInternet').addClass('hide');
		}
	});
	
	$('#accesIntranetUPC').change(function(){
		var valueSelect = $(this).val();
		
		if(valueSelect == '2') {
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
	
	$('#nouSistemaInformacioButton').click(function(){
		$('#nouSistemaInformacio').modal('show');
	});
	
	$('#editarSistemaInformacioButton').click(function(){
		$('#editarSistemaInformacio').modal('show');
	});
	
	$('#afegirResponsableButton').click(function(){
		$('#afegirResponsable').modal('show');
	});
	
	$('#afegirOperacioButton').click(function(){
		$('#afegirOperacio').modal('show');
	});
	
	$('#guardarNouSistemaInformacio').click(function(){
		var nom = $('#nomNouSistemaInformacio').val();
		if ( nom != '') {
			$('#sistemaInformacio').append("<option value='-1' selected>" + nom + "</option>");
			$('#nouSistemaInformacio').modal('hide');
			$('#sistemaInformacio').prop('disabled','disabled');
			$('#nouSistemaInformacioButton').hide();
			$('#nomNouSistemaInformacio').val('');
			if( $('#editarSistemaInformacioButton').hasClass('hide') ) {
				$('#editarSistemaInformacioButton').removeClass('hide');
			} else {
				$('#editarSistemaInformacioButton').show();
			}
		}
	});
	
	$('#guardarEdicioSistemaInformacio').click(function(){
		var nom = $('#nomEdicioSistemaInformacio').val();
		if ( nom != '') {
			$("#sistemaInformacio option[value='-1']").each(function() {
			    $(this).text(nom);
			});
			$('#editarSistemaInformacio').modal('hide');
		} else {
			deleteNouSistemaInformacio();
		}
	});

	
	$('#editarSistemaInformacioButton').click( function() {
		$("#sistemaInformacio option[value='-1']").each(function() {
		    $('#nomEdicioSistemaInformacio').val( $(this).text() );
		});
	});
	
	$('#eliminarEdicioSistemaInformacio').click(function(){
		deleteNouSistemaInformacio();
	});
	
	$('#guardarResponsable').click( function() {
		$("#rolResponsableModal option:selected").each(function() {
		    var rol = $(this).text();
		    var rolValue = $(this).val();
		    var nomCognoms = $('#nomCognomsResponsableModal').val();
		    var username = $('#usernameResponsableModal').val();
		    var password = $('#passwordResponsableModal').val();
		    var departament = $('#departamentResponsableModal').val();
		    var telefon = $('#telefonResponsableModal').val();
		    var email = $('#emailResponsableModal').val();
		    nouFilaResponsable(nomCognoms, username, password, departament, rolValue, rol, telefon, email);
		    $('#nomCognomsResponsableModal').val('');
		    $('#usernameResponsableModal').val('');
		    $('#passwordResponsableModal').val('');
		    $('#rolResponsableModal').val(1);
		    $('#departamentResponsableModal').val('');
		    $('#telefonResponsableModal').val('');
		    $('#emailResponsableModal').val('');
		});
	});
	
	$( "#taulaResponsables" ).delegate(".js-deleteResponsable", "click", function() {
		var registreAEsborrar = $(this).closest('.js-registreResponsable');
		registreAEsborrar.remove();
	});
	
	$('#guardarOperacio').click( function() {
		    var nom = $('#nomOperacio').val();
		    var descripcio = $('#descripcioOperacio').val();
		    nouFilaOperacio(nom, descripcio);
		    $('#nomOperacio').val('');
		    $('#descripcioOperacio').val('');
	});
	
	$("#taulaOperacions").delegate(".js-deleteOperacio", "click", function() {
		var registreAEsborrar = $(this).closest('.js-registreOperacio');
		registreAEsborrar.remove();
	});
	
});

function Responsable(nomCognoms, username, password, departament, idRol, telefon, email) {
	this.nomCognoms = nomCognoms;
	this.username = username;
	this.password = password;
	this.departament = departament;
	this.idRol = idRol;
	this.telefon = telefon;
	this.email = email;
}

function crearElementsTaulaResponsable() {
	var registresResponsable = new Array;
	
	$('.js-registreResponsable').each(function(index) {	
		var pojoResponsable;
		var nomCognoms = $(this).find('td').eq(0).text()
		var username = $(this).find('td').eq(0).data('username')
		var password = $(this).find('td').eq(0).data('password')
		var departament = $(this).find('td').eq(1).text()
		var idRol = $(this).find('td').eq(2).data('id')
		var telefon = $(this).find('td').eq(3).text()
		var email = $(this).find('td').eq(4).text()
		
		pojoResponsable = new Responsable(nomCognoms, username, password, departament, idRol, telefon, email);
		registresResponsable.push(pojoResponsable);
	});	
	var sourceTemplate = $("#templateRegistresResponsableTable").html();
	var template = Handlebars.compile(sourceTemplate);
	var html = template(registresResponsable);

	$('#nouServeiForm').html(html);
}

function afegirRegistresPosErrorValidacio(){
	$('#registresResponsable').val($('#registresCompetenciesGenerals').html());
}

function deleteNouSistemaInformacio() {
	$("#sistemaInformacio option[value='-1']").each(function() {
	    $(this).remove();
	});
	$('#editarSistemaInformacio').modal('hide');
	$('#nomEdicioSistemaInformacio').val('');
	$('#sistemaInformacio').prop('disabled', false);
	$('#nouSistemaInformacioButton').show();
	$('#editarSistemaInformacioButton').hide();
}

function nouFilaResponsable(nomCognoms, username, password, departament, rolValue, rol, telefon, email) {
	$('#nomCognomsResponsable').val(nomCognoms);
	$('#usernameResponsable').val(username);
	$('#passwordResponsable').val(password);
	$('#departamentResponsable').val(departament);
	$('#rolResponsable').val(rolValue);
	$('#rolTextResponsable').val(rol);
	$('#telefonResponsable').val(telefon);
	$('#mailResponsable').val(email);
	
	var dataJsonTemplate = $("#afegirResponsableForm").jsonify();
		
	var sourceTemplate = $("#templateResponsablesTable").html();
	var template = Handlebars.compile(sourceTemplate);
	var html = template(dataJsonTemplate);
	$('#registresResponsables').append(html);
}

/*function nouFilaResponsable(nomCognoms, username, password, departament, rolValue, rol, telefon, email) {
    var accio ="<button class='btn btn-default btn-sm js-deleteResponsable' type='button' data-toggle='modal'><span class='fa fa-trash-o'></span></button>";
    $('#taulaResponsables > tbody:last').append(
	    	"<tr class='js-registreResponsable'>" +
	    		"<td data-username='"+ username +"' data-password='"+ password +"'>" + nomCognoms + "</td>" +
	    		"<td>" + departament + "</td>" +
	    		"<td data-id='" + rolValue + "'>" + rol + "</td>" +
	    		"<td>" + telefon + "</td>" +
	    		"<td>" + email + "</td>" +
	    		"<td>" + accio + "</td>" +
	    	"</tr>");
}*/

function nouFilaOperacio(nom, descripcio) {
    var accio ="<button class='btn btn-default btn-sm js-deleteOperacio' type='button' data-toggle='modal'><span class='fa fa-trash-o'></span></button>";
    $('#taulaOperacions > tbody:last').append(
	    	"<tr class='js-registreOperacio'>" +
	    		"<td>" + nom + "</td>" +
	    		"<td>" + descripcio + "</td>" +
	    		"<td class='text-center'>" + accio + "</td>" +
	    	"</tr>");
}