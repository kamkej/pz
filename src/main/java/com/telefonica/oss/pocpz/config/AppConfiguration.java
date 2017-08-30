/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author G0006185
 */
public class AppConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.scan(AppConfiguration.class.getPackage().getName());
        sc.addListener(new ContextLoaderListener(webApplicationContext));
        sc.addListener(new RequestContextListener());
        ServletRegistration.Dynamic dispatcher = sc.addServlet("dispatcher", dispatcherServlet(webApplicationContext));
        
        dispatcher.setAsyncSupported(true);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
       
    }

    private DispatcherServlet dispatcherServlet(WebApplicationContext webApplicationContext) {
         return new DispatcherServlet(webApplicationContext);
    }
    
}
