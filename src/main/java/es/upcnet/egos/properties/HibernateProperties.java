package es.upcnet.egos.properties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperties {
	
	@NonNull
	private Boolean showSql;
	
	@NonNull
	private String dialect;
	
	
}
