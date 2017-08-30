/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author G0006185
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.telefonica.oss.pocpz.model.entity")
public class DBConfiguration {
    
}
