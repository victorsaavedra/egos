package es.upcnet.egos.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.form.CatalegForm;
import es.upcnet.egos.service.interfaces.CatalegService;
import es.upcnet.egos.view.CatalegView;

@RequestMapping("/")
@Controller
public class CatalegController {
	 private static final Logger logger = LoggerFactory.getLogger(CatalegController.class);
	 private static final String CATALEG_FORM = "catalegForm";
	 
	 @Autowired
	 private CatalegService catalegService;
	 
	 
	@RequestMapping(method = RequestMethod.GET)
    public final ModelAndView list(CatalegForm catalegForm, HttpServletRequest request) {
		logger.info("Accedir a la vista del catàleg. Busca en cas que fos necessari.");
		
		catalegService.inicialitzarCatalegForm(catalegForm);
		
		final List<SistemaInformacio> registresServeisCerca = catalegService.findServeiByCriteriCerca(catalegForm);
		final List<SistemaInformacio> registresSubscripcioCerca = catalegService.findSubscripcioByCriteriCerca(catalegForm);
		catalegForm.setRegistresServeisCataleg(registresServeisCerca);
		catalegForm.setRegistresSubscripcionsCataleg(registresSubscripcioCerca);
		
		String password="secret";
		MessageDigest sha256;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(password.getBytes("UTF-8"));
			byte[] digest = sha256.digest();
			StringBuffer sb=new StringBuffer();
			for(int i=0; i<digest.length;i++){
			    sb.append(String.format("%02x", digest[i]));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

    	
    	return new ModelAndView(CatalegView.CERCA.getView(),CATALEG_FORM, catalegForm);
    }
	
}
