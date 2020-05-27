package com.capgemini.main.security;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/****************************
 *          @author          Pranav Sinha
 *          Description      It is a spring security main class that provides the root for securing the application. 
  *         Version             1.0
  *         Created Date    18-APR-2020
 ****************************/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) {
	        auth.authenticationProvider(authProvider());
	    }
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .cors()
     .and()
.csrf().disable().

				authorizeRequests().antMatchers("/password-reset/*").permitAll().anyRequest().authenticated()
				.and().httpBasic();
	}
	
	 @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST","OPTIONS", "PUT", "PATCH", "DELETE" ));
	        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
	        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	
	
//    private UserDetailsService service;
//    @Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users=new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("pranav").password("root").roles("USER").build());
//		return new InMemoryUserDetailsManager(users);
//	}

}
