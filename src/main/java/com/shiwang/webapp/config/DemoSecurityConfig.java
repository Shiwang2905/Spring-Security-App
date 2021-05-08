package com.shiwang.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
@Configuration
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dbdatasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.jdbcAuthentication().dataSource(dbdatasource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
								.antMatchers("/").hasRole("EMPLOYEE")
								.antMatchers("/managers").hasRole("MANAGER")
								.antMatchers("/admin").hasRole("ADMIN")
								.and()
								.formLogin()
								.loginPage("/loginuser")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
								.and()
								.logout()
								.permitAll()
								.and()
								.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	

}
