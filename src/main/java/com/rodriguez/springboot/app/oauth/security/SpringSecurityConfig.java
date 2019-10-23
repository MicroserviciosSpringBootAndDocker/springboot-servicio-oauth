package com.rodriguez.springboot.app.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rodriguez.springboot.app.oauth.security.event.AuthenticationSuccessErrorHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//eventos de succes o error
	@Autowired
	private AuthenticationSuccessErrorHandler eventPublisher;
	
	@Autowired
	private UserDetailsService usuarioService;

	@Bean //permire registrar objetos y componentes en el contenedor de spring
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder())
		//Evento publisher
		.and().authenticationEventPublisher(eventPublisher);
		;
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	
	
	

}
