package es.upcnet.egos.properties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "postgreSQL")
public class PostgreSQLProperties {
	
	@NonNull
	private String databaseUrl;
	
	@NonNull
	private String username;
	
	@NonNull
	private String password;
	
	@NonNull
	private String driverClassName;

}
