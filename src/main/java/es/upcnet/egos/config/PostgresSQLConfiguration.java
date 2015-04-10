package es.upcnet.egos.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.upcnet.egos.properties.HibernateProperties;
import es.upcnet.egos.properties.PostgreSQLProperties;




@Configuration
@EnableJpaRepositories(basePackages = "es.upcnet.egos.repository")
@EnableTransactionManagement
public class PostgresSQLConfiguration {
	@Autowired
	private PostgreSQLProperties postgreSQLProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(postgreSQLProperties.getDatabaseUrl());
		dataSource.setUsername(postgreSQLProperties.getUsername());
		dataSource.setPassword(postgreSQLProperties.getPassword());
		dataSource.setDriverClassName(postgreSQLProperties.getDriverClassName());

		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		vendorAdapter.setGenerateDdl(false);
 	
		entityManagerFactoryBean.setPackagesToScan("es.upcnet.egos.domain");
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(jpaProperties());

		return entityManagerFactoryBean;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	private Properties jpaProperties() {
		Properties jpaProperties = new Properties();
	
		//TODO validar si hacen falta otras propiedades en función del entorno y si se trata o no de un contexto de test
		//jpaProperties.put("hibernate.format_sql", "");
		//jpaProperties.put("hibernate.hbm2ddl.auto", "");
		//jpaProperties.put("hibernate.ejb.naming_strategy", "");
	        
		jpaProperties.setProperty("hibernate.dialect", hibernateProperties.getDialect());
		jpaProperties.setProperty("hibernate.connection.charSet", "UTF-8");
		jpaProperties.put("hibernate.show_sql", hibernateProperties.getShowSql());
		
		return jpaProperties;
	}
	
}


