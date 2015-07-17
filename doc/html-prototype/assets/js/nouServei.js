$(document).ready( function() {

	$('#next').click(function() {
		if($('.currentPage').attr('id') == 'page1') {
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
			
		} else if($('.currentPage').attr('id') == 'page2') {
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
		if($('.currentPage').attr('id') == 'page2') {
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
		} else if($('.currentPage').attr('id') == 'page3') {
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
		if(!$('#previous').hasClass('disabled')) {
			$('#previous').addClass('disabled');
		}
		if(!$('#guardar').hasClass('hide')) {
			$('#guardar').addClass('hide');
		}
		if($('#next').hasClass('disabled')) {
			$('#next').removeClass('disabled');
		}
		if($('#next').hasClass('hide')) {
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
		if($('#previous').hasClass('disabled')) {
			$('#previous').removeClass('disabled');
		}
		if(!$('#guardar').hasClass('hide')) {
			$('#guardar').addClass('hide');
		}
		if($('#next').hasClass('disabled')) {
			$('#next').removeClass('disabled');
		}
		if($('#next').hasClass('hide')) {
			$('#next').removeClass('hide');
		}
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
}).delay(5000);