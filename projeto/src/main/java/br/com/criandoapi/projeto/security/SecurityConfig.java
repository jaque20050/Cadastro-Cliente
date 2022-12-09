package br.com.criandoapi.projeto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public void configure(HttpSecurity httpSec) throws Exception {


		/*
		 * Está desabilitando todos os acessos a nossa API
		 */
		httpSec.csrf().disable()
						.authorizeHttpRequests()
						.antMatchers(HttpMethod.GET, "/usuarios").permitAll()
						.anyRequest().authenticated().and().cors();
		
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}

//@Configuration
//@EnableWebSecurity
//class SecurityConfiguration() {
//
//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http.authorizeHttpRequests().anyRequest().authenticated()
//            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and().formLogin().disable().httpBasic()
//        return http.build()
//    }
//
//    @Bean
//    fun encoder(): PasswordEncoder? {
//        return BCryptPasswordEncoder()
//    }
//
//}