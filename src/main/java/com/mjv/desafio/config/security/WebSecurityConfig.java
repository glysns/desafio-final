package com.mjv.desafio.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String[] SWAGGER_WHITELIST = { "/v2/api-docs", 
			"/swagger-resources", "/swagger-resources/**",
			"/configuration/ui", "/configuration/security",
			"/swagger-ui.html", "/webjars/**"
			};
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	//https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().ignoringAntMatchers("/h2-console/**").disable()
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(SWAGGER_WHITELIST).permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		//temporário
		.antMatchers("/cadastros").permitAll()
		.antMatchers("/livros").permitAll()
		.antMatchers("/locacoes").permitAll()
		.anyRequest().authenticated()
		.and().headers().frameOptions().sameOrigin()
		.and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
