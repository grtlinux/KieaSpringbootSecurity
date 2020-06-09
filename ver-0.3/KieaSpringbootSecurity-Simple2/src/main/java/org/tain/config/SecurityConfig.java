package org.tain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		List<UserDetails> lstUser = new ArrayList<>();
		lstUser.add(User.withDefaultPasswordEncoder().username("kang").password("kang123").roles("USER").build());
		lstUser.add(User.withDefaultPasswordEncoder().username("kiea").password("kiea123").roles("USER").build());
		return new InMemoryUserDetailsManager(lstUser);
	}
	*/
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	/*
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			// Spring Security should completely ignore URLs starting with /resources/
			.antMatchers("/resources/**");
		//super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
			.hasRole("USER").and()
			// Possibley more configuration ...
			.formLogin() // enable form based login
			// set permitAll for all URLs associated with Form Login
			.permitAll();
			
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().disable();
		//super.configure(http);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			// enable in memory based authentication with a user named "user" and "admin"
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER")
			.and()
				.withUser("admin").password("password").roles("USER", "ADMIN");
		//super.configure(auth);
	}
	*/
}
