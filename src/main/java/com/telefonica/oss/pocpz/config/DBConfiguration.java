/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author G0006185
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.telefonica.oss.pocpz.model.repository")
public class DBConfiguration {
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    	return new JpaTransactionManager(emf);
    }
    @Bean
    public DataSource dataSource() throws NamingException, PropertyVetoException  {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
	dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
	dataSource.setJdbcUrl("jdbc:oracle:thin:@//10.200.6.204:1521/desenv");
	dataSource.setUser("ENG_DEV");
	dataSource.setPassword("Vivo15#");
	return dataSource;
   }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IllegalStateException, PropertyVetoException, NamingException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	entityManagerFactoryBean.setDataSource(dataSource());
	entityManagerFactoryBean.setPackagesToScan("com.telefonica.oss.pocpz.model.entity");
	entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		
	Properties jpaProterties = new Properties();
	jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
	jpaProterties.put("hibernate.hbm2ddl.auto", "update");
	entityManagerFactoryBean.setJpaProperties(jpaProterties);
	return entityManagerFactoryBean;

    }     

    
}
