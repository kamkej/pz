/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.config.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author G0006185
 */
@Controller
@RequestMapping(value="/")
public class pzcontroller {
    private static final Logger log = LoggerFactory.getLogger(pzcontroller.class);
    
    @ResponseBody
    @RequestMapping()
    public String Hi(){
        log.info("passou2");
        return "Hi ;)";
       
    }
    @RequestMapping(value="/ola/{name}")
    @ResponseBody
    public String Hi(@PathVariable String name){
        return "Hi again "+name;
    }
}
