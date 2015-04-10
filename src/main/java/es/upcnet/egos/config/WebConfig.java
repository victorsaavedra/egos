package es.upcnet.egos.config;

import java.util.Properties;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
@ComponentScan(basePackages = { "es.upcnet.egos.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

		exceptionResolver.setExceptionMappings(exceptionMappingsProperties());
		exceptionResolver.setStatusCodes(statusCodeProperties());

		return exceptionResolver;
	}
		
	private Properties exceptionMappingsProperties() {
		Properties exceptionMapping =  new Properties();

		exceptionMapping.put("java.lang.Exception", "error/serverError");
		exceptionMapping.put("java.lang.RuntimeException", "error/serverError");
		
		return exceptionMapping;
		
	}
	
	private Properties statusCodeProperties() {
		Properties statusCodes =  new Properties();

		//TODO revisar si hace falta incluir algún otro código, de seguridad 403 etc...
		statusCodes.put("error/404", "404");
		statusCodes.put("error/error", "500");
		
		return statusCodes;
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("cataleg/cataleg");
		super.addViewControllers(registry);
	}
	
	@Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        
        return characterEncodingFilter;
    }


}
