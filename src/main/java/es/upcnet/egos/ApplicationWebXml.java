package es.upcnet.egos;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Necesario para desplegar la aplicación en modo WAR en cualquier servidor 
 * de aplicaciones, ya que la configuración por defecto de Spring Boot es
 * ejecutar la aplicación desde un JAR con un servidor embebido.
 * A tener en cuenta que esta configuración permite trabajar con las dos soluciones
 * JAR o WAR. Con lo cual desde el IDE, se utiliza la versión JAR y fuera 
 * del entorno de desarrollo se despliega como WAR.
 * Para que funcione correctamente en modo WAR además de esta clase, es necesario
 * informar en el pom.xml que el servidor de aplicaciones será "provided".
 * 
 * 		<dependency>
 *		 <groupId>org.springframework.boot</groupId>
 *			<artifactId>spring-boot-starter-tomcat</artifactId>
 *			<scope>provided</scope>
 *		</dependency>
 *
 *
 */
public class ApplicationWebXml extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}