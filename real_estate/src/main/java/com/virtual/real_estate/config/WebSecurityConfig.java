package com.virtual.real_estate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier(value = "customUserDetailService")
	private UserDetailsService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/signup", "/login",
						"/loginAuth","/notice", "/forgot-password",
						"/notice/faq/**", "/notice/nontification/**",
						"/resources/css/**", "/resources/assets/**", "/resources/js/**")
				.permitAll() // 누구나 접근 허용
				.anyRequest().authenticated()
	        .and()
	        	.formLogin()
	        		.loginPage("/login")
	        		.loginProcessingUrl("/loginAuth")
	        		.defaultSuccessUrl("/")
	        		.usernameParameter("userId")
	        		.passwordParameter("pass")
    		.and()
    			.logout()
    				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    				.logoutSuccessUrl("/")
    				.invalidateHttpSession(true)
			.and()
				.headers().frameOptions().disable()
			.and()
				.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncode());
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
}
