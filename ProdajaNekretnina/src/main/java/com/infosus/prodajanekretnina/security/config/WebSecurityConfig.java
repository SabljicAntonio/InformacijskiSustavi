package com.infosus.prodajanekretnina.security.config;

import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import com.infosus.prodajanekretnina.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final KorisnikService korisnikService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AgentZaNekretnineService agentZaNekretnineService;
    @Autowired
    public WebSecurityConfig(KorisnikService korisnikService, AgentZaNekretnineService agentZaNekretnineService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.korisnikService = korisnikService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.agentZaNekretnineService = agentZaNekretnineService;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                    .antMatchers("/","/register/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated().and()
                .formLogin()
                    //.loginPage("/login") //tu ce bit nas login page al treba ga napravit prvo
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(korisnikService);
        provider.setUserDetailsService(agentZaNekretnineService);
        return provider;
    }
}
