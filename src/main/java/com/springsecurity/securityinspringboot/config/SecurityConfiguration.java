package com.springsecurity.securityinspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		@SuppressWarnings("deprecation")
		UserBuilder user = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(user.username("karthik").password("test123").roles("employee"))
		.withUser(user.username("soujitha").password("test123").roles("employee","admin"))
		.withUser(user.username("latha").password("test123").roles("employee","manager"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
			.antMatchers("/").hasRole("employee")
			.antMatchers("/manager/**").hasRole("manager")
			.antMatchers("/admin/**").hasRole("admin")
			.and()
			.formLogin()
			.loginPage("/ShowLoginForm")
			.loginProcessingUrl("/AuthenticateUser")
			.permitAll()
		.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");			
	}
	
	
	
}
