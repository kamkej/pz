/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author G0006185
 */
@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
              .antMatchers("/pizzas/**","/ingredientes/**").hasRole("USER")
              .anyRequest().permitAll()
            .and()
                .formLogin()
                    .loginPage("/login.jsp")
                    .loginProcessingUrl("/autenticar")
                    .defaultSuccessUrl("/pizzas")
                    .failureUrl("/login.jsp?semacesso=true")
                .and()
                    .logout()
                        .logoutUrl("/sair")
                        .logoutSuccessUrl("/login.jsp?saiu=true")             
                ;      
          
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {        
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
    }
}
