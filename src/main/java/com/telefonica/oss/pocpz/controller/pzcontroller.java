/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.controller;


import com.telefonica.oss.pocpz.model.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired private PizzaRepository pizzaRepository;
    
    @ResponseBody
    @RequestMapping()
    public String Hi() {
        
        return "Hi ;)";
    }
    @RequestMapping(value="/ola/{name}")
    @ResponseBody
    public String Hi(@PathVariable String name){

        return "Hi again "+name;
    }
    @RequestMapping(value="/howmany")
    @ResponseBody
    public String howMany(){
   
        return "Total: "+pizzaRepository.count();
    }
 
}
