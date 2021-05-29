package com.gigasystem.Users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception{
        //auth.userDetailsService(userDetailsService);
        auth.inMemoryAuthentication()
                .withUser("FlyNard")
                .password("CiNNaMoN212")
                .roles("ADMIN", "USER")
                .and()
                .withUser("azerty")
                .password("azerty")
                .roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin()
                .and().csrf().disable();
    }


    @Bean
    /*public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    public PasswordEncoder passwordEncoder() {return NoOpPasswordEncoder.getInstance();}
}
