package calendApp.web;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
*
* @author Adrian Gross
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/index.html", "/favicon.ico", "/css/**", "/images/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/users/**")
			.authorizeRequests()
				.antMatchers(GET,  "/**").permitAll()
				.antMatchers(POST, "/**").permitAll();

		http.antMatcher("/events/**")
			.authorizeRequests()
				.antMatchers(GET,  "/**").permitAll()
				.antMatchers(POST, "/**").permitAll();
				
		// http.formLogin().loginPage("/login");
		
		/*
		http.antMatcher("/login/**")
		.authorizeRequests()
			.antMatchers(GET,  "/**").permitAll()
			.antMatchers(POST, "/**").permitAll();
		
		http.antMatcher("/logout/**")
		.authorizeRequests()
			.antMatchers(GET,  "/**").permitAll()
			.antMatchers(POST, "/**").permitAll();
			
			*/
		// @formatter:on

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.httpBasic();
	}
	
	/*
	 @Override
	    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
	        authManagerBuilder.inMemoryAuthentication()
	                .withUser("ralf").password("password").roles("USER");
	    }
*/
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}

}
