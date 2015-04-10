package es.upcnet.egos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.form.ServeisForm;
import es.upcnet.egos.service.interfaces.ComentariService;
import es.upcnet.egos.service.interfaces.ServeisService;
import es.upcnet.egos.service.interfaces.SistemaInformacioService;
import es.upcnet.egos.view.ServeisView;

@RequestMapping("/serveis")
@Controller
public class ServeisController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalegController.class);
	private static final String SERVEIS_FORM = "serveisForm";
	
	@Autowired
	private ServeisService serveisService;
	
	@Autowired
	private SistemaInformacioService sistemaInformacioService;
	
	@Autowired
	private ComentariService comentariService;
	
	@RequestMapping(method = RequestMethod.GET)
    public final ModelAndView list(ServeisForm serveisForm, HttpServletRequest request) {
		LOGGER.info("Accedir a la vista dels serveis.");

		serveisService.inicialitzarCatalegForm(serveisForm);
		
		final List<SistemaInformacio> registresServeisCerca = serveisService.findServeisByCriteriCerca(serveisForm);
		final List<SistemaInformacio> registresSubscripcioCerca = serveisService.findSubscripcioByCriteriCerca(serveisForm);
		serveisForm.setRegistresServeisCataleg(registresServeisCerca);
		serveisForm.setRegistresSubscripcionsCataleg(registresSubscripcioCerca);

		return new ModelAndView(ServeisView.CERCA.getView(),SERVEIS_FORM, serveisForm);
	}
	
	
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public final ModelAndView createForm(HttpServletRequest request) {
    	LOGGER.info("Formulari per a crear un nou servei.");

    	final ServeisForm serveisForm = new ServeisForm();
    	final Servei servei = new Servei();
    	
    	serveisForm.setServei(servei);
    	serveisForm.setShowNouSistemaInformacio(true);
    	    	
    	serveisService.inicialitzarRegistresNouServei(serveisForm);
    	
    	return new ModelAndView(ServeisView.NOUSERVEI.getView(),  SERVEIS_FORM , serveisForm);
    }
    
    @RequestMapping(value = "/{idServei}", method = RequestMethod.GET)
    public final ModelAndView find(@PathVariable("idServei") Integer idServei, HttpServletRequest request) {	
    	LOGGER.info("Accedir a la vista d'un servei per la seva id.");
    	final ServeisForm serveisForm = new ServeisForm();
    	Servei servei;
    	
    	servei = serveisService.findServeiById(idServei);
    	serveisForm.setServei(servei);
    	
    	serveisService.inicialitzarRegistresEdicio(serveisForm);
    	
    	return new ModelAndView(ServeisView.EDITAR.getView(), SERVEIS_FORM , serveisForm);
    }
    
    @RequestMapping(value = "/{idServei}", method = RequestMethod.POST)
    public final ModelAndView newServei(@PathVariable("idServei") Integer idServei, HttpServletRequest request, @Valid ServeisForm serveisForm, BindingResult result) {
    	Servei serveiPersisted;
    	Boolean errorsValidacio = true;
    	
    	if(result.hasErrors() == false) {
    		try {
    			serveisForm.getServei().setIdServei(idServei);
    			serveiPersisted = serveisService.save(serveisForm);
    			serveisForm.setServei(serveiPersisted);
    			errorsValidacio = false;
    		} catch(JpaSystemException jpaerr) {
	    		final StringBuilder sbLog = new StringBuilder("Error de violació de constraint en BBDD ").append(jpaerr.getMessage());
	    		LOGGER.debug( sbLog.toString() );
    		}
    	} else {
    		errorsValidacio = true;
    	}
    	
    	serveisForm.setErrorsValidacio(errorsValidacio);
    	serveisService.inicialitzarCatalegForm(serveisForm);
    	
    	return new ModelAndView(ServeisView.NOUSERVEI.getView(), SERVEIS_FORM , serveisForm);
    }

    @RequestMapping(value = "/guardarComentari/", method = RequestMethod.PUT)
    public final ModelAndView guardarComentari(ServeisForm serveisForm, HttpServletRequest request, BindingResult result) {	
    	LOGGER.info("Guardar un nou comentari.");
    	Boolean errorsValidacio = true;
    	
    	if(result.hasErrors() == false) {
    		try {
    			comentariService.save(serveisForm);
    			errorsValidacio = false;
    		} catch(JpaSystemException jpaerr) {
	    		final StringBuilder sbLog = new StringBuilder("Error de violació de constraint en BBDD ").append(jpaerr.getMessage());
	    		LOGGER.debug( sbLog.toString() );
    		}
    	} else {
    		errorsValidacio = true;
    	}
    	
    	serveisForm.setErrorsValidacio(errorsValidacio);
    	serveisService.inicialitzarRegistresEdicio(serveisForm);
    	
    	return new ModelAndView(ServeisView.EDITAR.getView(), SERVEIS_FORM , serveisForm);
    }

    
}
