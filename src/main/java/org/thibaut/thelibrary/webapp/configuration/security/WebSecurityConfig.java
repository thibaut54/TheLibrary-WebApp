package org.thibaut.thelibrary.webapp.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thibaut.thelibrary.webapp.security.UserDetailsServiceImpl;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {

		// Setting Service to find User in the database.
		// And Setting PassswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}


	@Override
	protected void configure( HttpSecurity http ) throws Exception {

		http.csrf().disable();


		// /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
		// If no login, it will redirect to /login page.
		http.authorizeRequests().antMatchers(
				"/user/**")
				.access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//
//		// For ADMIN only.
//		http.authorizeRequests().antMatchers(
//				"/admin/**")
//				.access("hasRole('ROLE_ADMIN')");
//		http.exceptionHandling().accessDeniedPage( "/error/403" );

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
//		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/public/403");

		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
//				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
//				.loginPage("/public/login")
				.defaultSuccessUrl("/user/bookTitle")//
//				.failureUrl("/public/login?error=true")//
//				.usernameParameter("username")//
//				.passwordParameter("password")
//				//Config for Logout Page
				.and()
				.logout().logoutUrl("/public/logout").logoutSuccessUrl("/public/logoutSuccessful");
//
//		http.authorizeRequests().antMatchers(
//				"/public/**").permitAll();
//		// The pages does not require login
	}

}
