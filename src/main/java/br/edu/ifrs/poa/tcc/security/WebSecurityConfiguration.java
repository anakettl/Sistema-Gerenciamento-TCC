package br.edu.ifrs.poa.tcc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private AuthProviderService authProvider;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/dashboard").hasRole("DASHBOARD")
                .antMatchers("/usuario").hasRole("USUARIO")
                .anyRequest().authenticated()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/negado")
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("senha")
                .failureUrl("/login?error=1")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .permitAll();
    }


}