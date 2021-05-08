package com.shiwang.webapp.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.shiwang.webapp")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public ViewResolver resolveView() {
		
		InternalResourceViewResolver viewresolver= new InternalResourceViewResolver();
		
		viewresolver.setPrefix("/WEB-INF/view/");
		viewresolver.setSuffix(".jsp");
		
		return viewresolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource dbsource= new ComboPooledDataSource();
		
		try {
			dbsource.setDriverClass(environment.getProperty("jdbc.driver"));
			dbsource.setJdbcUrl(environment.getProperty("jdbc.url"));
			dbsource.setUser(environment.getProperty("jdbc.user"));
			dbsource.setPassword(environment.getProperty("jdbc.password"));
			
			dbsource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
			dbsource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
			dbsource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
			dbsource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
			
		}catch(PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		return dbsource;
	}

}
